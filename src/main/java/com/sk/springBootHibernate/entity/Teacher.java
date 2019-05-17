package com.sk.springBootHibernate.entity;


import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Teacher {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long teacherId;
	private String teacherName;
	private String teacherSubject;
	
	@OneToMany(mappedBy="teacher")
	@JsonIgnore
	private Set<Student> studentIds;
		
	public Set<Student> getStudentIds() {
		return studentIds;
	}
	public void setStudentIds(Set<Student> studentIds) {
		this.studentIds = studentIds;
	}
	public long getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(long teacherId) {
		this.teacherId = teacherId;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getTeacherSubject() {
		return teacherSubject;
	}
	public void setTeacherSubject(String teacherSubject) {
		this.teacherSubject = teacherSubject;
	}
	
	
}
