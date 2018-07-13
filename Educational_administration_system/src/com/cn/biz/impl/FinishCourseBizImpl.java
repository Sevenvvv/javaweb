package com.cn.biz.impl;

import java.util.List;

import com.cn.biz.FinishCourseBiz;
import com.cn.dao.TblSelectedCourseDao;
import com.cn.dao.impl.TblSelectedCourseDaoImpl;
import com.cn.entity.TblSelectedCourse;
import com.cn.util.PageBean;

public class FinishCourseBizImpl implements FinishCourseBiz {

	private TblSelectedCourseDao tblSelectedCourseDao = new TblSelectedCourseDaoImpl();
	
	public PageBean stuFinishCourse(int pageNum,int pageSize,int studentID){
			
		int rowCount = tblSelectedCourseDao.finishCountFun(studentID);  //总行数
		int pageCount = rowCount / pageSize;					//总页数
		if (rowCount % pageSize != 0)
			pageCount ++;
		
		int startNum = (pageNum - 1) * pageSize;		
		List<TblSelectedCourse> stuList = tblSelectedCourseDao.FinishCourse(startNum, pageSize, studentID);
		
		PageBean pageBean  = new PageBean();
		pageBean.setPageNum(pageNum);
		pageBean.setPageSize(pageSize);
		pageBean.setRowCount(rowCount);
		pageBean.setPageCount(pageCount);
		pageBean.setLists(stuList);
		
		return pageBean;
	}

	public boolean ChoiceCourse(TblSelectedCourse tblSelectedCourse) {
		return tblSelectedCourseDao.ChoiceCourse(tblSelectedCourse);
	}
	
}
