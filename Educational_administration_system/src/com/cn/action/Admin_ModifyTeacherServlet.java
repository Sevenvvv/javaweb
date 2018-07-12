package com.cn.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.biz.TblModifyBiz;
import com.cn.biz.impl.TblModifyBizImpl;
import com.cn.entity.TblTeacher;

public class Admin_ModifyTeacherServlet extends HttpServlet {

	private TblModifyBiz tblModifyBiz = new TblModifyBizImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		TblTeacher tblTeacher = new TblTeacher();
		
		String errMsg = "";
		
		String sTeacherId = request.getParameter("teacherId");
		try {
			if (sTeacherId == null || "".equals(sTeacherId)){
			}else{
				Integer teacherId = Integer.parseInt(sTeacherId);
				tblTeacher.setTeacherID(teacherId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String teacherName = request.getParameter("teacherName");
		if (teacherName == null || "".equals(teacherName)){
			errMsg = errMsg + "教师名称不能为空<br/>";
		}else{
			tblTeacher.setTeacherName(teacherName);
		}
			
		String sex = request.getParameter("sex"); 									
		if (sex == null || "".equals(sex)){
		}else{
			tblTeacher.setSex(sex);
		}
		
		String sBirthYear = request.getParameter("birthYear"); 									
		try {
			Date birthYear = Date.valueOf(sBirthYear);
			tblTeacher.setBirthYear(birthYear);
		} catch (Exception e) {
			errMsg = errMsg + "生日必须满足yyyy-MM-dd格式<br/>";
			e.printStackTrace();
		}
		
		String degree = request.getParameter("degree");
		if (degree == null || "".equals(degree)){
		}else{
			tblTeacher.setDegree(degree);
		}
		
		String ptitle = request.getParameter("ptitle");
		if (ptitle == null || "".equals(ptitle)){
		}else{
			tblTeacher.setPtitle(ptitle);
		}
		
		String sGrade = request.getParameter("grade");
		try {
			Date grade = Date.valueOf(sGrade);
			tblTeacher.setGrade(grade);
		} catch (Exception e) {
			errMsg = errMsg + "入职日期必须满足yyyy-MM-dd格式<br/>";
			e.printStackTrace();
		}
		
		String sCollegeId = request.getParameter("collegeId");
		try {
			Integer collegeId = Integer.valueOf(sCollegeId);
			tblTeacher.setCollegeID(collegeId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if ("".equals(errMsg)){
			boolean flag = tblModifyBiz.modifyTeacher(tblTeacher);
			if (flag){
				response.sendRedirect("admin_Teacherlist");
			}else{
				errMsg = errMsg + "修改失败<br/>";
				request.setAttribute("tblteacher", tblTeacher);
				request.setAttribute("errMsg", errMsg);
				request.getRequestDispatcher("admin_UpdateTeacher.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("tblteacher", tblTeacher);
			request.setAttribute("errMsg", errMsg);
			request.getRequestDispatcher("admin_UpdateTeacher.jsp").forward(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
