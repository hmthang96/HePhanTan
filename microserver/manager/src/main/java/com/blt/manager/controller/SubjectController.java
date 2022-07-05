package com.blt.manager.controller;

import com.blt.manager.domain.BaseResponse;
import com.blt.manager.domain.UserResponse;
import com.blt.manager.model.StudentCourse;
import com.blt.manager.model.Subject;
import com.blt.manager.model.User;
import com.blt.manager.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @CrossOrigin(origins = "*")
<<<<<<< HEAD
    @PostMapping("/getAll")
    public ResponseEntity<BaseResponse> getAll(){

        return ResponseEntity.ok(subjectService.getAll());
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/getById")
    public ResponseEntity<BaseResponse> getById(int idSubject){

        return ResponseEntity.ok(subjectService.getById(idSubject));
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/add")
    public ResponseEntity<BaseResponse> add(Subject subject){

        return ResponseEntity.ok(subjectService.add(subject));
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/change")
    public ResponseEntity<BaseResponse> change(Subject subject){

        return ResponseEntity.ok(subjectService.change(subject));
    }
=======
    @PostMapping("/changeTime")
    public ResponseEntity<BaseResponse> changeTime() {

        return ResponseEntity.ok(subjectService.changeTime1());
    }

>>>>>>> 5749b6cfdd25917e16fd4557225b583b367d6b99

}
