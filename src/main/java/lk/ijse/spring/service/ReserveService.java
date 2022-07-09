package lk.ijse.spring.service;

import lk.ijse.spring.dto.ReserveDTO;

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
    int activeReservationPerDay(String active);
}
