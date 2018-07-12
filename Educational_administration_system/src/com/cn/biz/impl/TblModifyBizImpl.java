package com.cn.biz.impl;

import com.cn.biz.TblModifyBiz;
import com.cn.dao.TblCourseDao;
import com.cn.dao.TblStudentDao;
import com.cn.dao.TblTeacherDao;
import com.cn.dao.impl.TblCourseDaoImpl;
import com.cn.dao.impl.TblStudentDaoImpl;
import com.cn.dao.impl.TblTeacherDaoImpl;
import com.cn.entity.TblCourse;
import com.cn.entity.TblStudent;
import com.cn.entity.TblTeacher;

public class TblModifyBizImpl implements TblModifyBiz {
	
	private TblCourseDao tblCourseDao = new TblCourseDaoImpl();
	private TblStudentDao tblStudentDao = new TblStudentDaoImpl();
	private TblTeacherDao tblTeacherDao = new TblTeacherDaoImpl();
	
	/* (non-Javadoc)
	 * @see com.cn.biz.impl.TblModifyBiz#modifyCourse(com.cn.entity.TblCourse)
	 */
	public boolean modifyCourse(TblCourse tblcourse){
		return tblCourseDao.updateM(tblcourse);
	}
	
	/* (non-Javadoc)
	 * @see com.cn.biz.impl.TblModifyBiz#modifyStudent(com.cn.entity.TblStudent)
	 */
	public boolean modifyStudent(TblStudent tblStudent){
		return tblStudentDao.updateM(tblStudent);
	}

	/* (non-Javadoc)
	 * @see com.cn.biz.impl.TblModifyBiz#modifyTeacher(com.cn.entity.TblTeacher)
	 */
	public boolean modifyTeacher(TblTeacher tblteacher){
		return tblTeacherDao.updateM(tblteacher);
	}
	
}
