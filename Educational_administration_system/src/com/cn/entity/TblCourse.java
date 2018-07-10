package com.cn.entity;

import java.sql.Date;

public class TblCourse {
	
	private Integer courseID;
	private String courseName;
	private Integer teacherID;
	private String courseTime;
	private Date courseBegin;
	private String courseRoom;
	private Integer courseWeek;
	private String courseType;
	private Integer collegeID;
	private Integer point;
	
	private String collegeName;
	
	public TblCourse(){
		
	}

	public Integer getCourseID() {
		return courseID;
	}

	public void setCourseID(Integer courseID) {
		this.courseID = courseID;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Integer getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(Integer teacherID) {
		this.teacherID = teacherID;
	}

	public String getCourseTime() {
		return courseTime;
	}

	public void setCourseTime(String courseTime) {
		this.courseTime = courseTime;
	}

	public Date getCourseBegin() {
		return courseBegin;
	}

	public void setCourseBegin(Date courseBegin) {
		this.courseBegin = courseBegin;
	}

	public String getCourseRoom() {
		return courseRoom;
	}

	public void setCourseRoom(String courseRoom) {
		this.courseRoom = courseRoom;
	}

	public Integer getCourseWeek() {
		return courseWeek;
	}

	public void setCourseWeek(Integer courseWeek) {
		this.courseWeek = courseWeek;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public Integer getCollegeID() {
		return collegeID;
	}

	public void setCollegeID(Integer collegeID) {
		this.collegeID = collegeID;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

}
