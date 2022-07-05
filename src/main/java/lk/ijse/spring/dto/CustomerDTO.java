package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CustomerDTO {
    private String customerId;
    private String customerName;
    private String customerAddress;
    private String customerContact;
    private String customerEmail;
    private String customerNicORDrivingLicenseNo;

}
