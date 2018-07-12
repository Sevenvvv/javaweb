<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>学生已选课程</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="css/other.css"/>
	</head>
	<body>
		<div class="header">
			<div class="htitle">教务查询系统(学生)</div>
			<div class="user dropdown">
				<button type="button" class="btn dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span>${sessionScope.suser.studentID}<span class="caret"></span></button>
				<ul class="dropdown-menu">
					<li><a href="login.jsp">退出</a></li>
				</ul>
			</div>
		</div>
		<div class="main">
			<div class="box">
				<div class="Lmenu">
					<a href="student_CourseList.html">可选课程<span class="glyphicon glyphicon-list-alt"></span></a>
					<a href="student_SelectedCourseList.html" class="btn btn-info active">已选课程<span class="glyphicon glyphicon-user"></span></a>
					<a href="student_FinishCourseList.html">已修课程<span class="glyphicon glyphicon-book"></span></a>
					<a href="student_SetNewPasaword.html">修改密码<span class="glyphicon glyphicon-edit"></span></a>
				</div>
				<div class="Rshow">
					<div class="stitle">
						<h1>已选课程列表</h1>
					</div>
					<div class="showtable">
						<table class="table table-bordered table-striped">
							<tr>
								<th>课程编号</th>
								<th>课程名</th>
								<th>授课老师编号</th>
								<th>上课时间</th>
								<th>开课时间</th>
								<th>上课地点</th>
								<th>学时</th>
								<th>课程类型</th>
								<th>课程所属院系</th>
								<th>学分</th>
								<th>操作</th>
							</tr>
							<tr>
								<td>1</td>
								<td>c语言程序设计</td>
								<td>1001</td>
								<td>周二</td>
								<td>2018-1-1</td>
								<td>七训408</td>
								<td>18</td>
								<td>必修课</td>
								<td>信息工程学院</td>
								<td>1</td>
								<td>
									<a href="" class="btn btn-danger">退课</a>
								</td>
							</tr>
						</table>
					</div>
					<div class="page">
						<div class="pul">
							<ul class="pagination">
								<li><a href="">上一页</a></li>
								<li><a href="">1</a></li>
								<li><a href="">2</a></li>
								<li><a href="">3</a></li>
								<li><a href="">4</a></li>
								<li><a href="">5</a></li>
								<li><a href="">下一页</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
	<script src="js/jquery-2.1.0.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/other.js"></script>
</html>
