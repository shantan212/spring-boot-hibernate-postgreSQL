package com.sk.springBootHibernate.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.sk.springBootHibernate.entity.Teacher;

public interface TeacherRepo extends JpaRepository<Teacher, Long>{

	
	@Query("from Teacher where teacherId=:studentId")
	Teacher findTeacherByStudent(@Param("studentId")long studentId);
	
}
