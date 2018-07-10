package com.cn.biz.impl;

import com.cn.util.PageBean;

public interface TblCourseBiz {

	PageBean CourseViewByPageFun(int pageNum, int pageSize);

}