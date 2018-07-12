package com.cn.biz;

import com.cn.entity.TblAdmin;
import com.cn.entity.TblStudent;
import com.cn.entity.TblTeacher;

public interface TblNewPswBiz {

	boolean newpswStu(TblStudent tblstudent);

	boolean newpswTea(TblTeacher tblteacher);

	boolean newpswAdmin(TblAdmin tbladmin);

	TblAdmin checkpswAdmin(TblAdmin tbladmin);

	TblStudent checkpswStu(TblStudent tblstudent);

	TblTeacher checkpswTea(TblTeacher tblteacher);

}