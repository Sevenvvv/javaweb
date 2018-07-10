package com.cn.dao;

import java.util.List;

import com.cn.entity.TblCourse;
import com.cn.entity.TblStudent;

public interface TblCourseDao {

	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblStudentDao#insertStu(com.cn.entity.TblStudent)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblStudentDao#insertStu(com.cn.entity.TblStudent)
	 */
	boolean insertCou(TblCourse tblcourse);

	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblStudentDao#selectAll()
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblStudentDao#selectAll()
	 */
	List<TblCourse> selectAll();

	Integer selectCountFun();

	List<TblCourse> selectByPageFun(int startNum, int pageSize);

}