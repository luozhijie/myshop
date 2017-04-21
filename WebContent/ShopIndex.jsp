<%@page import="lzj.DaoImpl.UserDaoImpl"%>
<%@page import="lzj.DAO.UserDao"%>
<%@page import="lzj.entity.User"%>
<%@page import="lzj.DaoImpl.RememberMeDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品主页</title>
</head>
<body>
	<%
		int uid = 0;
		String md5 = "";
		Cookie[] cookies = request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals("myshopuid")) {
				uid = Integer.valueOf(cookies[i].getValue());
			}
			if (cookies[i].getName().equals("myshopmd5")) {
				md5 = cookies[i].getValue();
			}
		}
	%>
	<%
		User user = null;
		User sessionUser = (User) session.getAttribute("user");
		if (sessionUser == null && new RememberMeDaoImpl().findRememberMyByUidAndMd5(uid, md5) == null) {
	%>
	<p>
		<a href="Login.jsp">登录</a>
	</p>
	<%
		} else {
			if (sessionUser == null) {
				UserDao userdao = new UserDaoImpl();
				user = userdao.findUserByUid(uid).get(0);
			} else {
				user = sessionUser;
			}
	%>
	欢迎：<%=user.getUsername()%>
	<%
		}
	%>
</body>
</html>