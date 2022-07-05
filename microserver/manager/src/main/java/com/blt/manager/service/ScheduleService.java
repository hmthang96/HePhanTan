package com.blt.manager.service;

import com.blt.manager.domain.ScheduleListReponse;
import com.blt.manager.domain.ScheduleReponse;
import com.blt.manager.model.Schedule;
import com.blt.manager.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    ScheduleRepository scheduleRepository;

    public ScheduleListReponse findAll() {
        List<Schedule> schedules = scheduleRepository.findAll();

        ScheduleListReponse scheduleListReponses = new ScheduleListReponse();
        scheduleListReponses.setSchedules(schedules);

        return scheduleListReponses;
    }

    public ScheduleReponse changeTimeStudy(Schedule schedule) {
        ScheduleReponse scheduleReponse = new ScheduleReponse();

        Schedule schedule1 = scheduleRepository.findByIdSchedule(schedule.getIdSchedule());

        if(schedule.getTimeStart() != null){
            schedule1.setTimeStart(schedule.getTimeStart());
        }
        if (schedule.getTimeEnd()!=null) {
            schedule1.setTimeEnd(schedule.getTimeEnd());
        }
        if (schedule.getNumberOfStudents() != 0) {
            schedule1.setNumberOfStudents(schedule.getNumberOfStudents());
        }
        scheduleRepository.save(schedule1);

        scheduleReponse.setMessage("save success");
        scheduleReponse.setSchedule(schedule1);

        return scheduleReponse;
    }
}
