package com.cn.biz;

import com.cn.util.PageBean;

public interface SelectedCourseBiz {

	PageBean stuSelectedCourse(int pageNum, int pageSize, int studentID);
	
	PageBean teaSelectedCourse(int pageNum,int pageSize,int teacherID);
	
	PageBean SelectedCourseStu(int pageNum,int pageSize,int studentID);

}