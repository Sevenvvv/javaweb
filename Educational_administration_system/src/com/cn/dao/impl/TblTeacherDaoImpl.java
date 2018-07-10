package com.cn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cn.dao.TblTeacherDao;
import com.cn.entity.TblStudent;
import com.cn.entity.TblTeacher;

public class TblTeacherDaoImpl implements TblTeacherDao {
	
	
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#insertTea(com.cn.entity.TblTeacher)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#insertTea(com.cn.entity.TblTeacher)
	 */
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

	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#selectAll()
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#selectAll()
	 */
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
	
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblTeacherDao#selectByNameFun(java.lang.String)
	 */
	public TblTeacher selectByNameFun(String name) {
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
			}
		
		} catch (SQLException e) {
			System.out.println("≤È—Ø ß∞‹!!!");
			e.printStackTrace();
		}finally{
			BaseDao.closeAll(cn, pst, rs);
		}
	
		return tblteacher;
	}
	
	public  List <TblTeacher> selectByPageFun(int startNum,int pageSize) {
		Connection cn = BaseDao.getConnection();
		String sql = "select tbl_teacher.*,tbl_college.collegeName from tbl_teacher,tbl_college where tbl_teacher.collegeID=tbl_college.collegeID order by teacherID asc limit ?,?;";
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
}
