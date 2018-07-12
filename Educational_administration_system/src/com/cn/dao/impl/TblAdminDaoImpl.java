package com.cn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cn.dao.TblAdminDao;
import com.cn.entity.TblAdmin;
import com.cn.entity.TblCourse;
import com.cn.entity.TblTeacher;

public class TblAdminDaoImpl implements TblAdminDao{
	
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblAdminDao#selectAll()
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblAdminDao#selectAll()
	 */
	public List<TblAdmin> selectAll() {
		Connection cn = BaseDao.getConnection();
		String sql = "select * from tbl_admin";
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<TblAdmin> adminlist = new ArrayList<TblAdmin>();
		
		try {
			pst = cn.prepareStatement(sql);
			
			rs = pst.executeQuery();
			while (rs.next()){
				TblAdmin tbladmin = new TblAdmin();
				tbladmin.setAdminID(rs.getInt("ID"));
				tbladmin.setAdminName(rs.getString("AdminName"));
				tbladmin.setaPassword(rs.getString("aPasswords"));
				adminlist.add(tbladmin);
			}
			
		} catch (SQLException e) {
			System.out.println("²éÑ¯Ê§°Ü!!!");
			e.printStackTrace();
		}finally{
			BaseDao.closeAll(cn, pst, rs);
		}
	
		return adminlist;
	}
	
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblAdminDao#selectByIDFun(int)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblAdminDao#selectByIDandPsw(com.cn.entity.TblAdmin)
	 */
	public TblAdmin selectByIDandPsw(TblAdmin tbladmin) {
		Connection cn = BaseDao.getConnection();
		String sql = "select * from tbl_admin where adminID=? and apassword=?";
		PreparedStatement pst = null;
		ResultSet rs = null;
			
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, tbladmin.getAdminID());
			pst.setString(2, tbladmin.getOldPassword());
			
			
			rs = pst.executeQuery();
			if (rs.next()){
				tbladmin = new TblAdmin();
				tbladmin.setAdminID(rs.getInt("AdminID"));
				tbladmin.setAdminName(rs.getString("AdminName"));
				tbladmin.setOldPassword(rs.getString("aPassword"));
			}
		
		} catch (SQLException e) {
			System.out.println("²éÑ¯Ê§°Ü!!!");
			e.printStackTrace();
		}finally{
			BaseDao.closeAll(cn, pst, rs);
		}
	
		return tbladmin;
	}

	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblAdminDao#selectByUsernameFun(java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblAdminDao#selectByUsernameFun(java.lang.String)
	 */
	public TblAdmin selectByUsernameFun(String name) {
		Connection cn = BaseDao.getConnection();
		String sql = "select * from tbl_admin where adminID=?";
		PreparedStatement pst = null;
		ResultSet rs = null;
		TblAdmin tbladmin = null;
			
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, name);
			
			rs = pst.executeQuery();
			if (rs.next()){
				tbladmin = new TblAdmin();
				tbladmin.setAdminID(rs.getInt("AdminID"));
				tbladmin.setAdminName(rs.getString("AdminName"));
				tbladmin.setaPassword(rs.getString("aPassword"));
				tbladmin.setOldPassword(rs.getString("aPassword"));
			}
		
		} catch (SQLException e) {
			System.out.println("²éÑ¯Ê§°Ü!!!");
			e.printStackTrace();
		}finally{
			BaseDao.closeAll(cn, pst, rs);
		}
	
		return tbladmin;
	}
	
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblAdminDao#deleteById(int)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblAdminDao#deleteById(int)
	 */
	public boolean deleteById(int adminID) {
		Connection cn = BaseDao.getConnection();
		String sql = "delete from tbl_admin where adminID=?";
		PreparedStatement pst = null;
		TblAdmin tbladmin = null;
			
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, adminID);
			int rs = pst.executeUpdate();
			if(rs>=1){
				return true;
			}
		} catch (SQLException e) {
			System.out.println("²éÑ¯Ê§°Ü!!!");
			e.printStackTrace();
		}finally{
			BaseDao.closeAll(cn, pst, null);
		}
	
		return false;
	}
	
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblAdminDao#newPwd(com.cn.entity.TblAdmin)
	 */
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblAdminDao#newPwd(com.cn.entity.TblAdmin)
	 */
	public boolean newPwd(TblAdmin tbladmin){
		Connection conn = BaseDao.getConnection();
		PreparedStatement  pstmt = null;
		String sql = "update tbl_admin set apassword=? where adminID=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tbladmin.getaPassword());
			pstmt.setInt(2, tbladmin.getAdminID());
			int rs = pstmt.executeUpdate();
			if(rs>=1){
				return true;
			}
		} catch (SQLException e) {
			System.out.println("ÐÞ¸ÄÊ§°Ü");
			e.printStackTrace();
		}finally{
			BaseDao.closeAll(conn,pstmt,null);
		}
		return false;
	}
	
}
