package lk.ijse.spring.service;

import lk.ijse.spring.dto.RentPaymentDTO;

import java.util.List;

public interface RentPaymentService {

    void savePayment(RentPaymentDTO paymentDTO);

    void updatePayment(RentPaymentDTO paymentDTO);

    void deletePayment(String id);

    RentPaymentDTO searchPayment(String id);

    List<RentPaymentDTO> getAllPayments();

    String generatePaymentIds();

}
