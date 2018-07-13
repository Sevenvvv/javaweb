package com.cn.biz;

import com.cn.entity.TblSelectedCourse;
import com.cn.util.PageBean;

public interface FinishCourseBiz {

	PageBean stuFinishCourse(int pageNum, int pageSize, int studentID);
	
	boolean ChoiceCourse(TblSelectedCourse tblSelectedCourse);

}