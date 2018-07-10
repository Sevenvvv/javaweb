package com.cn.biz;

import com.cn.util.PageBean;

public interface TblStuAndTeaBiz {

	PageBean stuCourseViewByPageFun(int pageNum, int pageSize);

	PageBean teaCourseViewByPageFun(int pageNum, int pageSize);

}