package com.sk.springBootHibernate.service;

import java.util.List;

import com.sk.springBootHibernate.entity.Student;
import com.sk.springBootHibernate.entity.Teacher;
import com.sk.springBootHibernate.repo.StudentListModel;


public interface SchoolService {

	
	public boolean insertStudentDetails(Student student);
	public boolean insertTeacherDetails(Teacher teacher);
	
	public List<Student> getStudents ();
	public List<Teacher> getTeacher ();
	
	public Student getStudentById(long id) throws Exception;
	public Teacher getTeacherById(long id) throws Exception;
	
	public StudentListModel getStudentsByClassTeacher(long id);
	public Teacher getTeacherDetailsByStudent(long id);
	
	public boolean deleteStudentById(long id);
	public boolean deleteTeacherById(long id);
	
	public boolean updateStudentDetails(Student student);
	public boolean updateTeacherDetails(Teacher teacher);
}
