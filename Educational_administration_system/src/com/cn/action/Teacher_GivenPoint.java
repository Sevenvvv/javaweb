package com.cn.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.biz.TblGivenPointBiz;
import com.cn.biz.impl.TblGivenPointBizImpl;

public class Teacher_GivenPoint extends HttpServlet {

	private TblGivenPointBiz tblGivenPointBiz = new TblGivenPointBizImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String errMsg = "";
		
		String sStudentId = request.getParameter("studentId");
		String sCourseId = request.getParameter("courseId");
		String studentName = request.getParameter("studentName");
		
		String sMark = request.getParameter("mark");
		if (sMark == null || "".equals(sMark)){
			errMsg = errMsg + "分数不能为空<br/>";
		}else{
		}
		
		int studentId = 0;
		int courseId = 0;
		int mark = 0;
		
		try {
			studentId = Integer.parseInt(sStudentId);
			courseId = Integer.parseInt(sCourseId);
			mark = Integer.parseInt(sMark);
		} catch (Exception e) {
		}
		
		if("".equals(errMsg)){
			tblGivenPointBiz.givenPotin(mark, studentId, courseId);
			response.sendRedirect("teacher_Selectedcoursestu?courseId="+courseId);
		}else{
			request.setAttribute("studentName", studentName);
			request.setAttribute("courseID", courseId);			
			request.setAttribute("studentID", studentId);
			request.setAttribute("errMsg", errMsg);
			request.getRequestDispatcher("teacher_StudentGrade.jsp").forward(request, response);
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
