package com.cn.biz.impl;

import com.cn.biz.TblDelBiz;
import com.cn.dao.TblCourseDao;
import com.cn.dao.TblStudentDao;
import com.cn.dao.TblTeacherDao;
import com.cn.dao.impl.TblCourseDaoImpl;
import com.cn.dao.impl.TblStudentDaoImpl;
import com.cn.dao.impl.TblTeacherDaoImpl;

public class TblDelBizImpl implements TblDelBiz {
	
	private TblCourseDao tblCourseDao = new TblCourseDaoImpl();
	private TblStudentDao tblStudentDao = new TblStudentDaoImpl();
	private TblTeacherDao tblTeacherDao = new TblTeacherDaoImpl();
	
	/* (non-Javadoc)
	 * @see com.cn.biz.impl.TblDelBiz#delCourse(int)
	 */
	public boolean delCourse(int courseID){
		return tblCourseDao.deleteById(courseID);
	}
	
	/* (non-Javadoc)
	 * @see com.cn.biz.impl.TblDelBiz#delStudent(int)
	 */
	public boolean delStudent(int studentID){
		return tblStudentDao.deleteById(studentID);
	}
	
	/* (non-Javadoc)
	 * @see com.cn.biz.impl.TblDelBiz#delTeacher(int)
	 */
	public boolean delTeacher(int teacherID){
		return tblTeacherDao.deleteById(teacherID);
	}
	
}
