package com.sk.springBootHibernate.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Student {

	
	/**
	 * 
	 */
	
	@Id
	@GeneratedValue(strategy =GenerationType.SEQUENCE)
	private long studentId;
	private String studentName;
	private String studentStandard;
	private String studentAddress;
	
	@ManyToOne
	@JoinColumn(name="teacherId")
	
	private Teacher teacher;
		
	
	
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public long getStudentId() {
		return studentId;
	}
	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentStandard() {
		return studentStandard;
	}
	public void setStudentStandard(String studentStandard) {
		this.studentStandard = studentStandard;
	}
	public String getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}
	
	
	
}
