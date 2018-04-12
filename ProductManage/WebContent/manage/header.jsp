<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>

<title>商品管理系统</title>
</head>
<body>
	<br/>
	<h1>商品管理系统</h1>
	<br/>
	<a href="${pageContext.request.contextPath}/manage/addCategory.jsp">添加分类</a>
	&nbsp;&nbsp;
	<a href="${pageContext.request.contextPath}/CategoryServlet?op=find">查询分类</a>
	&nbsp;&nbsp;
	<a href="${pageContext.request.contextPath}/manage/addProduct.jsp">添加商品</a>
	&nbsp;&nbsp;
	<a href="${pageContext.request.contextPath}/manage/listProduct.jsp">查询商品</a>
	<br/>
	<hr />