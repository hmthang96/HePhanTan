package com.blt.manager.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "subject")
public class Subject implements Serializable {
    private static final long serialVersionUID = 8L;

    @Id
    @Column(name = "id_subject")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSubject;

    @Column(name = "name")
    private String name;

    @Column(name = "course_code")
    private String courseCode;

    @Column(name = "course_credits")
    private String courseCredits;

    @Column(name = "tuition_credits")
    private String tuitionCredits;

    public int getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(int idSubject) {
        this.idSubject = idSubject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseCredits() {
        return courseCredits;
    }

    public void setCourseCredits(String courseCredits) {
        this.courseCredits = courseCredits;
    }

    public String getTuitionCredits() {
        return tuitionCredits;
    }

    public void setTuitionCredits(String tuitionCredits) {
        this.tuitionCredits = tuitionCredits;
    }
}
