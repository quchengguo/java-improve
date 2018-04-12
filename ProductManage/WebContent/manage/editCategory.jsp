<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/manage/header.jsp" %>
	<form action="${pageContext.request.contextPath}/CategoryServlet" method="post">
		<input type="hidden" name="op" value="edit"/>
		<input type="hidden" name="cid" value="${c.cid}"/>
		
		<table style="width:500px;">
			<tr>
				<td>分类名称:</td><td><input type="text" name="cname" value="${c.cname}"/><span></span></td>
			</tr>
			<tr>
				<td>分类描述:</td><td><textarea name="description" rows="3">${c.description}</textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="提交"/></td>
			</tr>
		</table>
		 
	</form>
</body>
</html>