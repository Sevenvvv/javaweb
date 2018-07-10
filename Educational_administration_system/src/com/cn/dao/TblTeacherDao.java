package com.cn.dao;

import java.util.List;

import com.cn.entity.TblTeacher;

public interface TblTeacherDao {

	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#insertTea(com.cn.entity.TblTeacher)
	 */
	boolean insertTea(TblTeacher tblteacher);

	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#selectAll()
	 */
	List<TblTeacher> selectAll();

	TblTeacher selectByNameFun(String name);

	List<TblTeacher> selectByPageFun(int startNum, int pageSize);

	Integer selectCountFun();

}