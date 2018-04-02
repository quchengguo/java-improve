<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
	<h1>首页</h1>
	<hr />
	<c:choose>
		<c:when test="${user != null}">
			欢迎<font color="red">${user.username}</font>登陆！
			<a href="${pageContext.request.contextPath}/LogoutServlet">注销</a>
		</c:when>
		<c:otherwise>
			<a href="${pageContext.request.contextPath}/login.jsp">登陆</a>
		</c:otherwise>
	</c:choose>
	<a href="${pageContext.request.contextPath}/important/important.html">重要的WEB资源</a>
	
</body>
</html>