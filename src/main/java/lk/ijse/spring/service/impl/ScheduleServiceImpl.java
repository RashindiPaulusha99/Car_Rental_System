package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.ScheduleDTO;
import lk.ijse.spring.entity.Schedule;
import lk.ijse.spring.repo.ScheduleRepo;
import lk.ijse.spring.service.ScheduleService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    ScheduleRepo scheduleRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveSchedule(ScheduleDTO scheduleDTO) {
        if (!scheduleRepo.existsById(scheduleDTO.getScheduleId())){
            scheduleRepo.save(mapper.map(scheduleDTO, Schedule.class));
        }else {
            throw new RuntimeException(scheduleDTO.getScheduleId() + " " + "Schedule Already Exists..!");
        }
    }

    @Override
    public void updateSchedule(ScheduleDTO scheduleDTO) {
        if (scheduleRepo.existsById(scheduleDTO.getScheduleId())){
            scheduleRepo.save(mapper.map(scheduleDTO, Schedule.class));
        }else {
            throw new RuntimeException(scheduleDTO.getScheduleId() + " " + "No Such Schedule..! Please Check The Correct Id..!");
        }
    }

    @Override
    public void deleteSchedule(String id) {
        if (scheduleRepo.existsById(id)){
            scheduleRepo.deleteById(id);
        }else {
            throw new RuntimeException(id + " " + "No Such Schedule..! Please Check The Correct Id..!");
        }
    }

    @Override
    public ScheduleDTO searchSchedule(String id) {
        if (scheduleRepo.existsById(id)){
            Schedule schedule = scheduleRepo.findById(id).get();
            return mapper.map(schedule, ScheduleDTO.class);
        }else {
            throw new RuntimeException(id + " " + "No Such Schedule..! Please Check The Id..!");
        }
    }

    @Override
    public List<ScheduleDTO> getAllSchedules() {
        List<Schedule> all = scheduleRepo.findAll();
        return mapper.map(all, new TypeToken<List<ScheduleDTO>>(){
        }.getType());
    }

    @Override
    public String generateScheduleIds() {
        return scheduleRepo.generateScheduleId();
    }
}
