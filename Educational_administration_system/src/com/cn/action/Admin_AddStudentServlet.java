package com.cn.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.biz.TblAddBiz;
import com.cn.biz.impl.TblAddBizImpl;
import com.cn.dao.TblStudentDao;
import com.cn.dao.impl.TblStudentDaoImpl;
import com.cn.entity.TblStudent;

public class Admin_AddStudentServlet extends HttpServlet {

	private TblAddBiz tblAddBiz = new TblAddBizImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		TblStudent tblStudent = new TblStudent();
		
		String errMsg = "";
		
		String sStudentId = request.getParameter("studentId");
		try {
			if (sStudentId == null || "".equals(sStudentId)){
				errMsg = errMsg + "学号不能为空<br/>";
			}else{
				Integer studentId = Integer.parseInt(sStudentId);
				tblStudent.setStudentID(studentId);
			}
		} catch (Exception e) {
			errMsg = errMsg + "学号必须是数字型<br/>";
			e.printStackTrace();
		}
		
		String studentName = request.getParameter("studentName");
		if (studentName == null || "".equals(studentName)){
			errMsg = errMsg + "学生姓名不能为空<br/>";
		}else{
			tblStudent.setStudentName(studentName);
		}
		
		String sex = request.getParameter("sex");
		if (sex == null || "".equals(sex)){
		}else{
			tblStudent.setSex(sex);
		}
			
		String sBirthYear = request.getParameter("birthYear"); 									
		try {
			Date birthYear = Date.valueOf(sBirthYear);
			tblStudent.setBirthYear(birthYear);
		} catch (Exception e) {
			errMsg = errMsg + "生日必须满足yyyy-MM-dd格式<br/>";
			e.printStackTrace();
		}
		
		String sGrade = request.getParameter("grade");
		try {
			Date grade = Date.valueOf(sGrade);
			tblStudent.setGrade(grade);
		} catch (Exception e) {
			errMsg = errMsg + "入学日期必须满足yyyy-MM-dd格式<br/>";
			e.printStackTrace();
		}
		
		String sCollegeId = request.getParameter("collegeId");
		try {
			Integer collegeId = Integer.valueOf(sCollegeId);
			tblStudent.setCollegeID(collegeId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String sMajorId = request.getParameter("majorId");
		try {
			Integer majorId = Integer.valueOf(sMajorId);
			tblStudent.setMajorID(majorId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String sClassId = request.getParameter("classId");
		try {
			Integer classId = Integer.valueOf(sClassId);
			tblStudent.setClassID(classId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		tblStudent.setsPassword("123456");
		
		if ("".equals(errMsg)){
			boolean flag = tblAddBiz.addStudent(tblStudent);
			if (flag){
				response.sendRedirect("admin_Studentlist");
			}else{
				errMsg = errMsg + "增加失败<br/>";
				request.setAttribute("tblStudent", tblStudent);
				request.setAttribute("errMsg", errMsg);
				request.getRequestDispatcher("admin_AddStudent.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("tblStudent", tblStudent);
			request.setAttribute("errMsg", errMsg);
			request.getRequestDispatcher("admin_AddStudent.jsp").forward(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
