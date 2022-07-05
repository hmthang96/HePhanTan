package com.blt.manager.repository;


import com.blt.manager.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Integer> {

<<<<<<< HEAD
    List<Subject> findAll();
    Subject save(Subject subject);
=======
    Subject findByIdSubject(int id);
>>>>>>> 5749b6cfdd25917e16fd4557225b583b367d6b99

    Subject findByName(String name);

    Subject findByCourseCode(String courseCode);

    Subject findByIdSubject(int id);

    List<Subject> findAll();
}
