package com.cn.dao;

import java.util.List;

import com.cn.entity.TblCourse;

public interface TblCourseDao {

	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblCourseDao#insertCou(com.cn.entity.TblCourse)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblCourseDao#insertCou(com.cn.entity.TblCourse)
	 */
	boolean insertCou(TblCourse tblcourse);

	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblCourseDao#selectAll()
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblCourseDao#selectAll()
	 */
	List<TblCourse> selectAll();

	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblCourseDao#selectByIDFun(java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblCourseDao#selectByIDFun(int)
	 */
	TblCourse selectByIDFun(int courseID);

	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblCourseDao#selectByUsernameFun(java.lang.String)
	 */
	TblCourse selectByUsernameFun(String name);

	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblCourseDao#selectByPageFun(int, int)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblCourseDao#selectByPageFun(int, int)
	 */
	List<TblCourse> selectByPageFun(int startNum, int pageSize);

	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblCourseDao#selectCountFun()
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblCourseDao#selectCountFun()
	 */
	Integer selectCountFun();

	boolean deleteById(int courseID);

	boolean updateM(TblCourse tblcourse);

}