package com.cn.biz.impl;

import com.cn.entity.TblAdmin;
import com.cn.entity.TblStudent;
import com.cn.entity.TblTeacher;

public interface TblUsersBiz {

	/* (non-Javadoc)
	 * @see com.cn.biz.impl.TblUserBiz#stulogin(java.lang.String, java.lang.String)
	 */
	TblStudent stulogin(String username, String password);

	/* (non-Javadoc)
	 * @see com.cn.biz.impl.TblUserBiz#tealogin(java.lang.String, java.lang.String)
	 */
	TblTeacher tealogin(String username, String password);

	/* (non-Javadoc)
	 * @see com.cn.biz.impl.TblUserBiz#adminlogin(java.lang.String, java.lang.String)
	 */
	TblAdmin adminlogin(String username, String password);

}