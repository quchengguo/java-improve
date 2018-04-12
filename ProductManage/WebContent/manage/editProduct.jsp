<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/manage/header.jsp" %>
	<script type="text/javascript">
	function checkForm(){
		var cname = $("input[name=cname]").val();
		if(cname == ""){
			$("span").html("分类名称不能为空");
			return false;
		}
		return true;
	}
	
	function getCategory(){
		// 注意ajax的异步加载，每次刷新editProduct.jsp时，发送一次请求
		$.ajax({
			type:"GET",
			url:"${pageContext.request.contextPath}/CategoryServlet?op=get",
			dataType:"json",
			success:function(data){
				$(data).each(function(){
					$("select[name=categoryid]").append("<option value='"+this.cid+"'>"+this.cname+"</option>");
				});
			}
		});
	}
	
	function findProductById(){
		var pid = $("input[name=pid]").val();
		$.ajax({
			type:"GET",
			url:"${pageContext.request.contextPath}/ProductServlet?op=findById&pid=" + pid,
			dataType:"json",
			success:function(data){
				if(data != null){
					$("input[name=pname]").val(data.pname);
					/* $("select[name=categoryid]").val(data.categoryid); 废话*/
					$("input[name=price]").val(data.price);
					$("textarea[name=pdescription]").val(data.pdescription);
				}else{
					alert("查找商品信息失败！请联系管理员!");
				}
			}
		});
	}
	
	function updateProduct(){
		/*serialize()序列表表格内容为字符串*/
		var formData = $("form").serialize();
		
		$.ajax({
			type:"GET",
			url:"${pageContext.request.contextPath}/ProductServlet",
			data:formData,
			success:function(msg){
				if(msg == "success"){
					alert("修改成功!");
				}else{
					alert("修改失败，请联系管理员");
				}
			}
		});
		
	}
	$(function(){
		/* $("form").submit(function(){
			return checkForm();
		}); */
		/* 将submit替换为button*/
		$("#button01").click(function(){
			var flag = checkForm();
			if(flag){
				updateProduct();
			}
		});
		
		getCategory();
		findProductById();
	});
	</script>
	<form action="${pageContext.request.contextPath}/ProductServlet" method="post">
		<input type="hidden" name="op" value="edit"/>
		<input type="hidden" name="pid" value="${param.pid}"/>
		
		<table style="width:500px;">
			<tr>
				<td>商品名称:</td><td><input type="text" name="pname"/><span></span></td>
			</tr>
			<tr>
				<td>商品分类:</td><td><select name="categoryid" style="width:180px;"></select></td>
			</tr>
			<tr>
				<td>商品价格:</td><td><input type="text" name="price"/></td>
			</tr>
			<tr>
				<td>商品描述:</td><td><textarea rows="3" name="pdescription"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="button" id="button01" value="提交"/></td>
			</tr>
		</table>
	</form>
	
</body>
</html>