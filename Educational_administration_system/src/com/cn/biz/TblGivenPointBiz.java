package com.cn.biz;

import com.cn.entity.TblStudent;

public interface TblGivenPointBiz {

	boolean givenPotin(int mark ,int studentID, int courseID);
	
	TblStudent findstu(int studentID);

}