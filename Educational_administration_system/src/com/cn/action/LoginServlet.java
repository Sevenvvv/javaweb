package com.cn.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.biz.TblUsersBiz;
import com.cn.biz.impl.TblUsersBizImpl;
import com.cn.entity.TblAdmin;
import com.cn.entity.TblStudent;
import com.cn.entity.TblTeacher;

public class LoginServlet extends HttpServlet {

	private TblUsersBiz tblUsersBiz = new TblUsersBizImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String errMsg = null;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String usertype = request.getParameter("usertype");
		
		TblStudent tblstudent = null;
		TblTeacher tblteacher = null;
		TblAdmin tbladmin = null;
		
		
		
		if("1".equals(usertype)){
			tblstudent = tblUsersBiz.stulogin(username,password);
			if(tblstudent != null){
				request.getSession().setAttribute("suser", tblstudent);
				response.sendRedirect("student_Courselist");
			}else{
				request.setAttribute("errMsg", "用户名或密码错误");
				request.setAttribute("username", username);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}else if("2".equals(usertype)){
			tblteacher = tblUsersBiz.tealogin(username,password);
			if(tblteacher != null){
				request.getSession().setAttribute("tuser", tblteacher);
				response.sendRedirect("teacher_Courselist");
			}else{
				request.setAttribute("errMsg", "用户名或密码错误");
				request.setAttribute("username", username);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}else if("0".equals(usertype)){
			tbladmin = tblUsersBiz.adminlogin(username,password);
			if(tbladmin != null){
				request.getSession().setAttribute("auser", tbladmin);
				response.sendRedirect("admin_Courselist");
			}else{
				request.setAttribute("errMsg", "用户名或密码错误");
				request.setAttribute("username", username);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}else if(usertype == null){
			errMsg = "请选择用户类型!";
		}		
		
		if(errMsg != null){
			request.setAttribute("errMsg", errMsg);
			request.setAttribute("username", username);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
