package com.cn.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cn.biz.TblNewPswBiz;
import com.cn.biz.TblUsersBiz;
import com.cn.biz.impl.TblNewPswBizImpl;
import com.cn.biz.impl.TblUsersBizImpl;
import com.cn.entity.TblTeacher;

public class Teacher_SetNewPasswordServlet extends HttpServlet {

	private TblNewPswBiz tblNewPswBiz = new TblNewPswBizImpl();
	private TblUsersBiz tblUsersBiz = new TblUsersBizImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
String errMsg = "";
		
		HttpSession session =request.getSession();
		TblTeacher oldtblteacher = ((TblTeacher) session.getAttribute("tuser"));
		TblTeacher newtblteacher = new TblTeacher();
		newtblteacher.setTeacherID(oldtblteacher.getTeacherID());
		newtblteacher.setTeacherName(oldtblteacher.getTeacherName());
		
		boolean i = false;
		String op = tblNewPswBiz.checkpswTea(oldtblteacher).getOldPassword();
		
		String oldPassword =  request.getParameter("oldPassword");
		if (oldPassword == null || "".equals(oldPassword)){
			errMsg = errMsg + "旧密码不能为空<br/>";
		}else{
			if(oldPassword.equals(op)){
				i = true;
				newtblteacher.setOldPassword(oldPassword);
			}else{
				errMsg = errMsg + "旧密码不正确<br/>";
			}
		}
		
		String newPassword =  request.getParameter("newPassword");
		if (newPassword == null || "".equals(newPassword)){
			errMsg = errMsg + "新密码不能为空<br/>";
		}else{
			newtblteacher.settPassword(newPassword);
		}
		
		String rePassword =  request.getParameter("rePassword");
		if (rePassword == null || "".equals(rePassword)){
			errMsg = errMsg + "请确认密码<br/>";
		}else{
			if(newPassword.equals(rePassword)){
			}else{
				errMsg = errMsg + "确认密码不一样<br/>";
			}
		}
		
		
		if("".equals(errMsg)){
			if(i){
				boolean flag = tblNewPswBiz.newpswTea(newtblteacher);
				if(flag){
					request.setAttribute("errMsg", "修改密码成功请重新登录");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}else{
					request.setAttribute("errMsg", "修改失败");
					request.getRequestDispatcher("teacher_SetNewPasaword.jsp").forward(request, response);
				}
			}
		}else{
			request.setAttribute("errMsg", errMsg);
			request.getRequestDispatcher("teacher_SetNewPasaword.jsp").forward(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
