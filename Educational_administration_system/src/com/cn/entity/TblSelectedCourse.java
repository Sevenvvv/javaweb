package com.cn.entity;

import java.sql.Date;

public class TblSelectedCourse {
	
	private Integer courseID;
	private Integer studentID;
	private Integer mark;
	
	private String courseName;
	private Integer teacherID;
	private String courseTime;
	private Date courseBegin;
	private String courseRoom;
	private Integer courseWeek;
	private String courseType;
	private Integer collegeID;
	private Integer point;
	
	private String studentName;
	private String sex;
	private Date birthYear;
	private Date grade;
	private Integer classID;
	
	private String teacherName;
	private String degree;
	private String ptitle;
	
	private String collegeName;
	private String majorName;
	private String className;
	
	public TblSelectedCourse(){
		
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


	public Integer getCourseID() {
		return courseID;
	}

	public void setCourseID(Integer courseID) {
		this.courseID = courseID;
	}

	public Integer getStudentID() {
		return studentID;
	}

	public void setStudentID(Integer studentID) {
		this.studentID = studentID;
	}

	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
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

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getPtitle() {
		return ptitle;
	}

	public void setPtitle(String ptitle) {
		this.ptitle = ptitle;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
}
