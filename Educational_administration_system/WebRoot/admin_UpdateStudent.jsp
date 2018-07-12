<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>学生管理-修改学生信息</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="css/other.css"/>
	</head>
	<body>
		<div class="header">
			<div class="htitle">教务查询系统(管理员)</div>
			<div class="user dropdown">
				<button type="button" class="btn dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span>${sessionScope.auser.adminID}<span class="caret"></span></button>
				<ul class="dropdown-menu">
					<li><a href="login.jsp">退出</a></li>
				</ul>
			</div>
		</div>
		<div class="main">
			<div class="box">
				<div class="Lmenu">
					<a href="admin_Courselist">课程管理<span class="glyphicon glyphicon-list-alt"></span></a>
					<a href="admin_Studentlist" class="btn btn-info active">学生管理<span class="glyphicon glyphicon-user"></span></a>
					<a href="admin_Teacherlist">教师管理<span class="glyphicon glyphicon-book"></span></a>
					<a href="admin_SetNewPassword.jsp">修改密码<span class="glyphicon glyphicon-edit"></span></a>
					<a href="admin_Resetstulist">账号密码重置<span class="glyphicon glyphicon-repeat"></span></a>
				</div>
				<div class="Rshow">
					<div class="stitle">
						<h1>修改学生信息</h1>
					</div>
					<div class="updatetable">
						<div>
							<div class="errMsg">${errMsg}</div>
							<form class="form-horizontal" action="admin_Modifystudent" method="post" role="form">
								<input type="hidden" name="studentId" id="studentId" value="${tblstudent.studentID}"/>
								<div class="from-group">
									<div class="col-sm-2">
										<label for="studentId" class="control-label">学号:</label>
									</div>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="studentId" id="studentId" value="${tblstudent.studentID}" readonly="readonly"/>
									</div>
								</div>
								<div class="from-group">
									<div class="col-sm-2">
										<label for="studentName" class="control-label">学生姓名:</label>
									</div>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="studentName" id="studentName" value="${tblstudent.studentName}"/>
									</div>
								</div>
								<div class="from-group">
									<div class="col-sm-2">
										<label for="sex" class="control-label">性别:</label>
									</div>
									<div class="col-sm-10">
										<select name="sex" class="form-control">
											<option value="1" ${tblstudent.sex == "1"?"selected='selected'":''}>男</option>
											<option value="0" ${tblstudent.sex == "0"?"selected='selected'":''}>女</option>
										</select>
									</div>
								</div>
								<div class="from-group">
									<div class="col-sm-2">
										<label for="birthYear" class="control-label">出生日期:</label>
									</div>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="birthYear" id="birthYear" value="${tblstudent.birthYear}"/>
									</div>
								</div>
								<div class="from-group">
									<div class="col-sm-2">
										<label for="grade" class="control-label">入学时间:</label>
									</div>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="grade" id="grade" value="${tblstudent.grade}" readonly="readonly"/>
									</div>
								</div>
								<div class="from-group">
									<div class="col-sm-2">
										<label for="classId" class="control-label">班级:</label>
									</div>
									<div class="col-sm-10">
										<select name="classId" class="form-control">
											<option value="1" ${tblStudent.classID == "1"?"selected='selected'":''}>17机电一体化</option>
											<option value="2" ${tblStudent.classID == "2"?"selected='selected'":''}>17工程造价</option>
											<option value="3" ${tblStudent.classID == "3"?"selected='selected'":''}>17旅游管理</option>
											<option value="4" ${tblStudent.classID == "4"?"selected='selected'":''}>17电子商务</option>
											<option value="5" ${tblStudent.classID == "5"?"selected='selected'":''}>17会计专业</option>
											<option value="6" ${tblStudent.classID == "6"?"selected='selected'":''}>17商务英语</option>
											<option value="7" ${tblStudent.classID == "7"?"selected='selected'":''}>17软件技术</option>
											<option value="8" ${tblStudent.classID == "8"?"selected='selected'":''}>17室内艺术设计</option>
											<option value="9" ${tblStudent.classID == "9"?"selected='selected'":''}>17传播与策划</option>
										</select>
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
