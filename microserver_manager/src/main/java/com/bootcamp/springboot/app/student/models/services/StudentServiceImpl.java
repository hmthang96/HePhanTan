package com.bootcamp.springboot.app.student.models.services;

import com.bootcamp.springboot.app.student.models.dao.StudentDao;
import com.bootcamp.springboot.app.student.models.documents.Student;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentServiceImpl implements StudentService {

  @Autowired
  private StudentDao dao;

  @Override
  public Flux<Student> findAll() {
    return dao.findAll();
  }

  @Override
  public Flux<Student> findAllWithName(String name) {
    return dao.findByFullNameContains(name);
  }

  @Override
  public Flux<Student> findAllWithDate(LocalDate firstDate, LocalDate secondDate) {
    return null;
  }

  @Override
  public Mono<Student> findAllWithMejor(Integer mejor) {
    return dao.findByNumberOfDocument(mejor);
  }

  @Override
  public Mono<Student> findById(String id) {
    return dao.findById(id);
  }

  @Override
  public Mono<Student> save(Student student) {
    return dao.save(student);
  }

  @Override
  public Mono<Void> delete(Student student) {
    return dao.delete(student);
  }

}
