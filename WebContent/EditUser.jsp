<%@page import="lzj.entity.User"%>
<%@page import="lzj.DaoImpl.UserDaoImpl"%>
<%@page import="lzj.DAO.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户编辑</title>
<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
</head>
<body>
	<%
		UserDao userDao = new UserDaoImpl();
		User user = userDao.findUserByUid(Integer.valueOf(request.getParameter("uid"))).get(0);
	%>
	<form action="EditUser" method="post">
		<input type="hidden" name="uid" value="<%=user.getUid()%>">
		id:<%=user.getUid()%><br> 用户名:<%=user.getUsername()%><br>
		密码:<input type="password" name="pwd" value="<%=user.getPassword()%>"><br>
		确认密码:<input type="password" name="ckpwd" value="<%=user.getPassword()%>"><br>
		<input type="submit" value="提交">
	</form>
</body>
</html>