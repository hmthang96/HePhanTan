package com.blt.manager.repository;

import com.blt.manager.model.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourse,Integer> {
    StudentCourse findByIdStudentCourse(int id);




}
