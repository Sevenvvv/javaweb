package com.cn.biz;

import com.cn.entity.TblCourse;
import com.cn.entity.TblStudent;
import com.cn.entity.TblTeacher;

public interface TblModifyBiz {

	boolean modifyCourse(TblCourse tblcourse);

	boolean modifyStudent(TblStudent tblStudent);

	boolean modifyTeacher(TblTeacher tblteacher);

}