package lk.ijse.spring.service;

import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.entity.Driver;

import java.util.List;

public interface DriverService {
    void saveDriver(DriverDTO driver);

    void updateDriver(DriverDTO driver);

    void deleteDriver(String id);

    DriverDTO searchDriver(String id);

    List<DriverDTO> getAllDrivers();

    String generateDriverIds();

    void updateDriverIfHeReleaseOrNot(String release, String driverId);

    DriverDTO assignRandomlyDriver(String release);

    int availableDriversOrOccupiedDrivers(String release);

    DriverDTO searchUserFromDriver(String id);

    List<DriverDTO> searchAvailableDriversOrOccupiedDrivers(String release);


}
