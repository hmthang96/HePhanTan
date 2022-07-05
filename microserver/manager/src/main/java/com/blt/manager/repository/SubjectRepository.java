package com.blt.manager.repository;


import com.blt.manager.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Integer> {

    List<Subject> findAll();
    Subject save(Subject subject);

    Subject findByName(String name);

    Subject findByCourseCode(String courseCode);

    Subject findByIdSubject(int id);

}
