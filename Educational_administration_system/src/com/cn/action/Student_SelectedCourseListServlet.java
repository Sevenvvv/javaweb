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
import com.cn.dao.TblSelectedCourseDao;
import com.cn.dao.impl.TblSelectedCourseDaoImpl;
import com.cn.entity.TblStudent;
import com.cn.util.PageBean;

public class Student_SelectedCourseListServlet extends HttpServlet {
	
	private SelectedCourseBiz selectedCourseBiz = new SelectedCourseBizImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String sPageNum = request.getParameter("pageNum");
		HttpSession session =request.getSession();
		TblStudent tblstudent = ((TblStudent) session.getAttribute("suser"));
		int studentID = tblstudent.getStudentID();
		
		int pageNum = 1;
		
		try {
			pageNum = Integer.parseInt(sPageNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		PageBean pageBean = selectedCourseBiz.stuSelectedCourse(pageNum, 10,studentID);
		
		request.setAttribute("pageBean", pageBean);
		request.setAttribute("studentID", studentID);
		request.getRequestDispatcher("student_SelectedCourseList.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
