package com.blt.manager.service;

import com.blt.manager.domain.BaseResponse;
import com.blt.manager.model.StudentCourse;
import com.blt.manager.repository.StudentCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentCourseService {

    @Autowired
    StudentCourseRepository studentCourseRepository;


    public BaseResponse getAll() {
        return null;
    }

    public BaseResponse getById(String mssv) {
        return null;
    }

    public BaseResponse add(StudentCourse studentCourse) {
        return null;
    }

    public BaseResponse change(StudentCourse studentCourse) {
        return null;
    }

    public BaseResponse delete(StudentCourse studentCourse) {
        return null;
    }
}
