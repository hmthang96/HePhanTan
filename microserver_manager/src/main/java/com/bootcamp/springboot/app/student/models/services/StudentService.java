package com.bootcamp.springboot.app.student.models.services;

import com.bootcamp.springboot.app.student.models.documents.Student;

import java.time.LocalDate;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StudentService {

  public Flux<Student> findAll();

  public Flux<Student> findAllWithName(String name);

  public Flux<Student> findAllWithDate(LocalDate firstDate, LocalDate secondDate);

  public Mono<Student> findAllWithDocument(Integer number);

  public Mono<Student> findById(String id);

  public Mono<Student> save(Student student);

  public Mono<Void> delete(Student student);
}
