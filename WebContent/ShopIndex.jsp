<%@page import="lzj.entity.Goods"%>
<%@page import="java.util.ArrayList"%>
<%@page import="lzj.DaoImpl.GoodsDaoImpl"%>
<%@page import="lzj.DAO.GoodsDao"%>
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
<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<form action="SearchShop.jsp" method="post">
		<input type="text" name="searchkey"> <input type="submit"
			value="搜索">
	</form>
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
				session.setAttribute("user", user);
			} else {
				user = sessionUser;
			}
	%>
	欢迎：<%=user.getUsername()%><a href="DelLogin">注销</a>
	<br>
	<%
		if (user.getUserType() < 2) {
				out.print("<a href='UserManager.jsp'>管理用户</a>");
			}
			if (user.getUserType() < 2) {
				out.print("<a href='ShopManager.jsp'>管理商品</a>");
			}
	%>
	<br>
	<a href="MyUserInfo.jsp">个人中心</a>
	<%
		}
	%>

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
				if (request.getParameter("page") != null) {
					pages = Integer.valueOf(request.getParameter("page"));
				}

				int listNum = goodsDao.countNum();
				int lastPage = listNum / 10;
				if (listNum % 10 > 0) {
					lastPage++;
				}

				ArrayList<Goods> goodsList = goodsDao.findGoodsByPage(pages);
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
	<ul class="pagination pagination-lg">

		<li><a <%if (pages > 1) {%>
			href="ShopIndex.jsp?page=<%=(pages - 1)%>" <%}%>>&laquo;</a></li>

		<%
			int start = pages > 2 ? pages - 2 : 1;
			int end = pages >= lastPage - 2 ? lastPage
					: (lastPage > 5 ? (pages <= 2 ? (pages == 1 ? pages + 4 : pages + 3) : pages + 2) : lastPage);

			for (; start <= end; start++) {
		%>
		<li <%if (pages == start) {%> class="active" <%}%>><a
			href="ShopIndex.jsp?page=<%=start%>"><%=start%></a></li>
		<%
			}
		%>

		<li><a <%if (pages < lastPage) {%>
			href="ShopIndex.jsp?page=<%=(pages + 1)%>" <%}%>>&raquo;</a></li>
	</ul>
</body>
</html>