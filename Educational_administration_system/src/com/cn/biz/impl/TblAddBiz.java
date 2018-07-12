package com.cn.biz.impl;

import com.cn.entity.TblCourse;
import com.cn.entity.TblStudent;
import com.cn.entity.TblTeacher;

public interface TblAddBiz {

	boolean addCourse(TblCourse tblcourse);

	boolean addStudent(TblStudent tblStudent);

	boolean addTeacher(TblTeacher tblteacher);

}