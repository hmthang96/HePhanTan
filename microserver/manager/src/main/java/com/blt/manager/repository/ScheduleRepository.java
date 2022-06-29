package com.blt.manager.repository;

import com.blt.manager.model.Schedule;
import com.blt.manager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule,Integer> {
    Schedule findByIdSchedule(int id);


}
