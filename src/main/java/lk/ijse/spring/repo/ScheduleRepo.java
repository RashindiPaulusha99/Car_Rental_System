package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ScheduleRepo extends JpaRepository<Schedule, String> {

    @Query(value = "SELECT scheduleId FROM Schedule ORDER BY scheduleId DESC LIMIT 1", nativeQuery = true)
    String generateScheduleId();


}
