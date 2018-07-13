<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>所授课程管理</title>
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
						<h1>我教授的课程</h1>
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
							<c:forEach items="${requestScope.pageBean.lists}" var="course">
								<tr>
									<td>${course.courseID}</td>
									<td>${course.courseName}</td>
									<td>${course.teacherID}</td>
									<td>${course.courseTime}</td>
									<td>${course.courseBegin}</td>
									<td>${course.courseRoom}</td>
									<td>${course.courseWeek}</td>
									<td>
										<c:if test="${course.courseType == 1}">
											必修
										</c:if>
										<c:if test="${course.courseType == 0}">
											选修
										</c:if>
									</td>
									<td>${course.collegeName}</td>
									<td>${course.point}</td>
									<td>
										<a href="teacher_Selectedcoursestu?courseId=${course.courseID}" class="btn btn-info">打分</a>
									</td>
								</tr>
							</c:forEach>
						</table>
					</div>
					<div class="page">
						<div class="pul">
							<ul class="pagination">
								<c:if test="${pageBean.pageNum <= 1 }">
									<li><a href="">上一页</a></li>
								</c:if>
								<c:if test="${pageBean.pageNum > 1 }">
									<li><a href="teacher_Courselist?pageNum=${pageBean.pageNum - 1 }">上一页</a></li>
								</c:if>
								<c:forEach begin="1" end="${pageBean.pageCount }" step="1" var="i">
					                <c:if test="${page.pageNum==i }">
					                    <li><a href="teacher_Courselist?pageNum=${i}">${i}</a></li>
					                </c:if>
					                <c:if test="${page.pageNum!=i }">
					                    <li><a href="teacher_Courselist?pageNum=${i}">${i}</a></li>
					                </c:if>
					            </c:forEach>
								<c:if test="${pageBean.pageNum >= pageBean.pageCount }">
									<li><a href="">下一页</a></li>
								</c:if>
								<c:if test="${pageBean.pageNum < pageBean.pageCount }">
									<li><a href="teacher_Courselist?pageNum=${pageBean.pageNum + 1 }">下一页</a></li>
								</c:if>
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
