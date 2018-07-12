package com.cn.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.biz.TblDelBiz;
import com.cn.biz.impl.TblDelBizImpl;

public class Admin_DelCourseServlet extends HttpServlet {

	private TblDelBiz tblDelBiz = new TblDelBizImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String sCourseID = request.getParameter("courseId");
		try{
			int courseID =Integer.parseInt(sCourseID);
			tblDelBiz.delCourse(courseID);
			response.sendRedirect("admin_Courselist");
		}catch(Exception e){
			e.printStackTrace();
			response.sendRedirect("admin_Courselist");
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
