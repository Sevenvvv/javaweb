package com.cn.biz.impl;

import com.cn.biz.TblNewPswBiz;
import com.cn.dao.TblAdminDao;
import com.cn.dao.TblStudentDao;
import com.cn.dao.TblTeacherDao;
import com.cn.dao.impl.TblAdminDaoImpl;
import com.cn.dao.impl.TblStudentDaoImpl;
import com.cn.dao.impl.TblTeacherDaoImpl;
import com.cn.entity.TblAdmin;
import com.cn.entity.TblStudent;
import com.cn.entity.TblTeacher;

public class TblNewPswBizImpl implements TblNewPswBiz {
	
	private TblStudentDao tblStudentDao = new TblStudentDaoImpl();
	private TblTeacherDao tblTeacherDao = new TblTeacherDaoImpl();
	private TblAdminDao tblAdminDao = new TblAdminDaoImpl();

	/* (non-Javadoc)
	 * @see com.cn.biz.impl.TblNewPswBiz#newpswStu(com.cn.entity.TblStudent)
	 */
	public boolean newpswStu(TblStudent tblstudent){
		return tblStudentDao.newPwd(tblstudent);
	}

	/* (non-Javadoc)
	 * @see com.cn.biz.impl.TblNewPswBiz#newpswTea(com.cn.entity.TblTeacher)
	 */
	public boolean newpswTea(TblTeacher tblteacher){
		return tblTeacherDao.newPwd(tblteacher);
	}

	/* (non-Javadoc)
	 * @see com.cn.biz.impl.TblNewPswBiz#newpswAdmin(com.cn.entity.TblAdmin)
	 */
	public boolean newpswAdmin(TblAdmin tbladmin){
		return tblAdminDao.newPwd(tbladmin);
	}
	
	/* (non-Javadoc)
	 * @see com.cn.biz.impl.TblNewPswBiz#checkpswAdmin(com.cn.entity.TblAdmin)
	 */
	public TblAdmin checkpswAdmin(TblAdmin tbladmin){
		return tblAdminDao.selectByIDandPsw(tbladmin);
	}
	
	/* (non-Javadoc)
	 * @see com.cn.biz.impl.TblNewPswBiz#checkpswStu(com.cn.entity.TblStudent)
	 */
	public TblStudent checkpswStu(TblStudent tblstudent){
		return tblStudentDao.selectByIDandPsw(tblstudent);
	}
	
	/* (non-Javadoc)
	 * @see com.cn.biz.impl.TblNewPswBiz#checkpswTea(com.cn.entity.TblTeacher)
	 */
	public TblTeacher checkpswTea(TblTeacher tblteacher){
		return tblTeacherDao.selectByIDandPsw(tblteacher);
	}
}
