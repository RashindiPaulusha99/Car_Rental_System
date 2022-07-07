package lk.ijse.spring.service;

import lk.ijse.spring.dto.ScheduleDTO;

import java.util.List;

public interface ScheduleService {
    void saveSchedule(ScheduleDTO scheduleDTO);

    void updateSchedule(ScheduleDTO scheduleDTO);

    void deleteSchedule(String id);

    ScheduleDTO searchSchedule(String id);

    List<ScheduleDTO> getAllSchedules();

    String generateScheduleIds();


}
