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
<title>添加商品</title>
<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<form action="AddGoods" method="post">
		<table>

			<tr>
				<td><label>商品名</label></td>
				<td><input name="goodsName" id="goodsName" type="text" /></td>
			</tr>
			<tr>
				<td><label>商品描述</label></td>
				<td><textarea name="goodsInfo" rows="10" cols="20"></textarea></td>
			</tr>
			<tr>
				<td><label>价格</label></td>
				<td><input name="price" id="price" type="text" /></td>
			</tr>
			<tr>
				<td><label>类型编号</label></td>
				<td><select name="categoryNo" name="categoryNo">
						<%
							CategoryDao categoryDao = new CategoryDaoImpl();
							ArrayList<Category> categoryList = categoryDao.findAllCategory();
							for (Category c : categoryList) {
						%>
						<option value="<%=c.getCid()%>"><%=c.getCateGoryName()%></option>
						<%
							}
						%>
				</select></td>
			</tr>
			<tr>
				<td><label>库存</label></td>
				<td><input name="num" id="num" type="text" /></td>
			</tr>
		</table>
		<input type="submit" value="提交"> <input type="reset"
			value="取消">
	</form>
</body>
</html>