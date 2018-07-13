package com.cn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cn.dao.TblTeacherDao;
import com.cn.entity.TblAdmin;
import com.cn.entity.TblStudent;
import com.cn.entity.TblTeacher;

public class TblTeacherDaoImpl implements TblTeacherDao{

	public boolean insertTea(TblTeacher tblteacher){
		Connection cn = BaseDao.getConnection();
		String sql = "insert into tbl_teacher(teacherID,teacherName,sex,birthYear,degree,ptitle,grade,collegeID,tPassword) values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst = null;
			
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, tblteacher.getTeacherID());
			pst.setString(2, tblteacher.getTeacherName());
			pst.setString(3, tblteacher.getSex());
			pst.setDate(4,	tblteacher.getBirthYear());
			pst.setString(5, tblteacher.getDegree());
			pst.setString(6, tblteacher.getPtitle());
			pst.setDate(7, tblteacher.getGrade());
			pst.setInt(8, tblteacher.getCollegeID());
			pst.setString(9, tblteacher.gettPassword());

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

	public List<TblTeacher> selectAll() {
		Connection cn = BaseDao.getConnection();
		String sql = "select * from tbl_teacher";
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<TblTeacher> tealist = new ArrayList<TblTeacher>();
		
		try {
			pst = cn.prepareStatement(sql);
			
			rs = pst.executeQuery();
			while (rs.next()){
				TblTeacher tblteacher = new TblTeacher();
				tblteacher.setID(rs.getInt("ID"));
				tblteacher.setTeacherID(rs.getInt("TeacherID"));
				tblteacher.setTeacherName(rs.getString("TeacherName"));
				tblteacher.setSex(rs.getString("sex"));
				tblteacher.setBirthYear(rs.getDate("birthYear"));
				tblteacher.setDegree(rs.getString("degree"));
				tblteacher.setPtitle(rs.getString("ptitle"));
				tblteacher.setGrade(rs.getDate("grade"));
				tblteacher.settPassword(rs.getString("tPassword"));
				
				tblteacher.setCollegeName(rs.getString("CollegeName"));
				
				tealist.add(tblteacher);
			}
			
		} catch (SQLException e) {
			System.out.println("≤È—Ø ß∞‹!!!");
			e.printStackTrace();
		}finally{
			BaseDao.closeAll(cn, pst, rs);
		}
	
		return tealist;
	}

	public TblTeacher selectByIDandPsw(TblTeacher tblteacher) {
		Connection cn = BaseDao.getConnection();
		String sql = "select * from tbl_teacher where teacherID=? and tpassword=?";
		PreparedStatement pst = null;
		ResultSet rs = null;
			
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, tblteacher.getTeacherID());
			pst.setString(2, tblteacher.getOldPassword());
			
