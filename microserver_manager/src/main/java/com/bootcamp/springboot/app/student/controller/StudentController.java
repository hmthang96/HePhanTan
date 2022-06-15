package com.bootcamp.springboot.app.student.controller;

import com.bootcamp.springboot.app.student.models.dao.StudentDao;
import com.bootcamp.springboot.app.student.models.documents.Student;
import com.bootcamp.springboot.app.student.models.services.StudentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RefreshScope
@RestController
@RequestMapping("/api/students")
@Api(value = "students", description = "Students API", produces = "application/json")
public class StudentController {

  public static Logger log = LoggerFactory.getLogger(StudentController.class);


  @Autowired
  private StudentService service;

  @Autowired
  private StudentDao dao;

  @ApiOperation(value = "Get Students", notes = "Returns all students")
  @ApiResponses({
          @ApiResponse(code = 200, message = "Exits one student at least")
  })
  @GetMapping()
  Flux<Student> index() {
    Flux<Student> students = dao.findAll().doOnNext(p -> log.info(p.getFullName()));
    return students;
  }

  
  
  /** Extra javadoc (ignored). */
  public Mono<Student> getIdStudentAlternative() throws ParseException {
    Date myDate = new SimpleDateFormat("yyyy-MM-dd").parse("2000-01-01");
    Student student1 = new Student("fallo", "masculino", myDate, "DNI", 12312312);
    Mono<Student> student = Mono.just(student1);

    return student;
  }


  
  /** Extra javadoc (ignored). */
  @ApiOperation(value = "Get one Student", notes = "Returns one student searched by Id")
  @ApiResponses({
            @ApiResponse(code = 200, message = "Exits one student")
    })
  @GetMapping("/{id}")
  public Mono<Student> showId(@PathVariable String id) throws Exception {

    Flux<Student> students = dao.findAll();
    Mono<Student> student = students.filter(p -> p.getId().equals(id)).next()
        .doOnNext(p -> log.info(p.getFullName()));

    return student;
  }


  @ApiOperation(value = "Get one Student", notes = "Returns one student searched by name")
  @ApiResponses({
            @ApiResponse(code = 200, message = "Exits one student")
    })
  @GetMapping("/name/{name}")
  public Flux<Student> showName(@PathVariable String name) {

    return service.findAllWithName(name);
  }

  
  @ApiOperation(value = "Get one Student", 
      notes = "Returns one student searched by number of Document")
  @ApiResponses({
      @ApiResponse(code = 200, message = "Exits one student")
      })
  @GetMapping("/document/{document}")
  public Mono<Student> showDocument(@PathVariable Integer document) {

    return service.findAllWithDocument(document);
  }

  /** Extra javadoc (ignored). */
  @GetMapping("/date/{dateInit}/{dateEnd}")
  public Flux<Student> findByDateRange(@PathVariable final String dateInit,
      @PathVariable final String dateEnd) {
    LocalDate fecha1LD = LocalDate.parse(dateInit).minusDays(2);
    LocalDate fecha2LD = LocalDate.parse(dateEnd).plusDays(1);
    return service.findAll()
      .filter(p -> p.getBirthDate()
        .toInstant().atZone(ZoneId.systemDefault())
        .toLocalDate().isAfter(fecha1LD))
      .filter(p -> p.getBirthDate()
        .toInstant().atZone(ZoneId.systemDefault())
        .toLocalDate().isBefore(fecha2LD));
  }
  
  
  @ApiOperation(value = "Create Student", notes = "Create a student")
  @ApiResponses({
            @ApiResponse(code = 201, message = "Successful student of a student")
    })
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<Student> saving(@RequestBody Student student) {
    return service.save(student);
  }
  
  
  /** Extra javadoc (ignored). */
  @ApiOperation(value = "Delete Student", notes = "Delete a student")
  @ApiResponses({
            @ApiResponse(code = 204, message = "Successful delete of a student")
    })
  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public Mono<String> deleting(@PathVariable String id) {
    return service.findById(id).defaultIfEmpty(new Student()).flatMap(s -> {
      if (s.getId() == null) {
        return Mono.error(new InterruptedException("The student doesnt exist"));
      }
      return Mono.just(s);
    }).flatMap(s -> {
      log.info("Deleting the student" + s.getFullName());
      log.info("Deleting the student with id" + s.getId());
      return service.delete(s);
    }).then(Mono.just("The student was deleted successfully"))
   .onErrorResume(ex -> Mono.just("The student cant be deleted"));
  }

  
  /** Extra javadoc (ignored). */
  @ApiOperation(value = "Update Student", notes = "Update a student")
  @ApiResponses({
           @ApiResponse(code = 204, message = "Successful update of a student")
    })
  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<Student> updating(@PathVariable String id, @RequestBody Student student) {

    return service.findById(id).map(s -> {
      s.setFullName(student.getFullName());
      s.setBirthDate(student.getBirthDate());
      s.setGender(student.getGender());
      s.setNumberOfDocument(student.getNumberOfDocument());
      s.setTypeOfDocument(student.getTypeOfDocument());
      return s;
    }).flatMap(s -> {
      return service.save(s);
    });
  }

}
