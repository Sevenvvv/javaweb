package com.cn.dao;

import java.util.List;

import com.cn.entity.TblTeacher;

public interface TblTeacherDao {

	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#insertTea(com.cn.entity.TblTeacher)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#insertTea(com.cn.entity.TblTeacher)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#insertTea(com.cn.entity.TblTeacher)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#insertTea(com.cn.entity.TblTeacher)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#insertTea(com.cn.entity.TblTeacher)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#insertTea(com.cn.entity.TblTeacher)
	 */
	boolean insertTea(TblTeacher tblteacher);

	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#selectAll()
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#selectAll()
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#selectAll()
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#selectAll()
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#selectAll()
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#selectAll()
	 */
	List<TblTeacher> selectAll();

	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#selectByNameFun(java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#selectByIDFun(int)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#selectByIDFun(int)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#selectByIDFun(com.cn.entity.TblTeacher)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#selectByIDandPsw(com.cn.entity.TblTeacher)
	 */
	TblTeacher selectByIDandPsw(TblTeacher tblteacher);

	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#selectByIDFun(int)
	 */
	TblTeacher selectByIDFun(int teacherID);

	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#selectByUSernameFun(java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#selectByUsernameFun(java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#selectByUsernameFun(java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#selectByUsernameFun(java.lang.String)
	 */
	TblTeacher selectByUsernameFun(String name);

	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#selectByPageFun(int, int)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#selectByPageFun(int, int)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#selectByPageFun(int, int)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#selectByPageFun(int, int)
	 */
	List<TblTeacher> selectByPageFun(int startNum, int pageSize);

	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#selectCountFun()
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#selectCountFun()
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#selectCountFun()
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#selectCountFun()
	 */
	Integer selectCountFun();

	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#deleteById(int)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#deleteById(int)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#deleteById(int)
	 */
	boolean deleteById(int teacherID);

	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#updateM(com.cn.entity.TblTeacher)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#updateM(com.cn.entity.TblTeacher)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#updateM(com.cn.entity.TblTeacher)
	 */
	boolean updateM(TblTeacher tblteacher);

	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#newPwd(com.cn.entity.TblTeacher)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#newPwd(com.cn.entity.TblTeacher)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#newPwd(com.cn.entity.TblTeacher)
	 */
	boolean newPwd(TblTeacher tblteacher);

}