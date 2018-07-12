package com.cn.dao;

import java.util.List;

import com.cn.entity.TblAdmin;

public interface TblAdminDao {

	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblAdminDao#selectAll()
	 */
	List<TblAdmin> selectAll();

	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblAdminDao#selectByIDFun(int)
	 */
	TblAdmin selectByIDandPsw(TblAdmin tbladmin);

	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblAdminDao#selectByUsernameFun(java.lang.String)
	 */
	TblAdmin selectByUsernameFun(String name);

	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblAdminDao#deleteById(int)
	 */
	boolean deleteById(int adminID);

	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblAdminDao#newPwd(com.cn.entity.TblAdmin)
	 */
	boolean newPwd(TblAdmin tbladmin);

}