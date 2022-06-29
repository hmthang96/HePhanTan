package com.blt.manager.service;

import com.blt.manager.domain.BaseResponse;
import com.blt.manager.model.Schedule;
import com.blt.manager.repository.ScheduleRepository;
import com.blt.manager.repository.SubjectRepository;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {

    SubjectRepository subjectRepository;


    ScheduleRepository scheduleRepository;

    public BaseResponse changeTime(String mssv) {
        BaseResponse baseResponse = new BaseResponse();




        return baseResponse;
    }
}
