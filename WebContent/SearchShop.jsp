<%@page import="lzj.entity.Goods"%>
<%@page import="java.util.ArrayList"%>
<%@page import="lzj.DaoImpl.GoodsDaoImpl"%>
<%@page import="lzj.DAO.GoodsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>搜索结果</title>
<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<a href="ShopIndex.jsp">返回首页</a>
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
				request.setCharacterEncoding("utf-8");
				String goodName = request.getParameter("searchkey");
				GoodsDao goodsDao = new GoodsDaoImpl();
				ArrayList<Goods> goodsList = goodsDao.findGoodsByGoodsName(goodName);
				for (Goods g : goodsList) {
			%>
			<tr class="active">
				<td><%=g.getGoodsName()%></td>
				<td><%=g.getGoodsCategory().getCateGoryName()%></td>
				<td><%=g.getNum()%></td>
				<td><%=g.getGoodsPrice()%></td>
				<td><a href="AddShopCar?gid=<%=g.getGoodsId()%>">加入购物车</a></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
</body>
</html>