package com.cn.entity;


public class TblAdmin {
	
	private Integer adminID;
	private String adminName;
	private String aPassword;
	
	public TblAdmin(){
		
	}
	
	public Integer getAdminID() {
		return adminID;
	}
	public void setAdminID(Integer adminID) {
		this.adminID = adminID;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getaPassword() {
		return aPassword;
	}
	public void setaPassword(String aPassword) {
		this.aPassword = aPassword;
	}

}
