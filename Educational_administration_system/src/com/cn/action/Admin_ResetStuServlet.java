package com.cn.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.biz.TblResetBiz;
import com.cn.biz.impl.TblResetBizImpl;
import com.cn.dao.TblStudentDao;
import com.cn.entity.TblStudent;

public class Admin_ResetStuServlet extends HttpServlet {
	
	private TblResetBiz tblResetBiz = new TblResetBizImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TblStudent tblStudent = new TblStudent();
		tblStudent.setsPassword("123456");
		
		String sStudentID = request.getParameter("studentId");
		try{
			int studentID =Integer.parseInt(sStudentID);
			tblStudent.setStudentID(studentID);
			tblResetBiz.resetStu(tblStudent);
			response.sendRedirect("admin_Resetstulist");
		}catch(Exception e){
			e.printStackTrace();
			response.sendRedirect("admin_Resetstulist");
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
