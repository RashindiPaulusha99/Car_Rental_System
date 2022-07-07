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
public class RentPayment {

    @Id
    private String paymentId;

    private LocalDate paymentDate;
    private double rentFee;
    private String harmOrNot;
    private double loseDamagePayment;
    private double reduceLoseDamagePayment;
    private double driverFee;
    private double travelledDistance;
    private double extraKm;
    private double extraKmPrice;
    private double fullPayment;

    @OneToOne(cascade = CascadeType.ALL)
    private ReserveDetails reserveDetails;

}
