<%@page import="lzj.DAO.AddressDao"%>
<%@page import="lzj.entity.Address"%>
<%@page import="lzj.DaoImpl.AddressDaoImpl"%>
<%@page import="lzj.entity.Order"%>
<%@page import="lzj.DaoImpl.OrderDaoImpl"%>
<%@page import="lzj.DAO.OrderDao"%>
<%@page import="lzj.DaoImpl.UserDaoImpl"%>
<%@page import="lzj.entity.User"%>
<%@page import="lzj.entity.Goods"%>
<%@page import="lzj.DaoImpl.GoodsDaoImpl"%>
<%@page import="lzj.DAO.GoodsDao"%>
<%@page import="lzj.entity.ShopCar"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	User user = (User) session.getAttribute("user");
	if (user == null) {
		response.sendRedirect("ShopIndex.jsp");
		return;
	}
	user = new UserDaoImpl().findUserByUid(user.getUid()).get(0);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人中心</title>
<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<a href="ShopIndex.jsp">首页</a>
	<p>
		<img alt="" src="usericon/<%=user.getIcon()%>">
	</p>
	<form action="UpLoadUserIcon" method="post"
		enctype="multipart/form-data">
		请选择上传的图片:<input type="file" name="fileName" /><input type="submit"
			value="上传" />
	</form>



	<p>
		用户Id：<%=user.getUid()%></p>
	<p>
		用户名：<%=user.getUsername()%></p>
	<table class="table table-bordered">
		<caption>购物车</caption>
		<thead>
			<tr>
				<th>物品</th>
				<th>数量</th>
				<th>价格</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<%
				double totalprice = 0;
				GoodsDao goodsdao = new GoodsDaoImpl();

				for (ShopCar shopcar : user.getShopCar()) {
					Goods goods = goodsdao.findGoods(shopcar.getGoodsId());
					if (goods != null) {
			%>
			<tr>
				<td><%=goods.getGoodsName()%></td>
				<td><%=shopcar.getNum()%></td>
				<td><%=goods.getGoodsPrice()%></td>
				<td><a href="DelShopCarList?gid=<%=goods.getGoodsId()%>">删除</a><a><form
							action="UpdateCarNum?gid=<%=goods.getGoodsId()%>" method="post">
							<input type="text" name="num" value="<%=shopcar.getNum()%>" /><input
								type="submit" value="更新" />
						</form></a></td>
			</tr>
			<%
				totalprice += (goods.getGoodsPrice() * shopcar.getNum());
					}
				}
			%>

			<tr>
				<td>
					<form action="Order" method="get">
						<select name="sid">
							<%
								AddressDao addressDao = new AddressDaoImpl();
								ArrayList<Address> addressList = addressDao.findAddressByUid(user.getUid());
							%>
							<%
								for (Address address : addressList) {
							%>
							<option value="<%=address.getAdressId()%>"><%=address.getSendName() + "  " + address.getAdress() + "  " + address.getPhoneNumber()%></option>
							<%
								}
							%>
						</select> <input type="submit" value="下订单">
					</form>
				</td>
				<td></td>
				<td></td>
				<td>总价格:<%=totalprice%></td>
			</tr>
		</tbody>

	</table>

	<%
		OrderDao orderDao = new OrderDaoImpl();
		ArrayList<Order> al = orderDao.findOrderByUid(user.getUid());
	%>
	<table class="table table-bordered">
		<caption>订单列表</caption>
		<thead>
			<tr>
				<th>订单ID</th>
				<th>物品</th>
				<th>数量</th>
				<th>价格</th>
				<th>时间</th>
				<th>总价</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (Order o : al) {
					ArrayList<Goods> alg = o.getArrayListGoods();
			%>

			<tr>


				<td><%=o.getOrderId()%></td>
				<td>
					<%
						for (Goods g : alg) {
					%> <%=g.getGoodsName()%><br> <%
 	}
 %>
				</td>
				<td>
					<%
						for (Goods g : alg) {
					%> <%=g.getNum()%><br> <%
 	}
 %>
				</td>
				<td>
					<%
						for (Goods g : alg) {
					%> <%=g.getGoodsPrice()%><br> <%
 	}
 %>
				</td>
				<td><%=o.getTime()%></td>
				<td><%=o.getTotalPrice()%></td>

			</tr>

			<%
				}
			%>
		</tbody>

	</table>
</body>
</html>