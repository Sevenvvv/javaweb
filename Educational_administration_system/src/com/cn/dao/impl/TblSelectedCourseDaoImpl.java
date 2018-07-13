package com.cn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cn.dao.TblSelectedCourseDao;
import com.cn.entity.TblCourse;
import com.cn.entity.TblSelectedCourse;

public class TblSelectedCourseDaoImpl implements TblSelectedCourseDao{
	

	public boolean ChoiceCourse(TblSelectedCourse tblSelectedCourse){
		Connection cn = BaseDao.getConnection();
		String sql = "insert into tbl_selectedcourse(courseID,studentID) values(?,?)";
		PreparedStatement pst = null;
			
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, tblSelectedCourse.getCourseID());
			pst.setInt(2, tblSelectedCourse.getStudentID());

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

	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblSelectedCourseDao#SelectedCourse(int)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblSelectedCourseDao#SelectedCourse(int, int, int)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblSelectedCourseDao#stuSelectedCourse(int, int, int)
	 */
	public List<TblSelectedCourse> stuSelectedCourse(int startNum,int pageSize,int studentID){
		Connection cn = BaseDao.getConnection();
		String sql = "select * from tbl_selectedcourse,tbl_course,tbl_college where tbl_selectedcourse.courseID=tbl_course.courseID and tbl_course.collegeID=tbl_college.collegeID and tbl_selectedcourse.mark is null and studentID=? order by tbl_course.courseID asc limit ?,?;";
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<TblSelectedCourse> Selectedlist = new ArrayList<TblSelectedCourse>();
		
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, studentID);
			pst.setInt(2, startNum);
			pst.setInt(3, pageSize);
			
