<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<form class="form-horizontal" role="form" action="RegisterAction"
		method="post">
		<div class="form-group">
			<label for="firstname" class="col-sm-2 control-label">用户名</label>
			<div class="col-sm-5">
				<input type="text" class="form-control" id="firstname"
					placeholder="请输入用户名" name="username">
			</div>
		</div>
		<div class="form-group">
			<label for="lastname" class="col-sm-2 control-label">密码</label>
			<div class="col-sm-5">
				<input type="password" class="form-control" id="lastname"
					placeholder="请输入密码" name="pwd">
			</div>
		</div>
		<div class="form-group">
			<label for="lastname" class="col-sm-2 control-label">确认密码</label>
			<div class="col-sm-5">
				<input type="password" class="form-control" id="lastname"
					placeholder="请输入确认密码" name="checkpwd">
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-5">
				<button type="submit" class="btn btn-default">注册</button>
				<button type="reset" class="btn btn-default">重置</button>
			</div>
		</div>
	</form>
</body>
</html>