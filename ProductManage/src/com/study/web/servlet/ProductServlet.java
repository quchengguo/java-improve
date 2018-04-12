package com.study.web.servlet;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import com.study.domain.Product;
import com.study.service.ProductService;
import com.study.service.impl.ProductServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 商品servlet
 */
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
//		System.out.println("op: " + op);
		if("add".equals(op)){
			// addProduct.jsp通过url传递过来的
			addProduct(request, response);
		}else if("find".equals(op)){
			// listProduct.jsp过来的find
			try {
				String cid = request.getParameter("categoryid");
				if("".equals(cid)){
					findProduct(request, response);
				}else{
					findProductByCategory(request, response, cid);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if("del".equals(op)){
			delProduct(request, response);
		}else if("delMulti".equals(op)){
			delMultiProduct(request, response);
		}else if("findById".equals(op)){
			// editProduct.jsp findProductById过来的op
			findProductById(request, response);
		}else if("edit".equals(op)){
			// eidtProduct.jsp updateProduct过来的 op
			updateProductById(request, response);
		}
	}

	private void updateProductById(HttpServletRequest request, HttpServletResponse response) {
		try{
			Product product = new Product();
			BeanUtils.populate(product, request.getParameterMap());
			
			ProductService service = new ProductServiceImpl();
//			Product product = service.findProductById(pid); 注意这个错误
			
			service.updateProductById(product);
			response.getWriter().print("success");
			
		}catch(Exception e){
			try {
				response.getWriter().print("error");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	private void findProductById(HttpServletRequest request, HttpServletResponse response) {
		try{
			String id = request.getParameter("pid");
			Integer pid = new Integer(id);
			ProductService service = new ProductServiceImpl();
			Product product = service.findProductById(pid);
			JSONObject productObj = JSONObject.fromObject(product);
			System.out.println(productObj.toString());
			response.getWriter().print(productObj.toString());
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void delMultiProduct(HttpServletRequest request, HttpServletResponse response) {
		try{
			String pids = request.getParameter("pids");
			ProductService service = new ProductServiceImpl();
			service.delMultiProduct(pids);
			response.getWriter().print("success");
		}catch(Exception e){
			e.printStackTrace();
			try {
				response.getWriter().print("error");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	private void delProduct(HttpServletRequest request, HttpServletResponse response) {
		String pid = request.getParameter("pid");
		try{
			ProductService service = new ProductServiceImpl();
			service.delProduct(pid);
			response.getWriter().print("success");
		}catch(Exception e){
			try {
				response.getWriter().print("error");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	private void findProductByCategory(HttpServletRequest request, HttpServletResponse response, String cid) {
		try {
			Integer categoryid = new Integer(cid);
			ProductService service = new ProductServiceImpl();
			List<Product> products = service.findProductByCategory(categoryid);
			
			JSONArray productArr = JSONArray.fromObject(products);
			response.getWriter().print(productArr.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	private void findProduct(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			ProductService service = new ProductServiceImpl();
			List<Product> products = service.findProduct();
			
			JSONArray productArr = JSONArray.fromObject(products);
			response.getWriter().print(productArr.toString());
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void addProduct(HttpServletRequest request, HttpServletResponse response) {
		try{
			boolean flag = ServletFileUpload.isMultipartContent(request);
			if(!flag){
				setMsg(request, response, "请求方式错误！");
				return;
			}
			// 创建磁盘工厂对象
			DiskFileItemFactory dfif = new DiskFileItemFactory();
			// 常见文件上传核心对象
			ServletFileUpload upload = new ServletFileUpload(dfif);
			// 设置编码
			upload.setHeaderEncoding("UTF-8");
			// 解析对象
			List<FileItem> items = upload.parseRequest(request);
			
			Product p = new Product();
			// 每个FileItem可以看做table标签中的元素
			for(FileItem item : items){
				if(item.isFormField()){
					// 普通类型
					// 将普通表单项的值传递到productbean中,表单项的name对象bean中的属性
					String name = item.getFieldName();
					// 获取表单中的值
					String value = item.getString("UTF-8");
					BeanUtils.setProperty(p, name, value);
					
				}else{
					// 文件类型
					// 判断上传文件的类型
					String mimeType = item.getContentType();
					if(!mimeType.startsWith("image")){
						setMsg(request, response, "附件类型错误，请上传图片");
						return;
					}
					// 获取文件名称
					String fileName = item.getName();
					// 生成一个不会重复的文件名
					String newFileName = UUID.randomUUID() + "." + FilenameUtils.getExtension(fileName);
					// 以日期目录分类管理上传图片
					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
					String now = sdf.format(new Date());
					// 获取文件路径，文件易被清理(正式项目中会有文件服务器，且不会频繁的重启tomcat)
					String realPath = getServletContext().getRealPath("/manage/image/" + now);
					// 创建目录
					File imageFile = new File(realPath);
					if(!imageFile.exists()){
						// 创建多级目录
						imageFile.mkdirs();
					}
					// 创建上传的文件
					File uploadFile = new File(realPath, newFileName);
					// 流向： item -> uploadFile
					item.write(uploadFile);
					
					// 给product 的 path赋值
					p.setPath("/manage/image/" + now + "/" + newFileName);
				}
			}
			// javaBean传递给service，由service添加数据
			ProductService service = new ProductServiceImpl();
			service.addProduct(p);
			setMsg(request, response, "添加商品成功!<a href='"+request.getContextPath()+"/manage/addProduct.jsp'>继续添加</a>");
			return;
		}catch(Exception e){
			System.out.println(e.getMessage());
			try {
				setMsg(request, response, "添加商品失败，请联系管理员");
			} catch (Exception e1) {
				e1.printStackTrace();
			} 
			return;
		}
	}

	private void setMsg(HttpServletRequest request, HttpServletResponse response,String msg) throws ServletException, IOException {
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("/manage/message.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
