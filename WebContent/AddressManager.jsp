<%@page import="java.util.ArrayList"%>
<%@page import="lzj.entity.User"%>
<%@page import="lzj.DaoImpl.AddressDaoImpl"%>
<%@page import="lzj.DAO.AddressDao"%>
<%@page import="lzj.entity.Address"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	User user = (User) session.getAttribute("user");
	if (user == null) {
		response.sendRedirect("ShopIndex.jsp");
		return;
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>地址管理</title>
<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<a href="AddAddress.jsp">添加地址信息</a>
	<table class="table">
		<caption>送货地址列表</caption>
		<thead>
			<tr>
				<th>联系人</th>
				<th>电话号码</th>
				<th>地址</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<%
				AddressDao addressDao = new AddressDaoImpl();
				ArrayList<Address> addressList = addressDao.findAddressByUid(user.getUid());
				for (Address a : addressList) {
			%>
			<tr>
				<td><%=a.getSendName()%></td>
				<td><%=a.getPhoneNumber()%></td>
				<td><%=a.getAdress()%></td>
				<td><a href="DelAddress?aid=<%=a.getAdressId()%>">删除</a><a
					href="EditAddress.jsp?aid=<%=a.getAdressId()%>">修改</a></td>
			</tr>
			<%
				}
			%>


		</tbody>
	</table>
</body>
</html>