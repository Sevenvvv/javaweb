package com.cn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cn.dao.TblStudentDao;
import com.cn.dao.TblTeacherDao;
import com.cn.entity.TblStudent;

public class TblStudentDaoImpl implements TblStudentDao{
	
	
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblStudentDao#insertStu(com.cn.entity.TblStudent)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblStudentDao#insertStu(com.cn.entity.TblStudent)
	 */
	public boolean insertStu(TblStudent tblstudent){
		Connection cn = BaseDao.getConnection();
		String sql = "insert into tbl_student(studentID,studenName,sex,birthYear,grade,classID,sPassword) values(?,?,?,?,?,?,?)";
		PreparedStatement pst = null;
			
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, tblstudent.getStudentID());
			pst.setString(2, tblstudent.getStudentName());
			pst.setString(3, tblstudent.getSex());
			pst.setDate(4,	tblstudent.getBirthYear());
			pst.setDate(5, tblstudent.getGrade());
			pst.setInt(6, tblstudent.getClassID());
			pst.setString(7, tblstudent.getsPassword());

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
	 * @see com.cn.dao.impl.TblStudentDao#selectAll()
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblStudentDao#selectAll()
	 */
	public List<TblStudent> selectAll() {
		Connection cn = BaseDao.getConnection();
		String sql = "select * from tbl_student";
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<TblStudent> stulist = new ArrayList<TblStudent>();
		
		try {
			pst = cn.prepareStatement(sql);
			
			rs = pst.executeQuery();
			while (rs.next()){
				TblStudent tblstudent = new TblStudent();
				tblstudent.setID(rs.getInt("ID"));
				tblstudent.setStudentID(rs.getInt("StudentID"));
				tblstudent.setStudentName(rs.getString("studenName"));
				tblstudent.setSex(rs.getString("sex"));
				tblstudent.setBirthYear(rs.getDate("birthYear"));
				tblstudent.setGrade(rs.getDate("Grade"));
				tblstudent.setClassID(rs.getInt("ClassID"));
				tblstudent.setsPassword(rs.getString("sPassword"));
				
				tblstudent.setCollegeName(rs.getString("collegeName"));
				tblstudent.setMajorName(rs.getString("majorName"));
				tblstudent.setClassName(rs.getString("className"));
				tblstudent.setTeacherName(rs.getString("teacherName"));
				
				stulist.add(tblstudent);
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
	 * @see com.cn.dao.impl.TblStudentDao#selectByNameFun(java.lang.String)
	 */
	public TblStudent selectByNameFun(String name) {
		Connection cn = BaseDao.getConnection();
		String sql = "select * from tbl_student where studentID=?";
		PreparedStatement pst = null;
		ResultSet rs = null;
		TblStudent tblstudent = null;
			
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, name);
			
			rs = pst.executeQuery();
			if (rs.next()){
				tblstudent = new TblStudent();
				tblstudent.setID(rs.getInt("ID"));
				tblstudent.setStudentID(rs.getInt("StudentID"));
				tblstudent.setStudentName(rs.getString("studenName"));
				tblstudent.setSex(rs.getString("sex"));
				tblstudent.setBirthYear(rs.getDate("birthYear"));
				tblstudent.setGrade(rs.getDate("Grade"));
				tblstudent.setClassID(rs.getInt("ClassID"));
				tblstudent.setsPassword(rs.getString("sPassword"));
			}
		
		} catch (SQLException e) {
			System.out.println("≤È—Ø ß∞‹!!!");
			e.printStackTrace();
		}finally{
			BaseDao.closeAll(cn, pst, rs);
		}
	
		return tblstudent;
	}

	public  List <TblStudent> selectByPageFun(int startNum,int pageSize) {
		Connection cn = BaseDao.getConnection();
		String sql = "select tbl_student.*,tbl_college.collegeName,tbl_major.majorName,tbl_class.className,tbl_teacher.teacherName from tbl_student,tbl_class,tbl_major,tbl_college,tbl_teacher where tbl_student.classID=tbl_class.classID and tbl_class.majorID=tbl_major.majorID and tbl_major.collegeID=tbl_college.collegeID and tbl_teacher.ID=tbl_class.teacherID order by studentID asc limit ?,?";
		PreparedStatement pst = null;
		ResultSet rs = null;
		List <TblStudent> stulist = new ArrayList();
			
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, startNum);
			pst.setInt(2, pageSize);
			
			rs = pst.executeQuery();
			while (rs.next()){
				TblStudent tblstudent = new TblStudent();
				tblstudent.setID(rs.getInt("ID"));
				tblstudent.setStudentID(rs.getInt("StudentID"));
				tblstudent.setStudentName(rs.getString("studenName"));
				tblstudent.setSex(rs.getString("sex"));
				tblstudent.setBirthYear(rs.getDate("birthYear"));
				tblstudent.setGrade(rs.getDate("Grade"));
				tblstudent.setClassID(rs.getInt("ClassID"));
				tblstudent.setsPassword(rs.getString("sPassword"));
				
				tblstudent.setCollegeName(rs.getString("collegeName"));
				tblstudent.setMajorName(rs.getString("majorName"));
				tblstudent.setClassName(rs.getString("className"));
				tblstudent.setTeacherName(rs.getString("teacherName"));
				
				stulist.add(tblstudent);
			}
		} catch (SQLException e) {
			System.out.println("≤È—Ø ß∞‹!!!");
			e.printStackTrace();
		}finally{
			BaseDao.closeAll(cn, pst, rs);
		}
		return stulist;
	}

	public  Integer selectCountFun() {
		Connection cn = BaseDao.getConnection();
		String sql = "select count(*) from tbl_student";
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
