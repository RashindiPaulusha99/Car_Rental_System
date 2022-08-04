package lk.ijse.spring.service;

import lk.ijse.spring.dto.ReserveDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReserveService {

    void reservationCars(ReserveDTO reserveDTO);
    void deleteReservation(String rId);
    void updateReservation(ReserveDTO reserveDTO);
    ReserveDTO searchReservation(String rId);
    List<ReserveDTO> getAllReservations();
    String generateReserveId();
    int countAllReservation();
    int countDailyReservation(String date);
    int activeReservationPerDay(String date, String accept);
    void updateDriverId(String driverId,String reserveId, String carId);
    void updateDriverDetails(String driverId,String driverName, String driverContact, String reserveId);
}
