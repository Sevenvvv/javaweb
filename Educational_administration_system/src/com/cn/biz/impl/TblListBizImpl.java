package com.cn.biz.impl;

import java.util.List;

import com.cn.biz.TblListBiz;
import com.cn.dao.TblCourseDao;
import com.cn.dao.TblStudentDao;
import com.cn.dao.TblTeacherDao;
import com.cn.dao.impl.TblAdminDaoImpl;
import com.cn.dao.impl.TblCourseDaoImpl;
import com.cn.dao.impl.TblStudentDaoImpl;
import com.cn.dao.impl.TblTeacherDaoImpl;
import com.cn.entity.TblAdmin;
import com.cn.entity.TblCourse;
import com.cn.entity.TblStudent;
import com.cn.entity.TblTeacher;
import com.cn.util.PageBean;

public class TblListBizImpl implements TblListBiz {
	
	private TblStudentDao tblStudentDao = new TblStudentDaoImpl();	
	private TblTeacherDao tblTeacherDao = new TblTeacherDaoImpl();
	private TblCourseDao tblCourseDao = new TblCourseDaoImpl();

	public PageBean stuCourseViewByPageFun(int pageNum,int pageSize){
		
		int rowCount = tblStudentDao.selectCountFun();  //总行数
		int pageCount = rowCount / pageSize;					//总页数
		if (rowCount % pageSize != 0)
			pageCount ++;
		
		int startNum = (pageNum - 1) * pageSize;		
		List<TblStudent> stuList = tblStudentDao.selectByPageFun(startNum, pageSize);
		
		PageBean pageBean  = new PageBean();
		pageBean.setPageNum(pageNum);
		pageBean.setPageSize(pageSize);
		pageBean.setRowCount(rowCount);
		pageBean.setPageCount(pageCount);
		pageBean.setLists(stuList);
		
		return pageBean;
	}
	
	/* (non-Javadoc)
	 * @see com.cn.biz.impl.TblStuAndTeaBiz#teaCourseViewByPageFun(int, int)
	 */
	/* (non-Javadoc)
	 * @see com.cn.biz.impl.TblListBiz#teaCourseViewByPageFun(int, int)
	 */
	public PageBean teaCourseViewByPageFun(int pageNum,int pageSize){
		
		int rowCount = tblTeacherDao.selectCountFun();  //总行数
		int pageCount = rowCount / pageSize;					//总页数
		if (rowCount % pageSize != 0)
			pageCount ++;
		
		int startNum = (pageNum - 1) * pageSize;		
		List <TblTeacher> teaList = tblTeacherDao.selectByPageFun(startNum, pageSize);
		
		PageBean pageBean  = new PageBean();
		pageBean.setPageNum(pageNum);
		pageBean.setPageSize(pageSize);
		pageBean.setRowCount(rowCount);
		pageBean.setPageCount(pageCount);
		pageBean.setLists(teaList);
		
		return pageBean;
	}

	/* (non-Javadoc)
	 * @see com.cn.biz.impl.TblListBiz#CourseViewByPageFun(int, int)
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
