package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class Customer {

    @Id
    private String customerId;
    private LocalDate registeredDate;
    private String customerName;
    private String customerAddress;
    private String customerContact;
    private String customerEmail;
    private String customerNicNo;
    private String customerDrivingLicenseNo;
    private String NICImage;
    private String DrivingLicenseImage;

    @OneToOne(cascade = CascadeType.ALL)
    private Users users;

}
