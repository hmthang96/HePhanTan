package com.blt.manager.repository;


import com.blt.manager.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Integer> {

    Subject findByIdSubject(int id);


    List<Subject> findAll();
}
