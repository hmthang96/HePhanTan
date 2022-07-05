package com.blt.manager.domain;

import com.blt.manager.model.Subject;

import java.util.List;

public class SubjectListReponse extends BaseResponse{

    List<Subject> subjects;

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
