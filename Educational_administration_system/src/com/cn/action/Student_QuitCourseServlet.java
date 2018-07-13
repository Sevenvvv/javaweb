package com.cn.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.biz.TblDelBiz;
import com.cn.biz.impl.TblDelBizImpl;
import com.cn.entity.TblStudent;

public class Student_QuitCourseServlet extends HttpServlet {

	private TblDelBiz tblDelBiz = new TblDelBizImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String sStudentId = request.getParameter("studentId");
		String sCourseId = request.getParameter("courseId");
		try {
			int studentId = Integer.parseInt(sStudentId);
			int courseId = Integer.parseInt(sCourseId);
			tblDelBiz.QuitClass(courseId, studentId);
			response.sendRedirect("student_Selectedcourselist");
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("student_Selectedcourselist");
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
