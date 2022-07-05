package com.blt.manager.domain;

import com.blt.manager.model.Schedule;

import java.util.List;

public class ScheduleListReponse extends BaseResponse{

    private List<Schedule> schedules;

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }
}
