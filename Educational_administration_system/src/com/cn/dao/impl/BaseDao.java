package com.cn.dao.impl;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDao {
	
	private static final String URL ="jdbc:mysql://localhost:3306/javaweb?useUnicode=true&characterEncoding=UTF-8";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";	
	
	public static Connection getConnection(){
		Connection cn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("无法加载驱动程序!!!");
			e.printStackTrace();
		}
				
		try {
			cn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			System.out.println("创建连接失败!!!");
			e.printStackTrace();
		}
		
		return cn;
	}
	

	public static void closeAll(Connection cn,Statement st,ResultSet rs){
		try {
			if (rs != null){
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if (st != null){
				st.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if (cn != null){
				cn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}


















