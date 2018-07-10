package com.cn.biz.impl;

import java.util.List;

import com.cn.biz.TblCourseBiz;
import com.cn.dao.TblCourseDao;
import com.cn.dao.impl.TblCourseDaoImpl;
import com.cn.entity.TblCourse;
import com.cn.util.PageBean;

public class TblCourseBizImpl implements TblCourseBiz {
	
	private TblCourseDao tblCourseDao = new TblCourseDaoImpl();
	
	/* (non-Javadoc)
	 * @see com.cn.biz.impl.TblCourseBiz#CourseViewByPageFun(int, int)
	 */
	public PageBean CourseViewByPageFun(int pageNum,int pageSize){
		
		int rowCount = tblCourseDao.selectCountFun();  //总行数
		int pageCount = rowCount / pageSize;					//总页数
		if (rowCount % pageSize != 0)
			pageCount ++;
		
		int startNum = (pageNum - 1) * pageSize;		
		List<TblCourse> coulist = tblCourseDao.selectByPageFun(startNum, pageSize);
		
		PageBean pageBean  = new PageBean();
		pageBean.setPageNum(pageNum);
		pageBean.setPageSize(pageSize);
		pageBean.setRowCount(rowCount);
		pageBean.setPageCount(pageCount);
		pageBean.setLists(coulist);
		
		return pageBean;
	}
	
}
