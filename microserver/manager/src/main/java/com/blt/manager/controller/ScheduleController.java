package com.blt.manager.controller;

import com.blt.manager.domain.BaseResponse;
import com.blt.manager.domain.ScheduleListReponse;
import com.blt.manager.domain.ScheduleReponse;
import com.blt.manager.model.Schedule;
import com.blt.manager.repository.ScheduleRepository;
import com.blt.manager.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService ;

    @CrossOrigin(origins = "*")
    @PostMapping("/findAll")
    public ResponseEntity<ScheduleListReponse> findAll(){
        return ResponseEntity.ok(scheduleService.findAll());
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/changeTimeStudy")
    public ResponseEntity<ScheduleReponse> changeTimeStudy(@RequestBody Schedule schedule){
        return ResponseEntity.ok(scheduleService.changeTimeStudy(schedule));
    }

}
