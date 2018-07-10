package com.cn.dao;

import java.util.List;

import com.cn.entity.TblStudent;

public interface TblStudentDao {

	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblStudentDao#insertStu(com.cn.entity.TblStudent)
	 */
	boolean insertStu(TblStudent tblstudent);

	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblStudentDao#selectAll()
	 */
	List<TblStudent> selectAll();

	TblStudent selectByNameFun(String name);

	List<TblStudent> selectByPageFun(int startNum, int pageSize);

	Integer selectCountFun();

}