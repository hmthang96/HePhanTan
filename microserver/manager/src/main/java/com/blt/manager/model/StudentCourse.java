package com.blt.manager.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "student_course")
public class StudentCourse implements Serializable  {

    private static final long serialVersionUID = 11L;
    @Id
    @Column(name = "id_student_course")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idStudentCourse;

    @Column(name = "name")
    private String name;

    @Column(name = "credits")
    private String credits;

    public int getIdStudentCourse() {
        return idStudentCourse;
    }

    public void setIdStudentCourse(int idStudentCourse) {
        this.idStudentCourse = idStudentCourse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCredits() {
        return credits;
    }

    public void setCredits(String credits) {
        this.credits = credits;
    }
}
