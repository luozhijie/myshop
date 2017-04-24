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
<script type="text/javascript">
	function validate() {
		var name = document.getElementById("username").value;
		var pwd = document.getElementById("pwd").value;
		var repwd = document.getElementById("checkpwd").value;
		var yzm = document.getElementById("yzm").value;
		submitOk = true;
		if (name.length == 0) {
			alert("用户名不能为空！");
			submitOk = false;
		}
		if (pwd.length == 0) {
			alert("密码不能为空！");
			submitOk = false;
		}
		if (repwd.length == 0) {
			alert("重复密码不能为空！");
			submitOk = false;
		}
		if (pwd != repwd) {
			alert("两次密码不一致");
			submitOk = false;
		}
		if (yzm.length == 0) {
			alert("验证码不能为空");
			submitOk = false;
		}

		if (submitOk == false) {
			document.getElementById("username").focus();
		}

		return submitOk;
	}
	function loadImage() {
		document.getElementById("randImage").src = "CreateImg.jsp?"
				+ Math.random();
	}
</script>
</head>
<body>
	<form class="form-horizontal" action="RegisterAction" method="post"
		onsubmit="return validate();">
		<div class="form-group">
			<label for="firstname" class="col-sm-2 control-label">用户名</label>
			<div class="col-sm-5">
				<input type="text" class="form-control" placeholder="请输入用户名"
					name="username" id="username">
			</div>
		</div>
		<div class="form-group">
			<label for="lastname" class="col-sm-2 control-label">密码</label>
			<div class="col-sm-5">
				<input type="password" class="form-control" id="pwd"
					placeholder="请输入密码" name="pwd">
			</div>
		</div>
		<div class="form-group">
			<label for="lastname" class="col-sm-2 control-label">确认密码</label>
			<div class="col-sm-5">
				<input type="password" class="form-control" id="checkpwd"
					placeholder="请输入确认密码" name="checkpwd">
			</div>
		</div>
		
		<div class="form-group">
		<img src="CreateImg.jsp" name="randImage" id="randImage"></img>
			<label for="lastname" class="col-sm-2 control-label"></label>
			<div class="col-sm-5">
				<input type="password" class="form-control" id="yzm"
					placeholder="请输入验证码" name="yzm">
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-5">
				<input type="submit" class="btn btn-default" value="注册"> <input
					type="reset" class="btn btn-default" value="重置">
			</div>
		</div>
	</form>
</body>
</html>