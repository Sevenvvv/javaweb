package com.cn.biz;

import com.cn.entity.TblAdmin;
import com.cn.entity.TblStudent;
import com.cn.entity.TblTeacher;

public interface TblUserBiz {

	public TblStudent stulogin(String name, String password);

	public TblTeacher tealogin(String name, String password);

	public TblAdmin adminlogin(String name, String password);

}