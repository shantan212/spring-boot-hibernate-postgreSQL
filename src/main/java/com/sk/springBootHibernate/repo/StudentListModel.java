package com.sk.springBootHibernate.repo;

import java.util.ArrayList;
import java.util.List;

import com.sk.springBootHibernate.entity.Student;

public class StudentListModel {

	
	private List<Student> studentList = new ArrayList<>();

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	
}
