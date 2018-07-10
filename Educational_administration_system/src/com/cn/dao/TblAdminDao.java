package com.cn.dao;

import java.util.List;

import com.cn.entity.TblAdmin;

public interface TblAdminDao {

	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblAdminDao#selectAll()
	 */
	List<TblAdmin> selectAll();

	TblAdmin selectByNameFun(String name);

}