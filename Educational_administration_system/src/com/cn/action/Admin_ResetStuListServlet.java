package com.cn.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.biz.TblStuAndTeaBiz;
import com.cn.biz.impl.TblStuAndTeaBizImpl;
import com.cn.util.PageBean;

public class Admin_ResetStuListServlet extends HttpServlet {

private TblStuAndTeaBiz tblStuAndTeaBiz = new TblStuAndTeaBizImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String sPageNum = request.getParameter("pageNum");
		int pageNum = 1;
		
		try {
			pageNum = Integer.parseInt(sPageNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		PageBean pageBean = tblStuAndTeaBiz.stuCourseViewByPageFun(pageNum, 10);
		
		request.setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("admin_ResetStuList.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
