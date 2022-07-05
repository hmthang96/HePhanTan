package com.blt.manager.domain;

import com.blt.manager.model.Schedule;

public class ScheduleReponse extends BaseResponse{

    Schedule schedule;

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}
