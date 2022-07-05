package com.blt.manager.controller;

import com.blt.manager.domain.BaseResponse;
import com.blt.manager.domain.UserResponse;
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
    @PostMapping("/changeTime")
    public ResponseEntity<BaseResponse> changeTime() {

        return ResponseEntity.ok(subjectService.changeTime1());
    }


}
