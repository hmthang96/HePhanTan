package com.blt.manager.domain;

import com.blt.manager.model.Subject;

import java.util.List;

public class SubjectListReponse extends BaseResponse{


    List<Subject> subjectList;

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;

    }
}
