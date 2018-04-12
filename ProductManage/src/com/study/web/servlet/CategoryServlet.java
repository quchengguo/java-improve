package com.study.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.study.domain.Category;
import com.study.service.CategoryService;
import com.study.service.impl.CategoryServiceImpl;

import net.sf.json.JSONArray;

/**
 * 根据op的值，执行响应的操作
 */
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
//		System.out.println("CategoryServlet --> doGet");
		String op = request.getParameter("op");
		if("add".equals(op)){
			try {
				addCategory(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if("find".equals(op)){
			// header.jsp 过来的op
			findCategory(request, response);
		}else if("del".equals(op)){
			delCategory(request, response);
		}else if("findById".equals(op)){
			findById(request, response);
		}else if("edit".equals(op)){
			updateCategory(request, response);
		}else if("get".equals(op)){
			getCategory(request, response);
		}
	}
	
	private void getCategory(HttpServletRequest request, HttpServletResponse response) {
		try{
			CategoryService service = new CategoryServiceImpl();
			List<Category> cs = service.findCategory();
			JSONArray arr = JSONArray.fromObject(cs);
			response.getWriter().println(arr);
		}catch(Exception e){
			System.out.println(e.getMessage());
			
		}
	}

	private void updateCategory(HttpServletRequest request, HttpServletResponse response) {
		try{
			Category c = new Category();
			BeanUtils.populate(c, request.getParameterMap());
			
			CategoryService service = new CategoryServiceImpl();
			service.updateCategory(c);
			
			request.setAttribute("msg", "修改分类成功！<a href='"+request.getContextPath()+"/CategoryServlet?op=find'>继续查看</a>");
			request.getRequestDispatcher("/manage/message.jsp").forward(request, response);
			return;
		}catch(Exception e){
			System.out.println(e.getMessage());
			request.setAttribute("msg", "修改分类失败！请联系管理员");
			try {
				request.getRequestDispatcher("/manage/message.jsp").forward(request, response);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	private void findById(HttpServletRequest request, HttpServletResponse response){
		try {
			System.out.println("CategoryServlet findById");
			String id = request.getParameter("cid");
			Integer cid = new Integer(id);
			
			CategoryService service = new CategoryServiceImpl();
			Category c = service.findById(cid);
			
			// 找到分类
			request.setAttribute("c", c);
			request.getRequestDispatcher("/manage/editCategory.jsp").forward(request, response);
			return;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			request.setAttribute("msg", "查找分类失败！请联系系统管理员");
			try {
				request.getRequestDispatcher("/manage/message.jsp").forward(request, response);
			} catch (Exception e1) {
				e1.printStackTrace();
			} 
			return;
		}
	}

	private void delCategory(HttpServletRequest request, HttpServletResponse response) {
		// 获取要删除的id
		String id = request.getParameter("cid");
		Integer cid = new Integer(id);
		
		CategoryService service  = new CategoryServiceImpl();
		try {
			service.delCategory(cid);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			request.setAttribute("msg", "删除分类失败！请联系系统管理员");
			try {
				request.getRequestDispatcher("/manage/message.jsp").forward(request, response);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			return;
			
		}
		// 删除成功，跳转到查询页面
		findCategory(request, response);
		return;
	}

	private void findCategory(HttpServletRequest request, HttpServletResponse response){
		try {
			CategoryService service = new CategoryServiceImpl();
			List<Category> cs = service.findCategory();
//			System.out.println("findCategory cs size: " + cs.size());
			
			request.setAttribute("cs", cs);
			request.getRequestDispatcher("/manage/listCategory.jsp").forward(request, response);
			return;
		} catch (Exception e) {
			System.out.println("e.getMessage: " + e.getMessage());
			request.setAttribute("msg", "查询分类失败！请联系管理员");
			try {
				request.getRequestDispatcher("/manage/message.jsp").forward(request, response);
			} catch (Exception e1) {
				e1.printStackTrace();
			} 
			return;
		}
	}

	private void addCategory(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {
			// 修改或者添加时都使用BeanUtils.populate方法
			Category c  = new Category();
			BeanUtils.populate(c, request.getParameterMap());
			
			// 面向接口编程，提高可扩展性
			CategoryService service = new CategoryServiceImpl();
			service.addCategory(c);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			request.setAttribute("msg", "添加分类失败！请联系管理员");
			request.getRequestDispatcher("/manage/message.jsp").forward(request, response);
			return;
		}
		System.out.println("添加分类");
		request.setAttribute("msg", "添加分类成功!<a href='"+request.getContextPath()+"/manage/addCategory.jsp'>继续添加</a>");
		request.getRequestDispatcher("/manage/message.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
