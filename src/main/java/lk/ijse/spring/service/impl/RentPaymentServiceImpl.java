package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.RentPaymentDTO;
import lk.ijse.spring.entity.RentPayment;
import lk.ijse.spring.repo.RentPaymentRepo;
import lk.ijse.spring.service.RentPaymentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RentPaymentServiceImpl implements RentPaymentService {

    @Autowired
    RentPaymentRepo rentPaymentRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void savePayment(RentPaymentDTO paymentDTO) {
        if (!rentPaymentRepo.existsById(paymentDTO.getPaymentId())){
            rentPaymentRepo.save(mapper.map(paymentDTO, RentPayment.class));
        }else {
            throw new RuntimeException(paymentDTO.getPaymentId() + " " + "Payment Already Exists..!");
        }
    }

    @Override
    public void updatePayment(RentPaymentDTO paymentDTO) {
        if (rentPaymentRepo.existsById(paymentDTO.getPaymentId())){
            rentPaymentRepo.save(mapper.map(paymentDTO, RentPayment.class));
        }else {
            throw new RuntimeException(paymentDTO.getPaymentId() + " " + "No Such Payment..! Please Check The Correct Id..!");
        }
    }

    @Override
    public void deletePayment(String id) {
        if (rentPaymentRepo.existsById(id)){
            rentPaymentRepo.deleteById(id);
        }else {
            throw new RuntimeException(id + " " + "No Such Payment..! Please Check The Correct Id..!");
        }
    }

    @Override
    public RentPaymentDTO searchPayment(String id) {
        if (rentPaymentRepo.existsById(id)){
            RentPayment rentPayment = rentPaymentRepo.findById(id).get();
            return mapper.map(rentPayment, RentPaymentDTO.class);
        }else {
            throw new RuntimeException(id + " " + "No Such Payment..! Please Check The Id..!");
        }
    }

    @Override
    public List<RentPaymentDTO> getAllPayments() {
        List<RentPayment> all = rentPaymentRepo.findAll();
        return mapper.map(all, new TypeToken<List<RentPaymentDTO>>(){
        }.getType());
    }

    @Override
    public String generatePaymentIds() {
        return rentPaymentRepo.generatePaymentId();
    }

    @Override
    public Double dailyIncome(String date) {
        return rentPaymentRepo.dailyIncome(date);
    }

    @Override
    public Double calculateIncome(String firstdate, String lastdate) {
        return rentPaymentRepo.calculateIncome(firstdate,lastdate);
    }
}
