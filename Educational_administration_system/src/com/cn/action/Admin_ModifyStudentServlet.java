package com.cn.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.biz.TblModifyBiz;
import com.cn.biz.impl.TblModifyBizImpl;
import com.cn.entity.TblStudent;

public class Admin_ModifyStudentServlet extends HttpServlet {

	private TblModifyBiz tblModifyBiz = new TblModifyBizImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		request.setCharacterEncoding("UTF-8");
		
		TblStudent tblStudent = new TblStudent();
		
		String errMsg = "";
		
		String sStudentId = request.getParameter("studentId");
		try {
			if (sStudentId == null || "".equals(sStudentId)){
			}else{
				Integer studentId = Integer.parseInt(sStudentId);
				tblStudent.setStudentID(studentId);
			}
		} catch (Exception e) {
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
			if (sGrade == null || "".equals(sGrade)){
			}else{
				Date grade = Date.valueOf(sGrade);
				tblStudent.setGrade(grade);
			}
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
		
		if ("".equals(errMsg)){
			boolean flag = tblModifyBiz.modifyStudent(tblStudent);
			if (flag){
				response.sendRedirect("admin_Studentlist");
			}else{
				errMsg = errMsg + "修改失败<br/>";
				request.setAttribute("tblstudent", tblStudent);
				request.setAttribute("errMsg", errMsg);
				request.getRequestDispatcher("admin_UpdateStudent.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("tblstudent", tblStudent);
			request.setAttribute("errMsg", errMsg);
			request.getRequestDispatcher("admin_UpdateStudent.jsp").forward(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
