package com.bootcamp.springboot.app.student.models.dao;

import com.bootcamp.springboot.app.student.models.documents.Student;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface StudentDao extends ReactiveMongoRepository<Student, String> {

  Flux<Student> findByFullNameContains(String fullName);

  Mono<Student> findByNumberOfDocument(Integer numberOfDocument);
  
}
