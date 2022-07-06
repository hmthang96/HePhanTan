package com.blt.manager.service;

import com.blt.manager.domain.BaseResponse;
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

    ScheduleReponse scheduleReponse;

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
        schedule1.setNumberOfStudents(schedule.getNumberOfStudents());

        scheduleRepository.save(schedule1);

        scheduleReponse.setMessage("save success");
        scheduleReponse.setSchedule(schedule1);

        return scheduleReponse;
    }

    public ScheduleReponse add(Schedule schedule){
        ScheduleReponse scheduleReponse = new ScheduleReponse();

        if (scheduleRepository.findByIdSchedule(schedule.getIdSchedule())!=null){
            scheduleReponse.setCode("012");
            scheduleReponse.setMessage("Id schedule đã tồn tại");
        } else if (schedule.getIdSchedule() == 0) {
            scheduleReponse.setCode("013");
            scheduleReponse.setMessage("chua co id schedule");
        } else if (schedule.getTimeStart() == null) {
            scheduleReponse.setCode("014");
            scheduleReponse.setMessage("chua co Time Start");
        } else  {
            scheduleReponse.setCode("000");
            scheduleReponse.setMessage("Thành công");
            scheduleRepository.save(schedule);
        }
        
        
        return scheduleReponse;
    }


    public ScheduleReponse delete(Schedule schedule) {
        scheduleReponse = new ScheduleReponse();
        Schedule schedule1 = scheduleRepository.findByIdSchedule(schedule.getIdSchedule());
        if(schedule1 == null){
            scheduleReponse.setCode("015");
            scheduleReponse.setMessage("không tồn tại lịch học");
        } else if (schedule.getIdSubject() != schedule1.getIdSubject()) {
            scheduleReponse.setCode("016");
            scheduleReponse.setMessage("không trùng id môn học");
        }else if (schedule.getTimeStart().compareTo(schedule1.getTimeStart())!=0) {
            scheduleReponse.setCode("017");
            scheduleReponse.setMessage("không trùng thời gian bắt đầu");
        }else if (schedule.getTimeEnd().compareTo(schedule1.getTimeEnd())!=0 ) {
            scheduleReponse.setCode("018");
            scheduleReponse.setMessage("không trùng thời gian kết thúc");
        }else if (schedule.getNumberOfStudents() != schedule1.getNumberOfStudents()) {
            scheduleReponse.setCode("019");
            scheduleReponse.setMessage("không trùng số lượng sinh viên");
        }else if (schedule.getLecturers().equals(schedule1.getLecturers())) {
            scheduleReponse.setCode("020");
            scheduleReponse.setMessage("không trùng giáo viên");
        }else{
            scheduleReponse.setCode("000");
            scheduleReponse.setMessage("Thành công");
            scheduleReponse.setSchedule(schedule1);
            scheduleRepository.delete(schedule1);
        }

        return scheduleReponse;
    }
}
