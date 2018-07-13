<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>课程学生名单</title>
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
						<h1>已选该课程学生名单</h1>
					</div>
					<div class="showtable">
						<table class="table table-bordered table-striped">
							<tr>
								<th>学号</th>
								<th>姓名</th>
								<th>院系</th>
								<th>专业</th>
								<th>班级</th>
								<th>分数</th>
								<th>操作</th>
							</tr>
							<c:forEach items="${requestScope.pageBean.lists}" var="student">
								<tr>
									<td>${student.studentID}</td>
									<td>${student.studentName}</td>
									<td>${student.collegeName}</td>
									<td>${student.majorName}</td>
									<td>${student.className}</td>
									<td>${student.mark==0 ? "未打分":student.mark}</td>
									<td>
										<c:if test="${student.mark==0}">
											<a href="teacher_Studentgrade?studentId=${student.studentID}&courseId=${student.courseID}" class="btn btn-info">打分</a>
										</c:if>
										<c:if test="${student.mark!=0}">
											<a class="btn btn-default">已打分</a>
										</c:if>
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
									<li><a href="teacher_Selectedcoursestu?pageNum=${pageBean.pageNum - 1 }">上一页</a></li>
								</c:if>
								<c:forEach begin="1" end="${pageBean.pageCount }" step="1" var="i">
					                <c:if test="${page.pageNum==i }">
					                    <li><a href="teacher_Selectedcoursestu?pageNum=${i}">${i}</a></li>
					                </c:if>
					                <c:if test="${page.pageNum!=i }">
					                    <li><a href="teacher_Selectedcoursestu?pageNum=${i}">${i}</a></li>
					                </c:if>
					            </c:forEach>
								<c:if test="${pageBean.pageNum >= pageBean.pageCount }">
									<li><a href="">下一页</a></li>
								</c:if>
								<c:if test="${pageBean.pageNum < pageBean.pageCount }">
									<li><a href="teacher_Selectedcoursestu?pageNum=${pageBean.pageNum + 1 }">下一页</a></li>
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
