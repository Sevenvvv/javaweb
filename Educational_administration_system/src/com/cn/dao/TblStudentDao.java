package com.cn.dao;

import java.util.List;

import com.cn.entity.TblStudent;

public interface TblStudentDao {

	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblStudentDao#insertStu(com.cn.entity.TblStudent)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblStudentDao#insertStu(com.cn.entity.TblStudent)
	 */
	boolean insertStu(TblStudent tblstudent);

	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblStudentDao#selectAll()
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblStudentDao#selectAll()
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblStudentDao#selectAll()
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblStudentDao#selectAll()
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblStudentDao#selectAll()
	 */
	List<TblStudent> selectAll();

	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblStudentDao#selectByNameFun(java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblStudentDao#selectByIDFun(int)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblStudentDao#selectByIDFun(int)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblStudentDao#selectByIDandPsw(com.cn.entity.TblStudent)
	 */
	TblStudent selectByIDandPsw(TblStudent tblstudent);

	TblStudent selectByIDFun(int studentID);

	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblStudentDao#selectByUsernameFun(java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblStudentDao#selectByUsernameFun(java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblStudentDao#selectByUsernameFun(java.lang.String)
	 */
	TblStudent selectByUsernameFun(String name);

	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblStudentDao#selectByPageFun(int, int)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblStudentDao#selectByPageFun(int, int)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblStudentDao#selectByPageFun(int, int)
	 */
	List<TblStudent> selectByPageFun(int startNum, int pageSize);

	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblStudentDao#selectCountFun()
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblStudentDao#selectCountFun()
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblStudentDao#selectCountFun()
	 */
	Integer selectCountFun();

	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblStudentDao#deleteById(int)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblStudentDao#deleteById(int)
	 */
	boolean deleteById(int studentID);

	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblStudentDao#updateM(com.cn.entity.TblStudent)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblStudentDao#updateM(com.cn.entity.TblStudent)
	 */
	boolean updateM(TblStudent tblstudent);

	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblStudentDao#newPwd(com.cn.entity.TblStudent)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblStudentDao#newPwd(com.cn.entity.TblStudent)
	 */
	boolean newPwd(TblStudent tblstudent);

}