<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>展示学生信息</title>
</head>
<body>
	<table border="1" width="500">
		<tr>
			<td>姓名</td>
			<td>性别</td>
			<td>年龄</td>
		</tr>
		<c:forEach items="${list}" var="student">
			<tr>
				<td>${student.sname}</td>
				<td>${student.gender}</td>
				<td>${student.age}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>