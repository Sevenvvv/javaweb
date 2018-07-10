package com.cn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cn.dao.TblAdminDao;
import com.cn.entity.TblAdmin;
import com.cn.entity.TblTeacher;

public class TblAdminDaoImpl implements TblAdminDao {
	
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
			System.out.println("≤È—Ø ß∞‹!!!");
			e.printStackTrace();
		}finally{
			BaseDao.closeAll(cn, pst, rs);
		}
	
		return adminlist;
	}
	
	/* (non-Javadoc)
	 * @see com.cn.dao.impl.TblAdminDao#selectByNameFun(java.lang.String)
	 */
	public TblAdmin selectByNameFun(String name) {
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
			}
		
		} catch (SQLException e) {
			System.out.println("≤È—Ø ß∞‹!!!");
			e.printStackTrace();
		}finally{
			BaseDao.closeAll(cn, pst, rs);
		}
	
		return tbladmin;
	}

}
