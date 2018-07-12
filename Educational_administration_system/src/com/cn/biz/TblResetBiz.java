package com.cn.biz;

import com.cn.entity.TblStudent;
import com.cn.entity.TblTeacher;

public interface TblResetBiz {

	boolean resetStu(TblStudent tblstudent);

	boolean resetTea(TblTeacher tblteacher);

}