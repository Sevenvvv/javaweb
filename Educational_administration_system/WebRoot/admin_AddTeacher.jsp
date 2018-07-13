<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>教师管理-添加教师</title>
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
					<a href="admin_Courselist">课程管理<span class="glyphicon glyphicon-list-alt"></span></a>
					<a href="admin_Studentlist">学生管理<span class="glyphicon glyphicon-user"></span></a>
					<a href="admin_Teacherlist" class="btn btn-info active">教师管理<span class="glyphicon glyphicon-book"></span></a>
					<a href="admin_SetNewPassword.jsp">修改密码<span class="glyphicon glyphicon-edit"></span></a>
					<a href="admin_Resetstulist">账号密码重置<span class="glyphicon glyphicon-repeat"></span></a>
				</div>
				<div class="Rshow">
					<div class="stitle">
						<h1>添加教师</h1>
					</div>
					<div class="updatetable">
						<div>
							<div class="errMsg">${errMsg}</div>
							<form class="form-horizontal" action="admin_Addteacher" method="post" role="form">
								<div class="from-group">
									<div class="col-sm-2">
										<label for="teacherId" class="control-label">工号:</label>
									</div>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="teacherId" id="teacherId" value="${tblTeacher.teacherID}"/>
									</div>
								</div>
								<div class="from-group">
									<div class="col-sm-2">
										<label for="teacherName" class="control-label">教师姓名:</label>
									</div>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="teacherName" id="teacherName" value="${tblTeacher.teacherName}"/>
									</div>
								</div>
								<div class="from-group">
									<div class="col-sm-2">
										<label for="sex" class="control-label">性别:</label>
									</div>
									<div class="col-sm-10">
										<select name="sex" class="form-control">
											<option value="1">男</option>
											<option value="0">女</option>
										</select>
									</div>
								</div>
								<div class="from-group">
									<div class="col-sm-2">
										<label for="birthYear" class="control-label">出生日期:</label>
									</div>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="birthYear" id="birthYear" value="${tblTeacher.birthYear}"/>
									</div>
								</div>
								<div class="from-group">
									<div class="col-sm-2">
										<label for="degree" class="control-label">学历:</label>
									</div>
									<div class="col-sm-10">
										<select name="degree" class="form-control">
											<option value="本科" ${tblTeacher.degree == "1"?"selected='selected'":''}>本科</option>
											<option value="研究生" ${tblTeacher.degree == "2"?"selected='selected'":''}>研究生</option>
											<option value="博士" ${tblTeacher.degree == "3"?"selected='selected'":''}>博士</option>
										</select>
									</div>
								</div>
								<div class="from-group">
									<div class="col-sm-2">
										<label for="ptitle" class="control-label">职称:</label>
									</div>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="ptitle" id="ptitle" value="${tblTeacher.ptitle}"/>
									</div>
								</div>
								<div class="from-group">
									<div class="col-sm-2">
										<label for="grade" class="control-label">就职日期:</label>
									</div>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="grade" id="grade" value="${tblTeacher.grade}"/>
									</div>
								</div>
								<div class="from-group">
									<div class="col-sm-2">
										<label for="collegeId" class="control-label">所属学院:</label>
									</div>
									<div class="col-sm-10">
										<select name="collegeId" class="form-control">
											<option value="1" ${tblCourse.collegeID == "1"?"selected='selected'":''}>机电工程学院</option>
											<option value="2" ${tblCourse.collegeID == "2"?"selected='selected'":''}>建筑工程学院</option>
											<option value="3" ${tblCourse.collegeID == "3"?"selected='selected'":''}>旅游学院</option>
											<option value="4" ${tblCourse.collegeID == "4"?"selected='selected'":''}>商学院</option>
											<option value="5" ${tblCourse.collegeID == "5"?"selected='selected'":''}>财经学院</option>
											<option value="6" ${tblCourse.collegeID == "6"?"selected='selected'":''}>国际学院</option>
											<option value="7" ${tblCourse.collegeID == "7"?"selected='selected'":''}>信息工程学院</option>
											<option value="8" ${tblCourse.collegeID == "8"?"selected='selected'":''}>艺术工程学院</option>
											<option value="9" ${tblCourse.collegeID == "9"?"selected='selected'":''}>公共管理学院</option>
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
