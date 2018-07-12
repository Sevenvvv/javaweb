package com.cn.biz.impl;

import com.cn.biz.TblResetBiz;
import com.cn.dao.TblAdminDao;
import com.cn.dao.TblStudentDao;
import com.cn.dao.TblTeacherDao;
import com.cn.dao.impl.TblAdminDaoImpl;
import com.cn.dao.impl.TblStudentDaoImpl;
import com.cn.dao.impl.TblTeacherDaoImpl;
import com.cn.entity.TblStudent;
import com.cn.entity.TblTeacher;

public class TblResetBizImpl implements TblResetBiz {
	
	private TblStudentDao tblStudentDao = new TblStudentDaoImpl();
	private TblTeacherDao tblTeacherDao = new TblTeacherDaoImpl();
	
	/* (non-Javadoc)
	 * @see com.cn.biz.impl.TblResetBiz#resetStu(com.cn.entity.TblStudent)
	 */
	public boolean resetStu(TblStudent tblstudent){
		return tblStudentDao.newPwd(tblstudent);
	}
	
	/* (non-Javadoc)
	 * @see com.cn.biz.impl.TblResetBiz#resetTea(com.cn.entity.TblTeacher)
	 */
	public boolean resetTea(TblTeacher tblteacher){
		return tblTeacherDao.newPwd(tblteacher);
	}
	
}
