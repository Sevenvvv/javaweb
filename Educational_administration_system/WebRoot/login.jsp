<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="content-type" charset="UTF-8">
		<title>登陆</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="css/login.css"/>
	</head>
	<body>
		<div class="bg"></div>
		<div class="loginbox">
			<div class="title"><h3>欢迎使用教务管理系统</h3></div>
			<div class="login">
				<form action="login" method="post" class="form-group">
					<table class="">
						<div class="errMsg">${errMsg}</div>
						<tr>
							<td><label for="username" class="control-label">用户名:</label></td>
							<td>
								<input type="text" class="form-control" name="username" id="username" value="${requestScope.username}"/>
							</td>
						</tr>
						<tr>
							<td><label for="password" class="control-label">密&nbsp;&nbsp;&nbsp;&nbsp;码</label></td>
							<td><input type="password" class="form-control" name="password" id="password" value=""/></td>
						</tr>
						<tr>
							<td colspan="2">
								<input type="radio" name="usertype" id="usertype" value="1" />学生
								<input type="radio" name="usertype" id="usertype" value="2" />教师
								<!-- 管理员value为0 -->
								<input type="radio" name="usertype" id="usertype" value="0" />管理员
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<input type="submit" class="btn btn-success" name="login" id="login" value="登陆" />
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</body>
</html>
