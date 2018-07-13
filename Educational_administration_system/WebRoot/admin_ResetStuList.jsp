<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>重置密码-学生</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="css/other.css"/>
		<script type="text/javascript">
			function confirmReset(studentID){
				var flag = confirm("真的要重置吗?");
				if(flag){
					window.location.href = "admin_Resetstu?studentId=" + studentID;
				}
			}
		</script>
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
					<a href="admin_Teacherlist">教师管理<span class="glyphicon glyphicon-book"></span></a>
					<a href="admin_SetNewPassword.jsp">修改密码<span class="glyphicon glyphicon-edit"></span></a>
					<a href="admin_Resetstulist" class="btn btn-info active">账号密码重置<span class="glyphicon glyphicon-repeat"></span></a>
				</div>
				<div class="Rshow">
					<div class="stitle">
						<h1>重置学生密码</h1>
						<a href="admin_Resettealist" class="btn btn-default">重置教师密码<span class="glyphicon glyphicon-repeat"></span></a>
						<a href="admin_Resetstulist" class="btn btn-primary">重置学生密码<span class="glyphicon glyphicon-repeat"></span></a>
					</div>
					<div class="showtable">
						<table class="table table-bordered table-striped">
							<tr>
								<th>学号</th>
								<th>学生姓名</th>
								<th>性别</th>
								<th>出生日期</th>
								<th>入学时间</th>
								<th>院系</th>
								<th>专业</th>
								<th>班级</th>
								<th>辅导员</th>
								<th>操作</th>
							</tr>
							<c:forEach items="${requestScope.pageBean.lists}" var="student">
								<tr>
									<td>${student.studentID}</td>
									<td>${student.studentName}</td>
									<td>
										<c:if test="${student.sex ==1}">男</c:if>
										<c:if test="${student.sex ==0}">女</c:if>
									</td>
									<td>${student.birthYear}</td>
									<td>${student.grade}</td>
									<td>${student.collegeName}</td>
									<td>${student.majorName}</td>
									<td>${student.className}</td>
									<td>${student.teacherName}</td>
									<td>
										<a href="javascript:confirmReset(${student.studentID})" class="btn btn-warning">重置密码</a>
									</td>
								</tr>
							</c:forEach>
						</table>
					</div>
					<div class="page">
						<div class="pul">
							<div class="pul">
							<ul class="pagination">
								<c:if test="${pageBean.pageNum <= 1 }">
									<li><a href="">上一页</a></li>
								</c:if>
								<c:if test="${pageBean.pageNum > 1 }">
									<li><a href="admin_Resetstulist?pageNum=${pageBean.pageNum - 1 }">上一页</a></li>
								</c:if>
								<c:forEach begin="1" end="${pageBean.pageCount }" step="1" var="i">
					                <c:if test="${page.pageNum==i }">
					                    <li><a href="admin_Resetstulist?pageNum=${i}">${i}</a></li>
					                </c:if>
					                <c:if test="${page.pageNum!=i }">
					                    <li><a href="admin_Resetstulist?pageNum=${i}">${i}</a></li>
					                </c:if>
					            </c:forEach>
								<c:if test="${pageBean.pageNum >= pageBean.pageCount }">
									<li><a href="">下一页</a></li>
								</c:if>
								<c:if test="${pageBean.pageNum < pageBean.pageCount }">
									<li><a href="admin_Resetstulist?pageNum=${pageBean.pageNum + 1 }">下一页</a></li>
								</c:if>
							</ul>
						</div>
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
