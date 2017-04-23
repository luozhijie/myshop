<%@page import="lzj.entity.Goods"%>
<%@page import="java.util.ArrayList"%>
<%@page import="lzj.DaoImpl.GoodsDaoImpl"%>
<%@page import="lzj.DAO.GoodsDao"%>
<%@page import="lzj.entity.User"%>
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
<title>商品管理</title>
<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<a href="AddGoods.jsp">添加商品</a>
	<table class="table">
		<caption>商品列表</caption>
		<thead>
			<tr>
				<th>商品名</th>
				<th>类型</th>
				<th>库存</th>
				<th>价格</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<%
				GoodsDao goodsDao = new GoodsDaoImpl();
				int pages = 1;
				ArrayList<Goods> goodsList = goodsDao.findGoodsByPage(pages);
				for (Goods g : goodsList) {
			%>
			<tr class="active">
				<td><%=g.getGoodsName()%></td>
				<td><%=g.getGoodsCategory().getCateGoryName()%></td>
				<td><%=g.getNum()%></td>
				<td><%=g.getGoodsPrice()%></td>
				<td><a href="DelGoods?gid=<%=g.getGoodsId()%>">删除商品</a><a href="EditGoods.jsp?gid=<%=g.getGoodsId()%>">修改商品</a></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
</body>
</html>