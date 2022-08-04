package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class ReserveDetailsDTO {

    private String reserveId;

    private String carId;
    private String type;
    private String colour;
    private String brand;

    private String driverWantOrNot;
    private String driverId;
    private String driverName;
    private String driverContact;

    private double loseDamageWaiverPayment;

}
