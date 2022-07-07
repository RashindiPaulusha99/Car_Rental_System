package lk.ijse.spring.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class ReserveDTO {

    private String reserveId;
    private CustomerDTO customer;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;
    private LocalTime pickUpTime;
    private String destination;
    private int duration;
    private String pickUpVenue;
    private String returnVenue;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate returnDate;
    private LocalTime returnTime;
    private boolean wantDriverOrNot;
    private String requestAcceptOrDeny;

    List<ReserveDetailsDTO> reserveDetails;

}
