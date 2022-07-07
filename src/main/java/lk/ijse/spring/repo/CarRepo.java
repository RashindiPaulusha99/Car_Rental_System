package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepo extends JpaRepository<Car, String> {

    @Query(value = "SELECT carId FROM Car ORDER BY carId DESC LIMIT 1", nativeQuery = true)
    String generateCarId();

    int NoOfAvailableCars();

    int NoOfReservedCars();

    int needMaintenanceCars();

    int underMaintenanceCars();

    List<Car> sortAccordingToPassengers();

    List<Car> sortAccordingToTransmissionType();

    List<Car> sortAccordingToBrand();

    List<Car> sortAccordingToType();

    List<Car> sortAccordingToPrice();

}
