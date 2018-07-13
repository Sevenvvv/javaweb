package com.cn.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cn.biz.FinishCourseBiz;
import com.cn.biz.impl.FinishCourseBizImpl;
import com.cn.entity.TblSelectedCourse;
import com.cn.entity.TblStudent;

public class Student_ChoiceCourseServlet extends HttpServlet {
	
	private FinishCourseBiz finishCourseBiz = new FinishCourseBizImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session =request.getSession();
		TblStudent tblstudent = ((TblStudent) session.getAttribute("suser"));
		int studentId = tblstudent.getStudentID();
		String sCourseId = request.getParameter("courseId");
		int courseId = 0;
		
		TblSelectedCourse tblSelectedCourse = new TblSelectedCourse();
		
		try {
			courseId = Integer.parseInt(sCourseId);
			tblSelectedCourse.setStudentID(studentId);
			tblSelectedCourse.setCourseID(courseId);
			finishCourseBiz.ChoiceCourse(tblSelectedCourse);
			response.sendRedirect("student_Selectedcourselist");
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("student_Selectedcourselist");
		}
		
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
