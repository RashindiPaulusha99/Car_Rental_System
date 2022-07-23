package lk.ijse.spring.dto;

import javafx.scene.image.ImageView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CarDTO {
    private String carId;
    private String registrationNo;
    private String colour;
    private String brand;
    private String type;
    private String fuelType;
    private String transmissionType;
    private int NoOfPassengers;
    private int freeKmForDay;
    private int freeKmForMonth;
    private double pricePerExtraKM;
    private double dailyRatePrice;
    private double monthlyRatePrice;
    private int totalDistanceTraveled;
    private String availableOrNot;
    private String damageOrNot;
    private String underMaintainOrNot;

}
