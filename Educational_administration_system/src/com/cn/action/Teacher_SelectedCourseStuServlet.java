package com.cn.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cn.biz.SelectedCourseBiz;
import com.cn.biz.impl.SelectedCourseBizImpl;
import com.cn.entity.TblTeacher;
import com.cn.util.PageBean;

public class Teacher_SelectedCourseStuServlet extends HttpServlet {

	private SelectedCourseBiz selectedCourseBiz = new SelectedCourseBizImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String sPageNum = request.getParameter("pageNum");
		String sCourseId = request.getParameter("courseId");
		int courseID = 0;
		
		try {
			courseID = Integer.parseInt(sCourseId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		HttpSession session =request.getSession();
		TblTeacher tblteacher = ((TblTeacher) session.getAttribute("tuser"));
		int teacherID = tblteacher.getTeacherID();
		
		int pageNum = 1;
		
		try {
			pageNum = Integer.parseInt(sPageNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		PageBean pageBean = selectedCourseBiz.SelectedCourseStu(pageNum, 10, courseID);
		
		request.setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("teacher_SelectedCourseStu.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
