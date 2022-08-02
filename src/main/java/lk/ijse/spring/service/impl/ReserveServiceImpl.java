package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.ReserveDTO;
import lk.ijse.spring.entity.*;
import lk.ijse.spring.repo.*;
import lk.ijse.spring.service.ReserveService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class ReserveServiceImpl implements ReserveService {

    @Autowired
    private ReserveRepo reserveRepo;

    @Autowired
    private ReserveDetailsRepo reserveDetailsRepo;

    @Autowired
    private CarRepo carRepo;

    @Autowired
    private DriverRepo driverRepo;

    @Autowired
    private ScheduleRepo scheduleRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void reservationCars(ReserveDTO reserveDTO) {
        Reserve reserve = modelMapper.map(reserveDTO, Reserve.class);
        if (!reserveRepo.existsById(reserveDTO.getReserveId())){

            if (reserveDTO.getReserveDetails().size() < 1){
                throw new RuntimeException("No Selected Cars In Reservation..!");
            }else {
                reserveRepo.save(reserve);

                for (ReserveDetails reserveDetails : reserve.getReserveDetails()) {
                    Car car = carRepo.findById(reserveDetails.getCarId()).get();
                    carRepo.carAvailableOrNot("Not Available",car.getCarId()) ;
                    Driver driver = driverRepo.findById(reserveDetails.getDriverId()).get();
                    driverRepo.updateDriverIfHeReleaseOrNot("NO", reserveDetails.getDriverId());

                    Schedule rd = new Schedule(
                            scheduleRepo.generateScheduleId(),
                            reserve.getPickUpDate(),
                            reserve.getPickUpTime(),
                            reserve.getReserveDate(),
                            reserve.getReturnTime(),
                            reserve.getPickUpVenue(),
                            reserve.getReturnVenue(),
                            driver.getReleaseOrNot(),
                            reserveDetails
                    );
                    scheduleRepo.save(rd);
                }
            }

        }else {
            throw  new RuntimeException(reserveDTO.getReserveId()+" "+"Reservation Already Exist..!");
        }
    }

    @Override
    public void deleteReservation(String rId) {
        if (reserveRepo.existsById(rId)){
            reserveRepo.deleteById(rId);
        }else {
            throw new RuntimeException(rId +" "+ "No Such Reservation..! Please Check The Correct ID..!");
        }
    }

    @Override
    public void updateReservation(ReserveDTO reserveDTO) {
        Reserve reserve = modelMapper.map(reserveDTO, Reserve.class);

        if (reserveRepo.existsById(reserveDTO.getReserveId())){
            Reserve referenceById= reserveRepo.findById(reserveDTO.getReserveId()).get();
            for (ReserveDetails reserveDetail : referenceById.getReserveDetails()) {
                driverRepo.updateDriverIfHeReleaseOrNot("Release",reserveDetail.getDriverId());
            }
        }

        if (reserveRepo.existsById(reserve.getReserveId())){
            reserveRepo.save(reserve);
            for (ReserveDetails reserveDetails : reserve.getReserveDetails()) {

                driverRepo.updateDriverIfHeReleaseOrNot("Not Release", reserveDetails.getDriverId());
                Driver driver = driverRepo.findById(reserveDetails.getDriverId()).get();

                Schedule rd = new Schedule(
                        scheduleRepo.generateScheduleId(),
                        reserve.getPickUpDate(),
                        reserve.getPickUpTime(),
                        reserve.getReserveDate(),
                        reserve.getReturnTime(),
                        reserve.getPickUpVenue(),
                        reserve.getReturnVenue(),
                        driver.getReleaseOrNot(),
                        reserveDetails
                );
                scheduleRepo.save(rd);
            }
        }
    }

    @Override
    public ReserveDTO searchReservation(String rId) {
        if (reserveRepo.existsById(rId)){
            Reserve reserve = reserveRepo.findById(rId).get();
            return modelMapper.map(reserve, ReserveDTO.class);
        }else {
            throw new RuntimeException(rId + " " + "No Such Reservation..! Please Check The ID..!");
        }
    }

    @Override
    public List<ReserveDTO> getAllReservations() {
        List<Reserve> all = reserveRepo.findAll();
        return modelMapper.map(all, new TypeToken<List<ReserveDTO>>(){
        }.getType());
    }

    @Override
    public String generateReserveId() {
        return reserveRepo.generateReserveId();
    }

    @Override
    public int countAllReservation() {
        return reserveRepo.countAllReservation();
    }

    @Override
    public int countDailyReservation(String date) {
        return reserveRepo.countDailyReservation(date);
    }

    @Override
    public int activeReservationPerDay(String date,String accept) {
        return reserveRepo.activeReservationPerDay(date,accept);
    }
}
