package com.cn.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.biz.TblDelBiz;
import com.cn.biz.impl.TblDelBizImpl;

public class Admin_DelStudentServlet extends HttpServlet {

	private TblDelBiz tblDelBiz = new TblDelBizImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String sStudentID = request.getParameter("studentId");
		try{
			int studentID =Integer.parseInt(sStudentID);
			tblDelBiz.delStudent(studentID);
			response.sendRedirect("admin_Studentlist");
		}catch(Exception e){
			e.printStackTrace();
			response.sendRedirect("admin_Studentlist");
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
