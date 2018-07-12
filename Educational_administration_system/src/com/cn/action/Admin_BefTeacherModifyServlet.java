package com.cn.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.dao.TblStudentDao;
import com.cn.dao.TblTeacherDao;
import com.cn.dao.impl.TblStudentDaoImpl;
import com.cn.dao.impl.TblTeacherDaoImpl;
import com.cn.entity.TblStudent;
import com.cn.entity.TblTeacher;

public class Admin_BefTeacherModifyServlet extends HttpServlet {

	private TblTeacherDao tblTeacherDao = new TblTeacherDaoImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sTeacherId = request.getParameter("teacherId");
		try {
			int teacherId = Integer.parseInt(sTeacherId);
			TblTeacher tblteacher = tblTeacherDao.selectByIDFun(teacherId);
			request.setAttribute("tblteacher", tblteacher);
			request.getRequestDispatcher("admin_UpdateTeacher.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("admin_Teacherlist");
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
