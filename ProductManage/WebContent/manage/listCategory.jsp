<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/manage/header.jsp" %>
	<script type="text/javascript">
		function confirmDel(cid){
			var flag = window.confirm("是否确定删除？")
			if(flag){
				// 用户确定删除
				window.location = "${pageContext.request.contextPath}/CategoryServlet?op=del&cid=" + cid;
			}
		}
	</script>
	<table>
		<td>分类名称</td>
		<td>分类描述</td>
		<td>操作</td>
		<c:forEach var="c" items="${cs}">
			<tr>
				<td>${c.cname}</td>
				<td>${c.description}</td>
				<%-- <td>[<a href="${pageContext.request.contextPath}/CategoryServlet?op=del&cid=${c.cid}">删除</a> | <a href="${pageContext.request.contextPath}/CategoryServlet?op=findById&cid=${c.cid}">修改</a>]</td> --%>
				<td>[<a href="#" onclick="confirmDel(${c.cid})">删除</a> | <a href="${pageContext.request.contextPath}/CategoryServlet?op=findById&cid=${c.cid}">修改</a>]</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>