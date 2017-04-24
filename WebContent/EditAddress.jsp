<%@page import="lzj.entity.Address"%>
<%@page import="lzj.DaoImpl.AddressDaoImpl"%>
<%@page import="lzj.DAO.AddressDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改地址信息</title>
</head>
<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<%
		int sid = Integer.valueOf(request.getParameter("aid"));
		AddressDao addressDao = new AddressDaoImpl();
		Address address = addressDao.findAddressByAid(sid);
	%>
	<form action="EditAddress" method="post">
		<input type="hidden" name="sid" value="<%=sid%>"> 联系人：<input
			name="name" value="<%=address.getSendName()%>"><br>
		电话号码：<input name="phoneNumber" value="<%=address.getPhoneNumber()%>"><br>
		详细地址：
		<textarea rows="8" cols="50" name="address"><%=address.getAdress()%></textarea>
		<br> <input type="submit" value="提交">
	</form>
</body>
</html>