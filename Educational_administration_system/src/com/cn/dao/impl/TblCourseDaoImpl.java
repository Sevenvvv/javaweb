package com.cn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cn.dao.TblCourseDao;
import com.cn.entity.TblAdmin;
import com.cn.entity.TblCourse;
import com.cn.entity.TblStudent;

public class TblCourseDaoImpl implements TblCourseDao{
	

	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblCourseDao#insertCou(com.cn.entity.TblCourse)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblCourseDao#insertCou(com.cn.entity.TblCourse)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblCourseDao#insertCou(com.cn.entity.TblCourse)
	 */
	public boolean insertCou(TblCourse tblcourse){
		Connection cn = BaseDao.getConnection();
		String sql = "insert into tbl_course(CourseName,TeacherID,CourseTime,CourseBegin,CourseRoom,CourseWeek,CourseType,CollegeID,Point) values(?,?,?,?,?,?,?,?,?)";
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


	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblCourseDao#selectAll()
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblCourseDao#selectAll()
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblCourseDao#selectAll()
	 */
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

	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblCourseDao#selectByIDFun(java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblCourseDao#selectByIDFun(int)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblCourseDao#selectByIDFun(int)
	 */
	public TblCourse selectByIDFun(int courseID) {
		Connection cn = BaseDao.getConnection();
		String sql = "select * from tbl_course where courseID=?";
		PreparedStatement pst = null;
		ResultSet rs = null;
		TblCourse tblcourse = null;
			
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, courseID);
			
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

	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblCourseDao#selectByUsernameFun(java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblCourseDao#selectByUsernameFun(java.lang.String)
	 */
	public TblCourse selectByUsernameFun(String name) {
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

	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblCourseDao#selectByPageFun(int, int)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblCourseDao#selectByPageFun(int, int)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblCourseDao#selectByPageFun(int, int)
	 */
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

	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblCourseDao#selectCountFun()
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblCourseDao#selectCountFun()
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblCourseDao#selectCountFun()
	 */
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
	
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblCourseDao#deleteById(int)
	 */
	public boolean deleteById(int courseID) {
		Connection cn = BaseDao.getConnection();
		String sql = "delete from tbl_course where courseID=?";
		PreparedStatement pst = null;
		TblAdmin tbladmin = null;
			
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, courseID);
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
	
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblCourseDao#updateM(com.cn.entity.TblCourse)
	 */
	public boolean updateM(TblCourse tblcourse){
		Connection conn = BaseDao.getConnection();
		PreparedStatement  pstmt = null;
		String sql = "update tbl_course set courseName=?,teacherID=?,courseTime=?,courseBegin=?,courseRoom=?,courseWeek=?,courseType=?,collegeId=?,point=? where courseID=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tblcourse.getCourseName());
			pstmt.setInt(2, tblcourse.getTeacherID());
			pstmt.setString(3, tblcourse.getCourseTime());
			pstmt.setDate(4, tblcourse.getCourseBegin());
			pstmt.setString(5, tblcourse.getCourseRoom());
			pstmt.setInt(6, tblcourse.getCourseWeek());
			pstmt.setString(7, tblcourse.getCourseType());
			pstmt.setInt(8, tblcourse.getCollegeID());
			pstmt.setInt(9, tblcourse.getPoint());
			pstmt.setInt(10, tblcourse.getCourseID());
			int rs = pstmt.executeUpdate();
			if(rs>=1){
				return true;
			}
		} catch (SQLException e) {
			System.out.println("–ﬁ∏ƒ ß∞‹");
			e.printStackTrace();
		}finally{
			BaseDao.closeAll(conn,pstmt,null);
		}
		return false;
	}
}
