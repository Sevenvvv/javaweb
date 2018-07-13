<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>学生打分</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="css/other.css"/>
	</head>
	<body>
		<div class="header">
			<div class="htitle">教务查询系统(教师)</div>
			<div class="user dropdown">
				<button type="button" class="btn dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span>${sessionScope.tuser.teacherID}<span class="caret"></span></button>
				<ul class="dropdown-menu">
					<li><a href="login.jsp">退出</a></li>
				</ul>
			</div>
		</div>
		<div class="main">
			<div class="box">
				<div class="Lmenu">
					<a href="teacher_Courselist" class="btn btn-info active">课程管理<span class="glyphicon glyphicon-list-alt"></span></a>
					<a href="teacher_SetNewPasaword.jsp">修改密码<span class="glyphicon glyphicon-edit"></span></a>
				</div>
				<div class="Rshow">
					<div class="stitle">
						<h1>学生打分</h1>
					</div>
					<div class="updatetable">
						<div>
							<div class="errMsg">${errMsg}</div>
							<form class="form-horizontal" action="teacher_Givenpoint" method="post" role="form">
								<input type="hidden" name="courseId" id="courseId" value="${courseID}"/>
								<div class="from-group">
									<div class="col-sm-2">
										<label for="studentId" class="control-label">学号:</label>
									</div>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="studentId" id="studentId" value="${tblstudent.studentID}${studentID}" readonly="readonly"/>
									</div>
								</div>
								<div class="from-group">
									<div class="col-sm-2">
										<label for="studentName" class="control-label">姓名:</label>
									</div>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="studentName" id="studentName" value="${tblstudent.studentName}${studentName}" readonly="readonly" />
									</div>
								</div>
								<div class="from-group">
									<div class="col-sm-2">
										<label for="mark" class="control-label">成绩:</label>
									</div>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="mark" id="mark" value=""/>
									</div>
								</div>
								<div class="from-group">
									<div class="col-sm-8 lastdiv">
										<input type="submit" class="btn btn-success" name="submit" value="提 交">
										<input type="reset" class="btn btn-default" name="reset" value="重 置">
									</div>
								</div>
							</form>
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
