<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>课程管理-修改课程信息</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="css/other.css"/>
	</head>
	<body>
		<div class="header">
			<div class="htitle">教务查询系统(管理员)</div>
			<div class="user dropdown">
				<button type="button" class="btn dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span>${sessionScope.auser.adminID}<span class="caret"></span></button>
				<ul class="dropdown-menu">
					<li><a href="outLogin">退出</a></li>
				</ul>
			</div>
		</div>
		<div class="main">
			<div class="box">
				<div class="Lmenu">
					<a href="admin_Courselist" class="btn btn-info active">课程管理<span class="glyphicon glyphicon-list-alt"></span></a>
					<a href="admin_Studentlist">学生管理<span class="glyphicon glyphicon-user"></span></a>
					<a href="admin_Teacherlist">教师管理<span class="glyphicon glyphicon-book"></span></a>
					<a href="admin_SetNewPassword.jsp">修改密码<span class="glyphicon glyphicon-edit"></span></a>
					<a href="admin_Resetstulist">账号密码重置<span class="glyphicon glyphicon-repeat"></span></a>
				</div>
				<div class="Rshow">
					<div class="stitle">
						<h1>修改课程信息</h1>
					</div>
					<div class="updatetable">
						<div>
							<div class="errMsg">${errMsg}</div>
							<form class="form-horizontal" action="admin_Modifycourse" method="post" role="form">
								<input type="hidden" name="courseId" id="courseId" value="${tblcourse.courseID}"/>
								<div class="from-group">
									<div class="col-sm-2">
										<label for="courseName" class="control-label">课程名称:</label>
									</div>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="courseName" id="courseName" value="${tblcourse.courseName}" readonly="readonly"/>
									</div>
								</div>
								<div class="from-group">
									<div class="col-sm-2">
										<label for="teacherId" class="control-label">授课教师编号:</label>
									</div>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="teacherId" id="teacherId" value="${tblcourse.teacherID}"/>
									</div>
								</div>
								<div class="from-group">
									<div class="col-sm-2">
										<label for="courseTime" class="control-label">上课时间:</label>
									</div>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="courseTime" id="courseTime" value="${tblcourse.courseTime}"/>
									</div>
								</div>
								<div class="from-group">
									<div class="col-sm-2">
										<label for="courseBegin" class="control-label">开课时间:</label>
									</div>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="courseBegin" id="courseBegin" value="${tblcourse.courseBegin}" readonly="readonly"/>
									</div>
								</div>
								<div class="from-group">
									<div class="col-sm-2">
										<label for="classRoom" class="control-label">上课地点:</label>
									</div>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="classRoom" id="classRoom" value="${tblcourse.courseRoom}"/>
									</div>
								</div>
								<div class="from-group">
									<div class="col-sm-2">
										<label for="courseWeek" class="control-label">学时:</label>
									</div>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="courseWeek" id="courseWeek" value="${tblcourse.courseWeek}"/>
									</div>
								</div>
								<div class="from-group">
									<div class="col-sm-2">
										<label for="courseType" class="control-label">课程类型:</label>
									</div>
									<div class="col-sm-10">
										<select name="courseType" class="form-control">
											<option value="1" ${tblcourse.courseType == "1"?"selected='selected'":''}>必修</option>
											<option value="0" ${tblcourse.courseType == "0"?"selected='selected'":''}>选修</option>
										</select>
									</div>
								</div>
								<div class="from-group">
									<div class="col-sm-2">
										<label for="collegeId" class="control-label">所属学院:</label>
									</div>
									<div class="col-sm-10">
										<select name="collegeId" class="form-control">
											<option value="1" ${tblcourse.collegeID == "1"?"selected='selected'":''}>机电工程学院</option>
											<option value="2" ${tblcourse.collegeID == "2"?"selected='selected'":''}>建筑工程学院</option>
											<option value="3" ${tblcourse.collegeID == "3"?"selected='selected'":''}>旅游学院</option>
											<option value="4" ${tblcourse.collegeID == "4"?"selected='selected'":''}>商学院</option>
											<option value="5" ${tblcourse.collegeID == "5"?"selected='selected'":''}>财经学院</option>
											<option value="6" ${tblcourse.collegeID == "6"?"selected='selected'":''}>国际学院</option>
											<option value="7" ${tblcourse.collegeID == "7"?"selected='selected'":''}>信息工程学院</option>
											<option value="8" ${tblcourse.collegeID == "8"?"selected='selected'":''}>艺术工程学院</option>
											<option value="9" ${tblcourse.collegeID == "9"?"selected='selected'":''}>公共管理学院</option>
										</select>
									</div>
								</div>
								<div class="from-group">
									<div class="col-sm-2">
										<label for="point" class="control-label">学分:</label>
									</div>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="point" id="point" value="${tblcourse.point}"/>
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
