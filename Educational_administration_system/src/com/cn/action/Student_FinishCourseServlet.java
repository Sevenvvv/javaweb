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
import com.cn.entity.TblStudent;
import com.cn.util.PageBean;

public class Student_FinishCourseServlet extends HttpServlet {

	private FinishCourseBiz finishCourseBiz = new FinishCourseBizImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String sPageNum = request.getParameter("pageNum");
		HttpSession session =request.getSession();
		TblStudent tblstudent = ((TblStudent) session.getAttribute("suser"));
		int studentID = tblstudent.getStudentID();
		
		int pageNum = 1;
		
		try {
			pageNum = Integer.parseInt(sPageNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		PageBean pageBean = finishCourseBiz.stuFinishCourse(pageNum, 10,studentID);
		
		request.setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("student_FinishCourseList.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
