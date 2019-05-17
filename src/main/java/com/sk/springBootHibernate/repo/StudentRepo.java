package com.sk.springBootHibernate.repo;

import org.springframework.stereotype.Repository;

import com.sk.springBootHibernate.entity.Student;

import java.util.ArrayList;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long>{
	@Query("select studentId,studentName,studentStandard,studentAddress from Student  where teacher_id=:teacherId")
	ArrayList<Student> findByteacher(@Param("teacherId")long teacherId);
}
