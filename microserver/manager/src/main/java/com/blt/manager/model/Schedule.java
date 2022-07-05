package com.blt.manager.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "schedule")
public class Schedule implements Serializable {

    private static final long serialVersionUID = 7L;

    private static final String MY_TIME_ZONE="Asia/Ho_Chi_Minh";

    @Id
    @Column(name = "id_schedule")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSchedule;

    @Column(name = "id_subject")
    private int idSubject;

    @Column(name = "time_start")
    @JsonFormat(pattern="yyyy-MM-dd", timezone =MY_TIME_ZONE)
    private Date timeStart;

    @Column(name = "time_end")
    @JsonFormat(pattern="yyyy-MM-dd", timezone =MY_TIME_ZONE)
    private Date timeEnd;

    @Column(name = "number_of_students")
    private int numberOfStudents;

    @Column(name = "lecturers")
    private String lecturers;

    public Schedule(int idSchedule, int idSubject, Date timeStart, Date timeEnd, int numberOfStudents, String lecturers) {
        this.idSchedule = idSchedule;
        this.idSubject = idSubject;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.numberOfStudents = 0;
        this.lecturers = lecturers;
    }

    public int getIdSchedule() {
        return idSchedule;
    }

    public void setIdSchedule(int idSchedule) {
        this.idSchedule = idSchedule;
    }

    public int getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(int idSubject) {
        this.idSubject = idSubject;
    }

    public Date getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public String getLecturers() {
        return lecturers;
    }

    public void setLecturers(String lecturers) {
        this.lecturers = lecturers;
    }
}
