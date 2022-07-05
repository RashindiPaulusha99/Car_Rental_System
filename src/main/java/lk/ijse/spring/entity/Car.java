package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Car {
    private String carId;
    private String registerNo;
    private String colour;
    private String brand;
    private String type;
    private String fuelType;
    private String transmissionType;
    private int NoOfPassengers;
    private int freeMileageDuration;
    private double pricePerExtraKM;
    private double dailyRatePrice;
    private double monthlyRatePrice;
    private int totalDistanceTraveled;
    private boolean availableOrNot;
    private boolean underMaintainOrNot;

}
