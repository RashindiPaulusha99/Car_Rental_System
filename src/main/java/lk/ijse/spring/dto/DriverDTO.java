package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class DriverDTO {
    private String driverId;
    private UsersDTO users;
    private String driverName;
    private String driverAddress;
    private int driverAge;
    private String driverContact;
    private String releaseOrNot;

}
