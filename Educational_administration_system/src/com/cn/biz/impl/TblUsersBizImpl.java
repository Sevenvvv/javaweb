package com.cn.biz.impl;

import com.cn.dao.impl.TblAdminDaoImpl;
import com.cn.dao.impl.TblStudentDaoImpl;
import com.cn.dao.impl.TblTeacherDaoImpl;
import com.cn.entity.TblAdmin;
import com.cn.entity.TblStudent;
import com.cn.entity.TblTeacher;
import com.cn.biz.TblUsersBiz;
import com.cn.dao.TblStudentDao;
import com.cn.dao.TblTeacherDao;

public class TblUsersBizImpl implements TblUsersBiz {
	
	private TblTeacherDao tblTeacherDao = new TblTeacherDaoImpl();
	private TblStudentDao tblStudentDao = new TblStudentDaoImpl();
	private com.cn.dao.TblAdminDao tblAdminDao = new TblAdminDaoImpl();

	public TblStudent stulogin(String id, String password) {
		TblStudent tblstudent = tblStudentDao.selectByUsernameFun(id);
		
		if (tblstudent != null && password.equals(tblstudent.getsPassword())){
			return tblstudent;
		}
		
		return null;
	}
	
	public TblTeacher tealogin(String id, String password) {
		TblTeacher tblteacher = tblTeacherDao.selectByUsernameFun(id);
		
		if (tblteacher != null && password.equals(tblteacher.gettPassword())){
			return tblteacher;
		}
		
		return null;
	}

	public TblAdmin adminlogin(String id, String password) {
		TblAdmin tbladmin = tblAdminDao.selectByUsernameFun(id);
		
		if (tbladmin != null && password.equals(tbladmin.getaPassword())){
			return tbladmin;
		}
		
		return null;
	}
	
}
