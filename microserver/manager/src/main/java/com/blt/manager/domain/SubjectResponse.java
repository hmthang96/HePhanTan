package com.blt.manager.domain;

import com.blt.manager.model.Subject;

public class SubjectResponse extends BaseResponse{
    private Subject subject;

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