			rs = pst.executeQuery();
			if (rs.next()){
				tblteacher = new TblTeacher();
				tblteacher.setID(rs.getInt("ID"));
				tblteacher.setTeacherID(rs.getInt("TeacherID"));
				tblteacher.setTeacherName(rs.getString("TeacherName"));
				tblteacher.setSex(rs.getString("sex"));
				tblteacher.setBirthYear(rs.getDate("birthYear"));
				tblteacher.setDegree(rs.getString("degree"));
				tblteacher.setPtitle(rs.getString("ptitle"));
				tblteacher.setGrade(rs.getDate("grade"));
				tblteacher.setOldPassword(rs.getString("tPassword"));
			}
		
		} catch (SQLException e) {
			System.out.println("≤È—Ø ß∞‹!!!");
			e.printStackTrace();
		}finally{
			BaseDao.closeAll(cn, pst, rs);
		}
	
		return tblteacher;
	}

	public TblTeacher selectByIDFun(int teacherID) {
		Connection cn = BaseDao.getConnection();
		String sql = "select * from tbl_teacher where teacherID=?";
		PreparedStatement pst = null;
		ResultSet rs = null;
		TblTeacher tblteacher= null;
			
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, teacherID);
			
			rs = pst.executeQuery();
			if (rs.next()){
				tblteacher = new TblTeacher();
				tblteacher.setID(rs.getInt("ID"));
				tblteacher.setTeacherID(rs.getInt("TeacherID"));
				tblteacher.setTeacherName(rs.getString("TeacherName"));
				tblteacher.setSex(rs.getString("sex"));
				tblteacher.setBirthYear(rs.getDate("birthYear"));
				tblteacher.setDegree(rs.getString("degree"));
				tblteacher.setPtitle(rs.getString("ptitle"));
				tblteacher.setGrade(rs.getDate("grade"));
				tblteacher.settPassword(rs.getString("tPassword"));
			}
		
		} catch (SQLException e) {
			System.out.println("≤È—Ø ß∞‹!!!");
			e.printStackTrace();
		}finally{
			BaseDao.closeAll(cn, pst, rs);
		}
	
		return tblteacher;
	}
	
	public TblTeacher selectByUsernameFun(String name) {
		Connection cn = BaseDao.getConnection();
		String sql = "select * from tbl_teacher where teacherID=?";
		PreparedStatement pst = null;
		ResultSet rs = null;
		TblTeacher tblteacher = null;
			
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, name);
			
			rs = pst.executeQuery();
			if (rs.next()){
				tblteacher = new TblTeacher();
				tblteacher.setID(rs.getInt("ID"));
				tblteacher.setTeacherID(rs.getInt("TeacherID"));
				tblteacher.setTeacherName(rs.getString("TeacherName"));
				tblteacher.setSex(rs.getString("sex"));
				tblteacher.setBirthYear(rs.getDate("birthYear"));
				tblteacher.setDegree(rs.getString("degree"));
				tblteacher.setPtitle(rs.getString("ptitle"));
				tblteacher.setGrade(rs.getDate("grade"));
				tblteacher.settPassword(rs.getString("tPassword"));
				tblteacher.setOldPassword(rs.getString("tPassword"));
			}
		
		} catch (SQLException e) {
			System.out.println("≤È—Ø ß∞‹!!!");
			e.printStackTrace();
		}finally{
			BaseDao.closeAll(cn, pst, rs);
		}
	
		return tblteacher;
	}
	
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#selectByPageFun(int, int)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#selectByPageFun(int, int)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#selectByPageFun(int, int)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#selectByPageFun(int, int)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#selectByPageFun(int, int)
	 */
	public  List <TblTeacher> selectByPageFun(int startNum,int pageSize) {
		Connection cn = BaseDao.getConnection();
		String sql = "select tbl_teacher.*,tbl_college.collegeName from tbl_teacher,tbl_college where tbl_teacher.collegeID=tbl_college.collegeID order by teacherID asc limit ?,?";
		PreparedStatement pst = null;
		ResultSet rs = null;
		List <TblTeacher> tealist = new ArrayList();
			
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, startNum);
			pst.setInt(2, pageSize);
			
			rs = pst.executeQuery();
			while (rs.next()){
				TblTeacher tblteacher = new TblTeacher();
				tblteacher.setID(rs.getInt("ID"));
				tblteacher.setTeacherID(rs.getInt("TeacherID"));
				tblteacher.setTeacherName(rs.getString("TeacherName"));
				tblteacher.setSex(rs.getString("sex"));
				tblteacher.setBirthYear(rs.getDate("birthYear"));
				tblteacher.setDegree(rs.getString("degree"));
				tblteacher.setPtitle(rs.getString("ptitle"));
				tblteacher.setGrade(rs.getDate("grade"));
				tblteacher.settPassword(rs.getString("tPassword"));
				
				tblteacher.setCollegeName(rs.getString("CollegeName"));
				
				tealist.add(tblteacher);
			}
		} catch (SQLException e) {
			System.out.println("≤È—Ø ß∞‹!!!");
			e.printStackTrace();
		}finally{
			BaseDao.closeAll(cn, pst, rs);
		}
		return tealist;
	}

	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#selectCountFun()
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#selectCountFun()
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#selectCountFun()
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#selectCountFun()
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#selectCountFun()
	 */
	public  Integer selectCountFun() {
		Connection cn = BaseDao.getConnection();
		String sql = "select count(*) from tbl_teacher";
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
	 * @see com.cn.dao.impl.TblTeacherDao#deleteById(int)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#deleteById(int)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#deleteById(int)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#deleteById(int)
	 */
	public boolean deleteById(int teacherID) {
		Connection cn = BaseDao.getConnection();
		String sql = "delete from tbl_teacher where teacherID=?";
		PreparedStatement pst = null;
		TblAdmin tbladmin = null;
			
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, teacherID);
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
	 * @see com.cn.dao.impl.TblTeacherDao#updateM(com.cn.entity.TblTeacher)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#updateM(com.cn.entity.TblTeacher)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#updateM(com.cn.entity.TblTeacher)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#updateM(com.cn.entity.TblTeacher)
	 */
	public boolean updateM(TblTeacher tblteacher){
		Connection conn = BaseDao.getConnection();
		PreparedStatement  pstmt = null;
		String sql = "update tbl_teacher set teacherName=?,sex=?,birthYear=?,degree=?,ptitle=?,collegeId=? where teacherID=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tblteacher.getTeacherName());
			pstmt.setString(2, tblteacher.getSex());
			pstmt.setDate(3, tblteacher.getBirthYear());
			pstmt.setString(4, tblteacher.getDegree());
			pstmt.setString(5, tblteacher.getPtitle());
			pstmt.setInt(6, tblteacher.getCollegeID());
			pstmt.setInt(7, tblteacher.getTeacherID());
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
	
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#newPwd(com.cn.entity.TblTeacher)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#newPwd(com.cn.entity.TblTeacher)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#newPwd(com.cn.entity.TblTeacher)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#newPwd(com.cn.entity.TblTeacher)
	 */
	public boolean newPwd(TblTeacher tblteacher){
		Connection conn = BaseDao.getConnection();
		PreparedStatement  pstmt = null;
		String sql = "update tbl_teacher set tpassword=? where teacherID=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tblteacher.gettPassword());
			pstmt.setInt(2, tblteacher.getTeacherID());
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
