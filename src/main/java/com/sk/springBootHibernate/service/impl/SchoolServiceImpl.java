package com.sk.springBootHibernate.service.impl;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sk.springBootHibernate.entity.Student;
import com.sk.springBootHibernate.entity.Teacher;
import com.sk.springBootHibernate.repo.StudentListModel;
import com.sk.springBootHibernate.repo.StudentRepo;
import com.sk.springBootHibernate.repo.TeacherRepo;
import com.sk.springBootHibernate.service.SchoolService;

@Service
public class SchoolServiceImpl implements SchoolService{
	
	
	@Autowired
	private StudentRepo studentRepo;
	@Autowired
	private TeacherRepo teacherRepo;
	

	@Override
	public boolean insertStudentDetails(Student student) {
		try{
		studentRepo.save(student);
		return true;
		}catch(Exception e){
			return false;	
		}
	}

	@Override
	public boolean insertTeacherDetails(Teacher teacher) {
		try{
			teacherRepo.save(teacher);
			return true;
			}catch(Exception e){
				return false;	
			}
	}

	@Override
	public List<Student> getStudents() {
		return studentRepo.findAll();
	}

	@Override
	public List<Teacher> getTeacher() {
		return teacherRepo.findAll();
	}

	@Override
	public Student getStudentById(long id) throws Exception {
		return studentRepo.findById(id).orElseThrow(()-> new Exception("New Student Details"));
	}

	@Override
	public Teacher getTeacherById(long id) throws Exception {
		return teacherRepo.findById(id).orElseThrow(()-> new Exception("New Teacher Details"));
	}

	
	@Override
	public boolean deleteStudentById(long id) {
		try{
			studentRepo.deleteById(id);
			return true;
		}catch(Exception e){
			return false;
		}
		
	}

	@Override
	public boolean deleteTeacherById(long id) {
		try{
			teacherRepo.deleteById(id);
			return true;
		}catch(Exception e){
			return false;
		}
		
	}

	@Override
	public boolean updateStudentDetails(Student student) {
		try{
			studentRepo.save(student);
			return true;
			}catch(Exception e){
				return false;	
			}
	}

	@Override
	public boolean updateTeacherDetails(Teacher teacher) {
		
		try{
			teacherRepo.save(teacher);
			return true;
			}catch(Exception e){
				return false;	
			}
	}

	@Override
	public StudentListModel getStudentsByClassTeacher(long id) {
		
		List<Student> studentList =studentRepo.findByteacher(id);
		StudentListModel StudentListModel = new StudentListModel();
		StudentListModel.setStudentList(studentList);
		return StudentListModel;
	}

	@Override
	public Teacher getTeacherDetailsByStudent(long id) {
		
		return teacherRepo.findTeacherByStudent(id);
	}

}

