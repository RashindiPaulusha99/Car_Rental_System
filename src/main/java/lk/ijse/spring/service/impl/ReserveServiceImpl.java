package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.ReserveDTO;
import lk.ijse.spring.entity.Reserve;
import lk.ijse.spring.repo.CarRepo;
import lk.ijse.spring.repo.ReserveDetailsRepo;
import lk.ijse.spring.repo.ReserveRepo;
import lk.ijse.spring.service.ReserveService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private ModelMapper modelMapper;

    @Override
    public void reservationCars(ReserveDTO reserveDTO) {
        Reserve reserve = modelMapper.map(reserveDTO, Reserve.class);
        if (!reserveRepo.existsById(reserveDTO.getReserveId())){

            if (reserveDTO.getReserveDetails().size() < 1){
                throw new RuntimeException("No Cars In Reservation..!");
            }else {
                reserveRepo.save(reserve);

                /*for (ReserveDetails reserveDetails : reserve.getReserveDetails()) {
                    Car car = carRepo.findById(reserveDetails.getCarId()).get();
                }*/
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
    public int countDailyReservation() {
        return reserveRepo.countDailyReservation();
    }

    @Override
    public int activeReservationPerDay() {
        return reserveRepo.activeReservationPerDay();
    }
}
