package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Driver {
    private String driverId;
    private String driverName;
    private String driverAddress;
    private int driverAge;
    private String driverContact;

}
