package com.cn.dao;

import java.util.List;

import com.cn.entity.TblSelectedCourse;

public interface TblSelectedCourseDao {

	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblSelectedCourseDao#ChoiceCourse(com.cn.entity.TblSelectedCourse)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblSelectedCourseDao#ChoiceCourse(com.cn.entity.TblSelectedCourse)
	 */
	boolean ChoiceCourse(TblSelectedCourse tblSelectedCourse);

	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblSelectedCourseDao#SelectedCourse(int)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblSelectedCourseDao#SelectedCourse(int, int, int)
	 */
	List<TblSelectedCourse> stuSelectedCourse(int startNum, int pageSize, int studentID);

	List<TblSelectedCourse> teaSelectedCourse(int startNum, int pageSize, int teacherID);

	List<TblSelectedCourse> FinishCourse(int startNum, int pageSize, int studentID);

	boolean QuitCourse(int courseID,int studentID);

	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblSelectedCourseDao#selectCountFun()
	 */
	Integer selectCountFunStu(int studentID);

	Integer selectCountFunTea(int teacherID);

	Integer finishCountFun(int studentID);

	Integer selectCourseStuCountFun(int courseID);

	List<TblSelectedCourse> selectedCourseStu(int startNum, int pageSize, int studentID);

	boolean givenPoint(int mark ,int studentID, int courseID);

}