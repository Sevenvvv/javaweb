package com.cn.entity;

import java.sql.Date;

public class TblStudent {
	
	private Integer ID;
	private Integer studentID;
	private String studentName;
	private String sex;
	private Date birthYear;
	private Date grade;
	private Integer classID;
	private String sPassword;
	
	private String oldPassword;
	private Integer collegeID;
	private String collegeName;
	private Integer majorID;
	private String majorName;
	private String className;
	private String teacherName;
	
	public TblStudent(){
		
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public Integer getStudentID() {
		return studentID;
	}

	public void setStudentID(Integer studentID) {
		this.studentID = studentID;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(Date birthYear) {
		this.birthYear = birthYear;
	}

	public Date getGrade() {
		return grade;
	}

	public void setGrade(Date grade) {
		this.grade = grade;
	}

	public Integer getClassID() {
		return classID;
	}

	public void setClassID(Integer classID) {
		this.classID = classID;
	}

	public String getsPassword() {
		return sPassword;
	}

	public void setsPassword(String sPassword) {
		this.sPassword = sPassword;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public Integer getCollegeID() {
		return collegeID;
	}

	public void setCollegeID(Integer collegeID) {
		this.collegeID = collegeID;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public Integer getMajorID() {
		return majorID;
	}

	public void setMajorID(Integer majorID) {
		this.majorID = majorID;
	}

	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
}
