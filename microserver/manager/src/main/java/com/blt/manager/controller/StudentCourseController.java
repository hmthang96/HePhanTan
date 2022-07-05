package com.blt.manager.controller;


import com.blt.manager.domain.BaseResponse;
import com.blt.manager.model.StudentCourse;
import com.blt.manager.service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/studentcourse")
public class StudentCourseController {

    @Autowired
    private StudentCourseService studentCourseService;

    @CrossOrigin(origins = "*")
    @PostMapping("/getAll")
    public ResponseEntity<BaseResponse> getAll(){

        return ResponseEntity.ok(studentCourseService.getAll());
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/getById")
    public ResponseEntity<BaseResponse> getById(String mssv){

        return ResponseEntity.ok(studentCourseService.getById(mssv));
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/add")
    public ResponseEntity<BaseResponse> add(StudentCourse studentCourse){

        return ResponseEntity.ok(studentCourseService.add(studentCourse));
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/change")
    public ResponseEntity<BaseResponse> change(StudentCourse studentCourse){

        return ResponseEntity.ok(studentCourseService.change(studentCourse));
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/delete")
    public ResponseEntity<BaseResponse> delete(StudentCourse studentCourse){

        return ResponseEntity.ok(studentCourseService.delete(studentCourse));
    }

}
