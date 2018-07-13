package com.cn.biz;

import com.cn.util.PageBean;

public interface TblListBiz {

	/* (non-Javadoc)
	 * @see com.cn.biz.impl.TblStuAndTeaBiz#stuCourseViewByPageFun(int, int)
	 */
	PageBean stuCourseViewByPageFun(int pageNum, int pageSize);

	/* (non-Javadoc)
	 * @see com.cn.biz.impl.TblStuAndTeaBiz#teaCourseViewByPageFun(int, int)
	 */
	PageBean teaCourseViewByPageFun(int pageNum, int pageSize);

	PageBean CourseViewByPageFun(int pageNum, int pageSize);

}