			rs = pst.executeQuery();
			while (rs.next()){
				TblSelectedCourse tblSelectedCourse = new TblSelectedCourse();
				tblSelectedCourse.setCourseID(rs.getInt("courseID"));
				tblSelectedCourse.setCourseName(rs.getString("courseName"));
				tblSelectedCourse.setTeacherID(rs.getInt("teacherID"));
				tblSelectedCourse.setCourseTime(rs.getString("courseTime"));
				tblSelectedCourse.setCourseBegin(rs.getDate("courseBegin"));
				tblSelectedCourse.setCourseRoom(rs.getString("courseRoom"));
				tblSelectedCourse.setCourseWeek(rs.getInt("courseWeek"));
				tblSelectedCourse.setCourseType(rs.getString("courseType"));
				tblSelectedCourse.setCollegeID(rs.getInt("collegeID"));
				tblSelectedCourse.setPoint(rs.getInt("point"));
				
				tblSelectedCourse.setCollegeName(rs.getString("collegeName"));
				
				Selectedlist.add(tblSelectedCourse);
			}
			
		} catch (SQLException e) {
			System.out.println("≤È—Ø ß∞‹!!!");
			e.printStackTrace();
		}finally{
			BaseDao.closeAll(cn, pst, rs);
		}
	
		return Selectedlist;
	} 
	
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblSelectedCourseDao#teaSelectedCourse(int, int, int)
	 */
	public List<TblSelectedCourse> teaSelectedCourse(int startNum,int pageSize,int teacherID){
		Connection cn = BaseDao.getConnection();
		String sql = "select Distinct tbl_selectedcourse.courseID,tbl_course.*,tbl_teacher.*,tbl_college.* from tbl_selectedcourse,tbl_course,tbl_teacher,tbl_college where tbl_selectedcourse.courseID=tbl_course.courseID and tbl_course.teacherID=tbl_teacher.ID and tbl_course.collegeID=tbl_college.collegeID and tbl_teacher.teacherID=? order by tbl_course.courseID asc limit ?,?;";
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<TblSelectedCourse> Selectedlist = new ArrayList<TblSelectedCourse>();
		
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, teacherID);
			pst.setInt(2, startNum);
			pst.setInt(3, pageSize);
			
			rs = pst.executeQuery();
			while (rs.next()){
				TblSelectedCourse tblSelectedCourse = new TblSelectedCourse();
				tblSelectedCourse.setCourseID(rs.getInt("courseID"));
				tblSelectedCourse.setCourseName(rs.getString("courseName"));
				tblSelectedCourse.setTeacherID(rs.getInt("teacherID"));
				tblSelectedCourse.setCourseTime(rs.getString("courseTime"));
				tblSelectedCourse.setCourseBegin(rs.getDate("courseBegin"));
				tblSelectedCourse.setCourseRoom(rs.getString("courseRoom"));
				tblSelectedCourse.setCourseWeek(rs.getInt("courseWeek"));
				tblSelectedCourse.setCourseType(rs.getString("courseType"));
				tblSelectedCourse.setCollegeID(rs.getInt("collegeID"));
				tblSelectedCourse.setPoint(rs.getInt("point"));
				
				tblSelectedCourse.setCollegeName(rs.getString("collegeName"));
				
				Selectedlist.add(tblSelectedCourse);
			}
			
		} catch (SQLException e) {
			System.out.println("≤È—Ø ß∞‹!!!");
			e.printStackTrace();
		}finally{
			BaseDao.closeAll(cn, pst, rs);
		}
	
		return Selectedlist;
	} 
	
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblSelectedCourseDao#FinishCourse(int, int, int)
	 */
	public List<TblSelectedCourse> FinishCourse(int startNum,int pageSize,int studentID){
		Connection cn = BaseDao.getConnection();
		String sql = "select * from tbl_selectedcourse,tbl_course,tbl_college where tbl_selectedcourse.courseID=tbl_course.courseID and tbl_course.collegeID=tbl_college.collegeID and tbl_selectedcourse.mark is not null and studentID=? order by tbl_course.courseID asc limit ?,?";
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<TblSelectedCourse> Selectedlist = new ArrayList<TblSelectedCourse>();
		
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, studentID);
			pst.setInt(2, startNum);
			pst.setInt(3, pageSize);
			
			rs = pst.executeQuery();
			while (rs.next()){
				TblSelectedCourse tblSelectedCourse = new TblSelectedCourse();
				tblSelectedCourse.setCourseID(rs.getInt("courseID"));
				tblSelectedCourse.setCourseName(rs.getString("courseName"));
				tblSelectedCourse.setTeacherID(rs.getInt("teacherID"));
				tblSelectedCourse.setCourseTime(rs.getString("courseTime"));
				tblSelectedCourse.setCourseBegin(rs.getDate("courseBegin"));
				tblSelectedCourse.setCourseRoom(rs.getString("courseRoom"));
				tblSelectedCourse.setCourseWeek(rs.getInt("courseWeek"));
				tblSelectedCourse.setCourseType(rs.getString("courseType"));
				tblSelectedCourse.setCollegeID(rs.getInt("collegeID"));
				tblSelectedCourse.setPoint(rs.getInt("point"));
				
				tblSelectedCourse.setCollegeName(rs.getString("collegeName"));
				tblSelectedCourse.setMark(rs.getInt("mark"));
				
				Selectedlist.add(tblSelectedCourse);
			}
			
		} catch (SQLException e) {
			System.out.println("≤È—Ø ß∞‹!!!");
			e.printStackTrace();
		}finally{
			BaseDao.closeAll(cn, pst, rs);
		}
	
		return Selectedlist;
	} 
	
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblSelectedCourseDao#QuitCourse(int)
	 */
	public boolean QuitCourse(int courseID,int studentID){
		Connection cn = BaseDao.getConnection();
		String sql = "delete from tbl_selectedcourse where courseID=? and studentID=?";
		PreparedStatement pst = null;
		
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, courseID);
			pst.setInt(2, studentID);
			
			int rs = pst.executeUpdate();
			if(rs>=1){
				return true;
			}
		} catch (SQLException e) {
			System.out.println("ÕÀøŒ ß∞‹!!!");
			e.printStackTrace();
		}finally{
			BaseDao.closeAll(cn, pst, null);
		}
	
		return false;
	}
	
	
	
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblSelectedCourseDao#selectCountFun()
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblSelectedCourseDao#selectCountFunStu(int)
	 */
	public Integer selectCountFunStu(int studentID) {
		Connection cn = BaseDao.getConnection();
		String sql = "select count(*) from tbl_selectedcourse where studentID=? ";
		PreparedStatement pst = null;
		ResultSet rs = null;
					
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1,studentID);
						
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
	
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblSelectedCourseDao#selectCountFunTea(int)
	 */
	public Integer selectCountFunTea(int teacherID) {
		Connection cn = BaseDao.getConnection();
		String sql = "select count(*) from tbl_selectedcourse,tbl_course,tbl_teacher where tbl_selectedcourse.courseID=tbl_course.courseID and tbl_course.teacherID=tbl_teacher.ID and tbl_teacher.teacherID=?";
		PreparedStatement pst = null;
		ResultSet rs = null;
					
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1,teacherID);
						
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
	
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblSelectedCourseDao#finishCountFun(int)
	 */
	public Integer finishCountFun(int studentID) {
		Connection cn = BaseDao.getConnection();
		String sql = "select count(*) from tbl_selectedcourse where mark is not null and studentID=? ";
		PreparedStatement pst = null;
		ResultSet rs = null;
					
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1,studentID);
						
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
	
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblSelectedCourseDao#selectCourseStuCountFun(int, int)
	 */
	public Integer selectCourseStuCountFun(int courseID) {
		Connection cn = BaseDao.getConnection();
		String sql = "select count(*) from tbl_selectedcourse where courseID=?";
		PreparedStatement pst = null;
		ResultSet rs = null;
					
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1,courseID);
						
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
	
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblSelectedCourseDao#selectedCourseStu(int, int, int)
	 */
	public List<TblSelectedCourse> selectedCourseStu(int startNum,int pageSize,int courseID){
		Connection cn = BaseDao.getConnection();
		String sql = "select tbl_student.*,tbl_selectedcourse.*,tbl_college.*,tbl_major.*,tbl_class.* from tbl_selectedcourse,tbl_course,tbl_student,tbl_college,tbl_major,tbl_class where tbl_selectedcourse.courseID=tbl_course.courseID and tbl_selectedcourse.studentID=tbl_student.studentID and tbl_course.collegeID=tbl_college.collegeID and tbl_college.collegeID=tbl_major.collegeID and tbl_major.majorID=tbl_class.majorID and tbl_selectedcourse.courseID=? order by tbl_selectedcourse.studentID asc limit ?,?";
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<TblSelectedCourse> stulist = new ArrayList<TblSelectedCourse>();
		
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, courseID);
			pst.setInt(2, startNum);
			pst.setInt(3, pageSize);
			
			rs = pst.executeQuery();
			while (rs.next()){
				TblSelectedCourse tblSelectedCourse = new TblSelectedCourse();
				tblSelectedCourse.setStudentID(rs.getInt("studentID"));
				tblSelectedCourse.setStudentName(rs.getString("studentName"));
				tblSelectedCourse.setSex(rs.getString("sex"));
				tblSelectedCourse.setBirthYear(rs.getDate("birthYear"));
				tblSelectedCourse.setGrade(rs.getDate("grade"));
				tblSelectedCourse.setClassID(rs.getInt("classID"));
				tblSelectedCourse.setCourseID(rs.getInt("courseID"));
				tblSelectedCourse.setMark(rs.getInt("mark"));
				
				tblSelectedCourse.setCollegeName(rs.getString("collegeName"));
				tblSelectedCourse.setMajorName(rs.getString("majorName"));
				tblSelectedCourse.setClassName(rs.getString("className"));
				
				stulist.add(tblSelectedCourse);
			}
			
		} catch (SQLException e) {
			System.out.println("≤È—Ø ß∞‹!!!");
			e.printStackTrace();
		}finally{
			BaseDao.closeAll(cn, pst, rs);
		}
	
		return stulist;
	}
	
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblSelectedCourseDao#givenPoint(int, int)
	 */
	public boolean givenPoint(int mark,int studentID,int courseID) {
		Connection cn = BaseDao.getConnection();
		String sql = "update tbl_selectedcourse set mark=? where studentID=? and courseID=?";
		PreparedStatement pst = null;
					
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1,mark);
			pst.setInt(2,studentID);
			pst.setInt(3,courseID);
						
			int rs = pst.executeUpdate();
			if(rs>=1){
				return true;
			}
		} catch (SQLException e) {
			System.out.println("≤È—Ø ß∞‹!!!");
			e.printStackTrace();
		}finally{
			BaseDao.closeAll(cn, pst, null);
		}
		return false;
	}
	
}
