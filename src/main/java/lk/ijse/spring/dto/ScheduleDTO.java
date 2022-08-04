package lk.ijse.spring.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ScheduleDTO {

    private String scheduleId;
    private String pickUpDate;
    private String pickUpTime;
    private String returnDate;
    private String returnTime;
    private String pickUpVenue;
    private String returnVenue;
    private String releaseOrNot;
    
    private ReserveDetailsDTO reserveDetails;

}
