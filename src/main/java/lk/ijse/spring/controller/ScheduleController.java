package lk.ijse.spring.controller;

import lk.ijse.spring.dto.ScheduleDTO;
import lk.ijse.spring.service.ScheduleService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("schedule")
@CrossOrigin
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveSchedule(@ModelAttribute ScheduleDTO scheduleDTO){
        scheduleService.saveSchedule(scheduleDTO);
        return new ResponseUtil(200, "Successfully Saved.",null);
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchSchedule(@PathVariable String id){
        return new ResponseUtil(200, "Ok.",scheduleService.searchSchedule(id));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateSchedule(@RequestBody ScheduleDTO scheduleDTO){
        scheduleService.updateSchedule(scheduleDTO);
        return new ResponseUtil(200, "Successfully Updated.",null);
    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteSchedule(@RequestParam String id){
        scheduleService.deleteSchedule(id);
        return new ResponseUtil(200, "Successfully Deleted.", null);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllSchedules(){
        return new ResponseUtil(200, "Ok", scheduleService.getAllSchedules());
    }

    @GetMapping(params = {"test"})
    public ResponseUtil generateScheduleIds(@RequestParam String test) {
        return new ResponseUtil(200, "Ok", scheduleService.generateScheduleIds());
    }

}
