package com.cn.biz.impl;

import com.cn.biz.TblAddBiz;
import com.cn.dao.TblCourseDao;
import com.cn.dao.TblStudentDao;
import com.cn.dao.TblTeacherDao;
import com.cn.dao.impl.TblCourseDaoImpl;
import com.cn.dao.impl.TblStudentDaoImpl;
import com.cn.dao.impl.TblTeacherDaoImpl;
import com.cn.entity.TblCourse;
import com.cn.entity.TblStudent;
import com.cn.entity.TblTeacher;

public class TblAddBizImpl implements TblAddBiz {
	
	private TblCourseDao tblCourseDao = new TblCourseDaoImpl();
	private TblStudentDao tblStudentDao = new TblStudentDaoImpl();
	private TblTeacherDao tblTeacherDao = new TblTeacherDaoImpl();
	
	/* (non-Javadoc)
	 * @see com.cn.biz.impl.TblAddBiz#addCourse(com.cn.entity.TblCourse)
	 */
	public boolean addCourse(TblCourse tblcourse){
		return tblCourseDao.insertCou(tblcourse);
	}
	
	/* (non-Javadoc)
	 * @see com.cn.biz.impl.TblAddBiz#addStudent(com.cn.entity.TblStudent)
	 */
	public boolean addStudent(TblStudent tblStudent){
		return tblStudentDao.insertStu(tblStudent);
	}
	
	/* (non-Javadoc)
	 * @see com.cn.biz.impl.TblAddBiz#addTeacher(com.cn.entity.TblTeacher)
	 */
	public boolean addTeacher(TblTeacher tblteacher){
		return tblTeacherDao.insertTea(tblteacher);
	}
	
}
