package com.cn.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.dao.TblCourseDao;
import com.cn.dao.impl.TblCourseDaoImpl;
import com.cn.entity.TblCourse;

public class Admin_BefCourseModifyServlet extends HttpServlet {

	private TblCourseDao tblCoursedao = new TblCourseDaoImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sCourseId = request.getParameter("courseId");
		try {
			int courseId = Integer.parseInt(sCourseId);
			TblCourse tblcourse = tblCoursedao.selectByIDFun(courseId);
			request.setAttribute("tblcourse", tblcourse);
			request.getRequestDispatcher("admin_UpdateCourse.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("admin_Courselist");
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
