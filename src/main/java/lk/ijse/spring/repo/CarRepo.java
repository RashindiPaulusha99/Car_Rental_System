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

    @Query(value = "UPDATE Car SET totalDistanceTraveled=:distance WHERE carId=:carId", nativeQuery = true)
    double calculateKmUntil5000km(@Param("distance") String distance, @Param("carId") String carId);

    @Query(value = "UPDATE Car SET availableOrNot=:available WHERE carId=:carId", nativeQuery = true)
    String carAvailableOrNot(@Param("available") String available, @Param("carId") String carId);

    @Query(value = "SELECT * FROM Car ORDER BY NoOfPassengers DESC", nativeQuery = true)
    List<Car> sortAccordingToPassengersByDescending();

    @Query(value = "SELECT * FROM Car ORDER BY NoOfPassengers ASC", nativeQuery = true)
    List<Car> sortAccordingToPassengersByAscending();

    @Query(value = "SELECT * FROM Car ORDER BY dailyRatePrice DESC", nativeQuery = true)
    List<Car> sortAccordingToDailyRatePriceByDescending();

    @Query(value = "SELECT * FROM Car ORDER BY dailyRatePrice ASC", nativeQuery = true)
    List<Car> sortAccordingToDailyRatePriceByAscending();

    @Query(value = "SELECT * FROM Car ORDER BY monthlyRatePrice ASC", nativeQuery = true)
    List<Car> sortAccordingToMonthlyRatePriceByAscending();

    @Query(value = "SELECT * FROM Car ORDER BY monthlyRatePrice DESC", nativeQuery = true)
    List<Car> sortAccordingToMonthlyRatePriceByDescending();

    @Query(value = "SELECT * FROM Car WHERE transmissionType=:type ", nativeQuery = true)
    List<Car> findByTransmissionType(@Param("type") String type);

    @Query(value = "SELECT * FROM Car WHERE brand=:brand ", nativeQuery = true)
    List<Car> findByBrand(@Param("brand") String brand);

    @Query(value = "SELECT * FROM Car WHERE type=:type ", nativeQuery = true)
    List<Car> findByType(@Param("type") String type);

    @Query(value = "SELECT * FROM Car WHERE fuelType=:fuelType ", nativeQuery = true)
    List<Car> findByFuelType(@Param("fuelType") String fuelType);


}
