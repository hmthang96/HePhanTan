package com.blt.manager.repository;

import com.blt.manager.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule,Integer> {
    Schedule findByIdSchedule(int id);

    Schedule findByIdSubject(int id);




    List<Schedule> findAll();

}
