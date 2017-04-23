<%@page import="lzj.entity.Goods"%>
<%@page import="lzj.DaoImpl.GoodsDaoImpl"%>
<%@page import="lzj.DAO.GoodsDao"%>
<%@page import="lzj.entity.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="lzj.DaoImpl.CategoryDaoImpl"%>
<%@page import="lzj.DAO.CategoryDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改商品</title>
</head>
<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		int gid = Integer.valueOf(request.getParameter("gid"));
		GoodsDao goodsDao = new GoodsDaoImpl();
		Goods goods = goodsDao.findGoodsByGid(gid).get(0);
	%>
	<form action="EditGoods" method="post">
		<input type="hidden" name="gid" value="<%=gid%>">
		<table>

			<tr>
				<td><label>商品名</label></td>
				<td><input name="goodsName" id="goodsName" type="text"
					value="<%=goods.getGoodsName()%>" /></td>
			</tr>
			<tr>
				<td><label>商品描述</label></td>
				<td><textarea name="goodsInfo" rows="10" cols="20"><%=goods.getGoodsInfo()%></textarea></td>
			</tr>
			<tr>
				<td><label>价格</label></td>
				<td><input name="price" id="price" type="text"
					value="<%=goods.getGoodsPrice()%>" /></td>
			</tr>
			<tr>
				<td><label>类型编号</label></td>
				<td><select name="categoryNo" name="categoryNo">
						<%
							CategoryDao categoryDao = new CategoryDaoImpl();
							ArrayList<Category> categoryList = categoryDao.findAllCategory();
							for (Category c : categoryList) {
						%>
						<option value="<%=c.getCid()%>"
							<%=(c.getCid() == goods.getGoodsCategory().getCid()) ? "selected='selected'" : ""%>><%=c.getCateGoryName()%></option>
						<%
							}
						%>
				</select></td>
			</tr>
			<tr>
				<td><label>库存</label></td>
				<td><input name="num" id="num" type="text"
					value="<%=goods.getNum()%>" /></td>
			</tr>
		</table>
		<input type="submit" value="提交"> <input type="reset"
			value="取消">
	</form>
</body>
</html>