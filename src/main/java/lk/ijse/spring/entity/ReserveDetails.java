package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
@IdClass(ReserveCars.class)
public class ReserveDetails {

    @Id
    private String reserveId;
    @Id
    private String carId;
    @Id
    private String driverId;

    private String registrationNo;
    private String colour;
    private String brand;
    private String driverName;
    private double loseDamageWaiverPayment;

    @ManyToOne
    @JoinColumn(name = "reserveId",referencedColumnName = "reserveId",updatable = false,insertable = false)
    private Reserve reserve;

    @ManyToOne
    @JoinColumn(name = "carId",referencedColumnName = "carId",insertable = false,updatable = false)
    private Car car;

    @ManyToOne
    @JoinColumn(name = "driverId",referencedColumnName = "driverId",insertable = false,updatable = false)
    private Driver driver;

}
