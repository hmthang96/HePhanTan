package com.blt.manager.domain;

import com.blt.manager.model.StudentCourse;

public class StudentCourseReponse extends BaseResponse{

    StudentCourse studentCourse;

    public StudentCourse getStudentCourse() {
        return studentCourse;
    }

    public void setStudentCourse(StudentCourse studentCourse) {
        this.studentCourse = studentCourse;
    }
}
