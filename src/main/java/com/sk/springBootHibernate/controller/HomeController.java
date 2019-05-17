package com.sk.springBootHibernate.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sk.springBootHibernate.entity.Student;
import com.sk.springBootHibernate.entity.Teacher;
import com.sk.springBootHibernate.repo.StudentListModel;
import com.sk.springBootHibernate.service.SchoolService;

@RestController
public class HomeController {

	@Autowired
	private SchoolService schoolService;

	@PostMapping(name="/studentCreate",path="/studentCreate" )
	ResponseEntity<String> saveStudentDetails(@RequestBody Student student){
	boolean status =schoolService.insertStudentDetails(student);
		if (status==true){
			return ResponseEntity.ok("Student Created");
		}else {
			return ResponseEntity.ok("Exception in Student Create");
		}
	}
	
	@PostMapping(name="/teacherCreate",path="/teacherCreate"  )
	ResponseEntity<String> saveTeacherDetails(@RequestBody Teacher teacher){
		boolean status =schoolService.insertTeacherDetails(teacher);
		if (status==true){
			return ResponseEntity.ok("Teacher Created");
		}else {
			return ResponseEntity.ok("Exception in Teacher Create");
		}
			
	}
	
	
	@GetMapping(name="/getAllStudents",path="/getAllStudents"  )
	List<Student> getAllStudentDetails(){
		List<Student> studentList =schoolService.getStudents();
		return studentList;
	}

	@GetMapping(name="/getAllTeachers",path="/getAllTeachers"  )
	List<Teacher> getAllTeacherDetails(){
		List<Teacher> teacherList =schoolService.getTeacher();
		return teacherList;
	}
	
	@GetMapping(name="/getStudent/{id}",path="/getStudent/{id}"  )
	Student getStudentDetails(@PathVariable long id) throws Exception{
		Student student = schoolService.getStudentById(id);
		return student;
	}
	
	@GetMapping(name="/getTeacher/{id}",path="/getTeacher/{id}"  )
	Teacher getTeacherDetails(@PathVariable long id) throws Exception{
		Teacher teacher = schoolService.getTeacherById(id);
		return teacher;
	}
	
	@DeleteMapping(name="/deleteStudentDetails/{id}",path="/deleteStudentDetails/{id}"  )
	ResponseEntity<String> deleteStudentDetails(@PathVariable long id) throws Exception{
		boolean status = schoolService.deleteStudentById(id);
		if(status){
			return ResponseEntity.ok("Student Details Deleted Sucussfully ");
		}else{
			return ResponseEntity.ok("Error in Deleting Student Details");
		}
	}
	
	@DeleteMapping(name="/deleteTeacherDetails/{id}",path="/deleteTeacherDetails/{id}"  )
	ResponseEntity<String> deleteTeacherDetails(@PathVariable long id) throws Exception{
		boolean status = schoolService.deleteTeacherById(id);
		if(status){
			return ResponseEntity.ok("Teacher Details Updated Sucussfully ");
		}else{
			return ResponseEntity.ok("Error in Updating Teacher Details");
		}
	}
	
	@PutMapping(name="/updateStudentDetails",path="/updateStudentDetails"  )
	ResponseEntity<String> updateStudentDetails(@RequestBody Student student) throws Exception{
		boolean status = schoolService.updateStudentDetails(student);
		if(status){
			return ResponseEntity.ok("Student Details updated Sucussfully ");
		}else{
			return ResponseEntity.ok("Error in updating Student Details");
		}
	}
	
	@PutMapping(name="/updateTeacherDetails",path="/updateTeacherDetails"  )
	ResponseEntity<String> updateTeacherDetails(@RequestBody Teacher teacher) throws Exception{
		boolean status = schoolService.updateTeacherDetails(teacher);
		if(status){
			return ResponseEntity.ok("Teacher Details Deleted Sucussfully ");
		}else{
			return ResponseEntity.ok("Error in Deleting Teacher Details");
		}
	}
	
	 @GetMapping(name="/studentsByClassTeacher/{id}",path="/studentsByClassTeacher/{id}"  )
	 StudentListModel getStudentsListByTeacher(@PathVariable long id) throws Exception{
		StudentListModel studentList = schoolService.getStudentsByClassTeacher(id);
	return studentList;
	}
	
	 @GetMapping(name="/teacherDetailsByStudent/{id}",path="/teacherDetailsByStudent/{id}"  )
	Teacher getTeacherListByStudent(@PathVariable long id) throws Exception{
		 Teacher teacherDetails = schoolService.getTeacherDetailsByStudent(id);
	return teacherDetails;
	}
	
}



