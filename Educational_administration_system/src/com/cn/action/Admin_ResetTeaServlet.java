package com.cn.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.biz.TblResetBiz;
import com.cn.biz.impl.TblResetBizImpl;
import com.cn.entity.TblStudent;
import com.cn.entity.TblTeacher;

public class Admin_ResetTeaServlet extends HttpServlet {

	private TblResetBiz tblResetBiz = new TblResetBizImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TblTeacher tblTeacher = new TblTeacher();
		tblTeacher.settPassword("123456");
		
		String sTeacherID = request.getParameter("teacherId");
		try{
			int teacherID =Integer.parseInt(sTeacherID);
			tblTeacher.setTeacherID(teacherID);
			tblResetBiz.resetTea(tblTeacher);
			response.sendRedirect("admin_Resettealist");
		}catch(Exception e){
			e.printStackTrace();
			response.sendRedirect("admin_Resettealist");
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
