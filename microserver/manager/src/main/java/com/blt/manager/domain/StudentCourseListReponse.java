package com.blt.manager.domain;

import com.blt.manager.model.StudentCourse;

import java.util.List;

public class StudentCourseListReponse extends BaseResponse{

    List<StudentCourse> studentCourseList;

    public List<StudentCourse> getStudentCourseList() {
        return studentCourseList;
    }

    public void setStudentCourseList(List<StudentCourse> studentCourseList) {
        this.studentCourseList = studentCourseList;
    }
}
