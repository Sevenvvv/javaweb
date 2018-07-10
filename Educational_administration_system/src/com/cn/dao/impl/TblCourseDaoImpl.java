package com.cn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cn.dao.TblCourseDao;
import com.cn.entity.TblCourse;

public class TblCourseDaoImpl implements TblCourseDao{
	

	public boolean insertCou(TblCourse tblcourse){
		Connection cn = BaseDao.getConnection();
		String sql = "insert into tbl_course(CourseName,TeacherID,CourseTime,CourseBegin,ClassRoom,CourseWeek,CourseType,CollegeID,Point) values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst = null;
			
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, tblcourse.getCourseName());
			pst.setInt(2, tblcourse.getTeacherID());
			pst.setString(3,tblcourse.getCourseTime());
			pst.setDate(4, tblcourse.getCourseBegin());
			pst.setString(5, tblcourse.getCourseRoom());
			pst.setInt(6, tblcourse.getCourseWeek());
			pst.setString(7, tblcourse.getCourseType());
			pst.setInt(8, tblcourse.getCollegeID());
			pst.setInt(9, tblcourse.getPoint());

			int ret = pst.executeUpdate();
			if (ret >=1)
				return true;
		} catch (SQLException e) {
			System.out.println("‘ˆº” ß∞‹!!!");
			e.printStackTrace();
		}finally{
			BaseDao.closeAll(cn, pst, null);
		}
	
		return false;
	}


	public List<TblCourse> selectAll() {
		Connection cn = BaseDao.getConnection();
		String sql = "select * from tbl_course";
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<TblCourse> coulist = new ArrayList<TblCourse>();
		
		try {
			pst = cn.prepareStatement(sql);
			
			rs = pst.executeQuery();
			while (rs.next()){
				TblCourse tblcourse = new TblCourse();
				tblcourse.setCourseID(rs.getInt("courseID"));
				tblcourse.setCourseName(rs.getString("courseName"));
				tblcourse.setTeacherID(rs.getInt("teacherID"));
				tblcourse.setCourseTime(rs.getString("courseTime"));
				tblcourse.setCourseBegin(rs.getDate("courseBegin"));
				tblcourse.setCourseRoom(rs.getString("courseRoom"));
				tblcourse.setCourseWeek(rs.getInt("courseWeek"));
				tblcourse.setCourseType(rs.getString("courseType"));
				tblcourse.setCollegeID(rs.getInt("collegeID"));
				tblcourse.setPoint(rs.getInt("point"));
				
				tblcourse.setCollegeName(rs.getString("collegeName"));
				
				coulist.add(tblcourse);
			}
			
		} catch (SQLException e) {
			System.out.println("≤È—Ø ß∞‹!!!");
			e.printStackTrace();
		}finally{
			BaseDao.closeAll(cn, pst, rs);
		}
	
		return coulist;
	}

	public TblCourse selectByNameFun(String name) {
		Connection cn = BaseDao.getConnection();
		String sql = "select * from tbl_course where courseID=?";
		PreparedStatement pst = null;
		ResultSet rs = null;
		TblCourse tblcourse = null;
			
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, name);
			
			rs = pst.executeQuery();
			if (rs.next()){
				tblcourse = new TblCourse();
				tblcourse.setCourseID(rs.getInt("courseID"));
				tblcourse.setCourseName(rs.getString("courseName"));
				tblcourse.setTeacherID(rs.getInt("teacherID"));
				tblcourse.setCourseTime(rs.getString("courseTime"));
				tblcourse.setCourseBegin(rs.getDate("courseBegin"));
				tblcourse.setCourseRoom(rs.getString("courseRoom"));
				tblcourse.setCourseWeek(rs.getInt("courseWeek"));
				tblcourse.setCourseType(rs.getString("courseType"));
				tblcourse.setCollegeID(rs.getInt("collegeID"));
				tblcourse.setPoint(rs.getInt("point"));
			}
		
		} catch (SQLException e) {
			System.out.println("≤È—Ø ß∞‹!!!");
			e.printStackTrace();
		}finally{
			BaseDao.closeAll(cn, pst, rs);
		}
	
		return tblcourse;
	}


	public  List <TblCourse> selectByPageFun(int startNum,int pageSize) {
		Connection cn = BaseDao.getConnection();
		String sql = "select a.*,b.collegeName from tbl_course a,tbl_college b where a.collegeID=b.collegeID order by courseID asc limit ?,?";
		PreparedStatement pst = null;
		ResultSet rs = null;
		List <TblCourse> coulist = new ArrayList();
			
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, startNum);
			pst.setInt(2, pageSize);
			
			rs = pst.executeQuery();
			while (rs.next()){
				TblCourse tblcourse = new TblCourse();
				tblcourse.setCourseID(rs.getInt("courseID"));
				tblcourse.setCourseName(rs.getString("courseName"));
				tblcourse.setTeacherID(rs.getInt("teacherID"));
				tblcourse.setCourseTime(rs.getString("courseTime"));
				tblcourse.setCourseBegin(rs.getDate("courseBegin"));
				tblcourse.setCourseRoom(rs.getString("courseRoom"));
				tblcourse.setCourseWeek(rs.getInt("courseWeek"));
				tblcourse.setCourseType(rs.getString("courseType"));
				tblcourse.setCollegeID(rs.getInt("collegeID"));
				tblcourse.setPoint(rs.getInt("point"));
				
				tblcourse.setCollegeName(rs.getString("collegeName"));
				
				coulist.add(tblcourse);
			}
		} catch (SQLException e) {
			System.out.println("≤È—Ø ß∞‹!!!");
			e.printStackTrace();
		}finally{
			BaseDao.closeAll(cn, pst, rs);
		}
		return coulist;
	}

	public  Integer selectCountFun() {
		Connection cn = BaseDao.getConnection();
		String sql = "select count(*) from tbl_course";
		PreparedStatement pst = null;
		ResultSet rs = null;
					
		try {
			pst = cn.prepareStatement(sql);
						
			rs = pst.executeQuery();
			if  (rs.next()){
				Integer coun = rs.getInt(1);
				return coun;
			}
		} catch (SQLException e) {
			System.out.println("≤È—Ø ß∞‹!!!");
			e.printStackTrace();
		}finally{
			BaseDao.closeAll(cn, pst, rs);
		}
		return 0;
	}
	
}
