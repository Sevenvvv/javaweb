package com.cn.biz.impl;

import com.cn.dao.impl.TblAdminDaoImpl;
import com.cn.dao.impl.TblStudentDaoImpl;
import com.cn.dao.impl.TblTeacherDaoImpl;
import com.cn.entity.TblAdmin;
import com.cn.entity.TblStudent;
import com.cn.entity.TblTeacher;
import com.cn.biz.TblUserBiz;
import com.cn.dao.TblAdminDao;
import com.cn.dao.TblStudentDao;
import com.cn.dao.TblTeacherDao;

public class TblUsersBizImpl implements TblUserBiz {
	
	private TblTeacherDao tblTeacherDao = new TblTeacherDaoImpl();
	private TblStudentDao tblStudentDao = new TblStudentDaoImpl();
	private TblAdminDao tblAdminDao = new TblAdminDaoImpl();
	
	/* (non-Javadoc)
	 * @see com.cn.biz.impl.TblUserBiz#stulogin(java.lang.String, java.lang.String)
	 */
	public TblStudent stulogin(String name, String password) {
		TblStudent tblstudent = tblStudentDao.selectByNameFun(name);
		
		if (tblstudent != null && password.equals(tblstudent.getsPassword())){
			return tblstudent;
		}
		
		return null;
	}
	
	/* (non-Javadoc)
	 * @see com.cn.biz.impl.TblUserBiz#tealogin(java.lang.String, java.lang.String)
	 */
	public TblTeacher tealogin(String name, String password) {
		TblTeacher tblteacher = tblTeacherDao.selectByNameFun(name);
		
		if (tblteacher != null && password.equals(tblteacher.gettPassword())){
			return tblteacher;
		}
		
		return null;
	}
	
	/* (non-Javadoc)
	 * @see com.cn.biz.impl.TblUserBiz#adminlogin(java.lang.String, java.lang.String)
	 */
	public TblAdmin adminlogin(String name, String password) {
		TblAdmin tbladmin = tblAdminDao.selectByNameFun(name);
		
		if (tbladmin != null && password.equals(tbladmin.getaPassword())){
			return tbladmin;
		}
		
		return null;
	}
}
