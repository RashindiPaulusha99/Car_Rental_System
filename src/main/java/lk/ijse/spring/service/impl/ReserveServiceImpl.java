package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.ReserveDTO;
import lk.ijse.spring.entity.Car;
import lk.ijse.spring.entity.Reserve;
import lk.ijse.spring.entity.ReserveDetails;
import lk.ijse.spring.entity.Schedule;
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
                    carRepo.carAvailableOrNot("YES",car.getCarId()) ;
                    driverRepo.updateDriverIfHeReleaseOrNot("NO", reserveDetails.getDriverId());

                    Schedule rd = new Schedule(
                            scheduleRepo.generateScheduleId(),
                            reserve.getPickUpDate(),
                            reserve.getPickUpTime(),
                            reserve.getReserveDate(),
                            reserve.getReturnTime(),
                            reserve.getPickUpVenue(),
                            reserve.getReturnVenue(),
                            car.getAvailableOrNot(),
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
    public int activeReservationPerDay(String active) {
        return reserveRepo.activeReservationPerDay(active);
    }
}
