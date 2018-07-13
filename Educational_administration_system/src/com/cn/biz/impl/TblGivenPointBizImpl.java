package com.cn.biz.impl;

import com.cn.biz.TblGivenPointBiz;
import com.cn.dao.TblSelectedCourseDao;
import com.cn.dao.TblStudentDao;
import com.cn.dao.impl.TblSelectedCourseDaoImpl;
import com.cn.dao.impl.TblStudentDaoImpl;
import com.cn.entity.TblStudent;
import com.cn.util.PageBean;

public class TblGivenPointBizImpl implements TblGivenPointBiz {

	private TblSelectedCourseDao tblSelectedCourseDao = new TblSelectedCourseDaoImpl();
	private TblStudentDao tblStudentDao = new TblStudentDaoImpl();
	
	/* (non-Javadoc)
	 * @see com.cn.biz.impl.TblGivenPointBiz#givenPotin(int, int)
	 */
	public boolean givenPotin(int mark ,int studentID,int courseID){
		return tblSelectedCourseDao.givenPoint(mark, studentID, courseID);
	}
	
	public TblStudent findstu(int studentID){
		return tblStudentDao.selectByIDFun(studentID);
	}
	
}
