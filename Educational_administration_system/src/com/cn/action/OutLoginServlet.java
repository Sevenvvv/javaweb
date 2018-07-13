package com.cn.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OutLoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getSession().getAttribute("suser");
		request.removeAttribute("suser");
		request.getSession().getAttribute("auser");
		request.removeAttribute("auser");
		request.getSession().getAttribute("tuser");
		request.removeAttribute("tuser");
		response.sendRedirect("login.jsp");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
