package com.cn.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.biz.TblGivenPointBiz;
import com.cn.biz.TblUsersBiz;
import com.cn.biz.impl.TblGivenPointBizImpl;
import com.cn.biz.impl.TblUsersBizImpl;
import com.cn.entity.TblStudent;
import com.cn.entity.TblTeacher;

public class Teacher_StudentGrade extends HttpServlet {

	private TblGivenPointBiz tblGivenPointBiz = new TblGivenPointBizImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sStudentId = request.getParameter("studentId");
		String sCourseId = request.getParameter("courseId");
		try {
			int studentId = Integer.parseInt(sStudentId);
			int courseId = Integer.parseInt(sCourseId);
			TblStudent tblStudent = tblGivenPointBiz.findstu(studentId);
			request.setAttribute("tblstudent", tblStudent);
			request.setAttribute("courseID", courseId);
			request.getRequestDispatcher("teacher_StudentGrade.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("teacher_Selectedcoursestu?courseId="+sCourseId);
		}
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
