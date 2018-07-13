<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>学生已修课程</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="css/other.css"/>
	</head>
	<body>
		<div class="header">
			<div class="htitle">教务查询系统(学生)</div>
			<div class="user dropdown">
				<button type="button" class="btn dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span>${sessionScope.suser.studentID}<span class="caret"></span></button>
				<ul class="dropdown-menu">
					<li><a href="outLogin">退出</a></li>
				</ul>
			</div>
		</div>
		<div class="main">
			<div class="box">
				<div class="Lmenu">
					<a href="student_Courselist">可选课程<span class="glyphicon glyphicon-list-alt"></span></a>
					<a href="student_Selectedcourselist">已选课程<span class="glyphicon glyphicon-user"></span></a>
					<a href="student_Finishcourselist" class="btn btn-info active">已修课程<span class="glyphicon glyphicon-book"></span></a>
					<a href="student_SetNewPasaword.jsp">修改密码<span class="glyphicon glyphicon-edit"></span></a>
				</div>
				<div class="Rshow">
					<div class="stitle">
						<h1>已修课程列表</h1>
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
								<th>成绩</th>
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
									<td class="mark">${course.mark}</td>
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
									<li><a href="student_Finishcourselist?pageNum=${pageBean.pageNum - 1 }">上一页</a></li>
								</c:if>
								<c:forEach begin="1" end="${pageBean.pageCount }" step="1" var="i">
					                <c:if test="${page.pageNum==i }">
					                    <li><a href="student_Finishcourselist?pageNum=${i}">${i}</a></li>
					                </c:if>
					                <c:if test="${page.pageNum!=i }">
					                    <li><a href="student_Finishcourselist?pageNum=${i}">${i}</a></li>
					                </c:if>
					            </c:forEach>
								<c:if test="${pageBean.pageNum >= pageBean.pageCount }">
									<li><a href="">下一页</a></li>
								</c:if>
								<c:if test="${pageBean.pageNum < pageBean.pageCount }">
									<li><a href="student_Finishcourselist?pageNum=${pageBean.pageNum + 1 }">下一页</a></li>
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
