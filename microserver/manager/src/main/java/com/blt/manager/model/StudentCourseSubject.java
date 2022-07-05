package com.blt.manager.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "student_course_subject")
public class StudentCourseSubject implements Serializable {

    private static final long serialVersionUID = 13L;

    @Id
    @Column(name = "id_student_course_subject")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idStudentCourseSubject;

    @Column(name = "id_student_course")
    private String idStudentCourse;

    @Column(name = "id_subject")
    private String idSubject;

    public int getIdStudentCourseSubject() {
        return idStudentCourseSubject;
    }

    public void setIdStudentCourseSubject(int idStudentCourseSubject) {
        this.idStudentCourseSubject = idStudentCourseSubject;
    }

    public String getIdStudentCourse() {
        return idStudentCourse;
    }

    public void setIdStudentCourse(String idStudentCourse) {
        this.idStudentCourse = idStudentCourse;
    }

    public String getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(String idSubject) {
        this.idSubject = idSubject;
    }
}
