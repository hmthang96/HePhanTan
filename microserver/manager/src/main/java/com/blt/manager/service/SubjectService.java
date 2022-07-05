package com.blt.manager.service;

import com.blt.manager.domain.BaseResponse;
import com.blt.manager.domain.SubjectListReponse;
import com.blt.manager.domain.SubjectResponse;
import com.blt.manager.model.Schedule;
import com.blt.manager.model.Subject;
import com.blt.manager.repository.ScheduleRepository;
import com.blt.manager.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    SubjectRepository subjectRepository;


    ScheduleRepository scheduleRepository;

    public BaseResponse changeTime() {
        SubjectListReponse subjectResponses = new SubjectListReponse();

        List<Subject> subjects = subjectRepository.findAll();

        subjectResponses.setSubjects(subjects);

        return subjectResponses;
    }

    public BaseResponse changeTime1() {
        SubjectResponse subjectResponse = new SubjectResponse();

        subjectResponse.setSubject(subjectRepository.findByIdSubject(1));

        return subjectResponse;
    }
}
