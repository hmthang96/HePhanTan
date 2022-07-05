package com.blt.manager.domain;

import com.blt.manager.model.Subject;

public class SubjectReponse extends BaseResponse {

    Subject subject;


    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
