<%@page import="java.util.ArrayList"%>
<%@page import="lzj.DaoImpl.UserDaoImpl"%>
<%@page import="lzj.DAO.UserDao"%>
<%@page import="lzj.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<table class="table">
		<caption>用户管理</caption>
		<thead>
			<tr>
				<th>用户名</th>
				<th>密码</th>
				<th>权限</th>
				<th>管理</th>
			</tr>
		</thead>
		<%
			UserDao userDao = new UserDaoImpl();
			int pages = 1;
			ArrayList<User> userList = userDao.findUserByPage(pages);
		%>
		<tbody>
			<%
				String type = "active";
				for (User u : userList) {
					if (u.getUserType() == 0) {
						type = "danger";
					}
					if (u.getUserType() == 1) {
						type = "warning";
					}
					if (u.getUserType() == 2) {
						type = "success";
					}
			%>
			<tr class="<%=type%>">
				<td><%=u.getUsername()%></td>
				<td><%=u.getPassword()%></td>
				<td><%=u.getUserType()%></td>
				<td><a href="DelUser?uid=<%=u.getUid()%>">删除</a><a
					href="EditUser.jsp?uid=<%=u.getUid()%>">修改</a></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
</body>
</html>