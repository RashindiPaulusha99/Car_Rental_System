package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarRepo extends JpaRepository<Car, String> {

    @Query(value = "SELECT carId FROM Car ORDER BY carId DESC LIMIT 1", nativeQuery = true)
    String generateCarId();

    @Query(value = "SELECT COUNT(*) FROM Car WHERE availableOrNot=:available", nativeQuery = true)
    int NoOfAvailableOrReservedCars(@Param("available") String available);

    @Query(value = "SELECT COUNT(*) FROM Car WHERE underMaintainOrNot=:maintain", nativeQuery = true)
    int needMaintenanceOrUnderMaintenanceCars(@Param("maintain") String maintain);

    @Query(value = "UPDATE Car SET totalDistanceTraveled=:distance WHERE driverId=:driverId", nativeQuery = true)
    Double calculateKmUntil5000km(@Param("distance") String distance, @Param("driverId") String driverId);

    @Query(value = "SELECT * FROM Car ORDER BY NoOfPassengers DESC", nativeQuery = true)
    List<Car> sortAccordingToPassengersByDescending();

    @Query(value = "SELECT * FROM Car ORDER BY NoOfPassengers ASC", nativeQuery = true)
    List<Car> sortAccordingToPassengersByAscending();

    @Query(value = "SELECT * FROM Car WHERE transmissionType=:type", nativeQuery = true)
    List<Car> sortAccordingToTransmissionType(@Param("type") String type);

    @Query(value = "SELECT * FROM Car WHERE brand=:brand", nativeQuery = true)
    List<Car> sortAccordingToBrand(@Param("brand") String brand);

    @Query(value = "SELECT * FROM Car WHERE type=:type", nativeQuery = true)
    List<Car> sortAccordingToType(@Param("type") String type);

    @Query(value = "SELECT * FROM Car ORDER BY dailyRatePrice DESC", nativeQuery = true)
    List<Car> sortAccordingToDailyRatePriceByDescending();

    @Query(value = "SELECT * FROM Car ORDER BY dailyRatePrice ASC", nativeQuery = true)
    List<Car> sortAccordingToDailyRatePriceByAscending();

    @Query(value = "SELECT * FROM Car ORDER BY monthlyRatePrice ASC", nativeQuery = true)
    List<Car> sortAccordingToMonthlyRatePriceByAscending();

    @Query(value = "SELECT * FROM Car ORDER BY monthlyRatePrice DESC", nativeQuery = true)
    List<Car> sortAccordingToMonthlyRatePriceByDescending();

    @Query(value = "SELECT * FROM Car WHERE fuelType=:type", nativeQuery = true)
    List<Car> sortAccordingToFuelType(@Param("fuelType") String fuelType);

}
