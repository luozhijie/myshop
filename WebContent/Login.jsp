<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
	function loadImage() {
		document.getElementById("randImage").src = "CreateImg.jsp?"
				+ Math.random();
	}
</script>
</head>
<body>
	<form class="form-horizontal" role="form" action="LoginAction"
		method="post">
		<div class="form-group">
			<label class="col-sm-5 control-label">用户名</label>
			<div class="col-sm-5">
				<input type="text" class="form-control" id="firstname"
					placeholder="请输入用户名" name="username">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-5 control-label">密码</label>
			<div class="col-sm-5">
				<input type="password" class="form-control" id="lastname"
					placeholder="请输入密码" name="password">
			</div>
		</div>
		<div class="form-group">
		<img src="CreateImg.jsp" name="randImage" id="randImage"></img>
		<div class="col-sm-offset-2 col-sm-5">
		<label for="firstname" class="col-sm-5 control-label">验证码</label>
		<div class="col-sm-5">
			<input name="yzm" type="text" class="form-control" id="yzm"
				placeholder="请输入验证码">
				</div>
		</div>
		<a href="javascript:loadImage();">看不清，换一张</a>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-5">
				<div class="checkbox">
					<label> <input type="checkbox" name="remeberme" value="1">
						请记住我
					</label> <a href="forgetpassword.jsp">忘记密码？</a><a href="Register.jsp">没有账号？</a>
				</div>
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-5">
				<button type="submit" class="btn btn-default">登录</button>
			</div>
		</div>
	</form>
</body>
</html>