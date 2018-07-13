package com.cn.biz.impl;

import java.util.List;

import com.cn.biz.SelectedCourseBiz;
import com.cn.dao.TblSelectedCourseDao;
import com.cn.dao.impl.TblCourseDaoImpl;
import com.cn.dao.impl.TblSelectedCourseDaoImpl;
import com.cn.entity.TblSelectedCourse;
import com.cn.util.PageBean;

public class SelectedCourseBizImpl implements SelectedCourseBiz {
	
	private TblSelectedCourseDao tblSelectedCourseDao = new TblSelectedCourseDaoImpl();

	public PageBean stuSelectedCourse(int pageNum,int pageSize,int studentID){
		
		int rowCount = tblSelectedCourseDao.selectCountFunStu(studentID);  //总行数
		int pageCount = rowCount / pageSize;					//总页数
		if (rowCount % pageSize != 0)
			pageCount ++;
		
		int startNum = (pageNum - 1) * pageSize;		
		List<TblSelectedCourse> stuList = tblSelectedCourseDao.stuSelectedCourse(startNum, pageSize, studentID);
		
		PageBean pageBean  = new PageBean();
		pageBean.setPageNum(pageNum);
		pageBean.setPageSize(pageSize);
		pageBean.setRowCount(rowCount);
		pageBean.setPageCount(pageCount);
		pageBean.setLists(stuList);
		
		return pageBean;
	}
	
	public PageBean teaSelectedCourse(int pageNum,int pageSize,int teacherID){
		
		int rowCount = tblSelectedCourseDao.selectCountFunTea(teacherID);  //总行数
		int pageCount = rowCount / pageSize;					//总页数
		if (rowCount % pageSize != 0)
			pageCount ++;
		
		int startNum = (pageNum - 1) * pageSize;		
		List<TblSelectedCourse> stuList = tblSelectedCourseDao.teaSelectedCourse(startNum, pageSize, teacherID);
		
		PageBean pageBean  = new PageBean();
		pageBean.setPageNum(pageNum);
		pageBean.setPageSize(pageSize);
		pageBean.setRowCount(rowCount);
		pageBean.setPageCount(pageCount);
		pageBean.setLists(stuList);
		
		return pageBean;
	}
	
	public PageBean SelectedCourseStu(int pageNum,int pageSize,int courseID){
		
		int rowCount = tblSelectedCourseDao.selectCourseStuCountFun(courseID);  //总行数
		int pageCount = rowCount / pageSize;					//总页数
		if (rowCount % pageSize != 0)
			pageCount ++;
		
		int startNum = (pageNum - 1) * pageSize;		
		List<TblSelectedCourse> stuList = tblSelectedCourseDao.selectedCourseStu(startNum, pageSize, courseID);
		
		PageBean pageBean  = new PageBean();
		pageBean.setPageNum(pageNum);
		pageBean.setPageSize(pageSize);
		pageBean.setRowCount(rowCount);
		pageBean.setPageCount(pageCount);
		pageBean.setLists(stuList);
		
		return pageBean;
	}
	
}
