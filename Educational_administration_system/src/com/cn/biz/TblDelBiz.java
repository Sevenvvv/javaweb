package com.cn.biz;

public interface TblDelBiz {

	boolean delCourse(int courseID);

	boolean delStudent(int studentID);

	boolean delTeacher(int teacherID);

	boolean QuitClass(int courseID,int studentID);

}