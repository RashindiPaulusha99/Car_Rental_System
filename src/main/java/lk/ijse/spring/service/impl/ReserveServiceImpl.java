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

    }

    @Override
    public void deleteReservation(String rId) {

    }

    @Override
    public void updateReservation(ReserveDTO reserveDTO) {

    }

    @Override
    public ReserveDTO searchReservation(String rId) {
        return null;
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
