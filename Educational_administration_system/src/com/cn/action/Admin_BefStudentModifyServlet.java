package com.cn.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.dao.TblCourseDao;
import com.cn.dao.TblStudentDao;
import com.cn.dao.impl.TblCourseDaoImpl;
import com.cn.dao.impl.TblStudentDaoImpl;
import com.cn.entity.TblCourse;
import com.cn.entity.TblStudent;

public class Admin_BefStudentModifyServlet extends HttpServlet {

	private TblStudentDao tblStudentDao = new TblStudentDaoImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sStudentId = request.getParameter("studentId");
		try {
			int studentId = Integer.parseInt(sStudentId);
			TblStudent tblstudent = tblStudentDao.selectByIDFun(studentId);
			request.setAttribute("tblstudent", tblstudent);
			request.getRequestDispatcher("admin_UpdateStudent.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("admin_Studentlist");
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
