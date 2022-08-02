package lk.ijse.spring.service;

import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.entity.Car;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarService {

    void saveCar(CarDTO car);

    void updateCar(CarDTO car);

    void deleteCar(String id);

    CarDTO searchCar(String id);

    List<CarDTO> getAllCars();

    String generateCarIds();

    String carAvailableOrNot(String available, String id);

    int noOfAvailableOrReservedCars(String availableCount);

    int needMaintenanceOrUnderMaintenanceCars(String maintain);

    Double calculateKmUntil5000km(String distance, String carId);

    List<CarDTO> sortAccordingToPassengersByDescending();

    List<CarDTO> sortAccordingToPassengersByAscending();

    List<CarDTO> findByTransmissionType(String type);

    List<CarDTO> findByBrand(String brand);

    List<CarDTO> findByType(String type);

    List<CarDTO> findByFuelType(String fuelType);

    List<Car> findByColour(String colour);

    List<CarDTO> sortAccordingToDailyRatePriceByDescending();

    List<CarDTO> sortAccordingToDailyRatePriceByAscending();

    List<CarDTO> sortAccordingToMonthlyRatePriceByAscending();

    List<CarDTO> sortAccordingToMonthlyRatePriceByDescending();

    String searchRegNumberIsDuplicate(String reg);

}
