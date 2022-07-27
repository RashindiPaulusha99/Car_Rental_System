package lk.ijse.spring.service;

import lk.ijse.spring.dto.DriverDTO;

import java.util.List;

public interface DriverService {
    void saveDriver(DriverDTO driver);

    void updateDriver(DriverDTO driver);

    void deleteDriver(String id);

    DriverDTO searchDriver(String id);

    List<DriverDTO> getAllDrivers();

    String generateDriverIds();

    void updateDriverIfHeReleaseOrNot(String release, String driverId);

    String assignRandomlyDriver(String NO);

    int availableDriversOrOccupiedDrivers(String NO);

    DriverDTO searchUserFromDriver(String id);


}
