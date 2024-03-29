package lk.ijse.spring.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CustomerDTO {
    private String customerId;

    private UsersDTO users;

    private String customerName;
    private String registeredDate;
    private String customerAddress;
    private String customerContact;
    private String customerEmail;
    private String customerNicNo;
    private String customerDrivingLicenseNo;
    private String NICImage;
    private String DrivingLicenseImage;


}
