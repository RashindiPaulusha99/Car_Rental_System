package lk.ijse.spring.repo;

import lk.ijse.spring.entity.RentPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RentPaymentRepo extends JpaRepository<RentPayment ,String> {

    @Query(value = "SELECT paymentId FROM RentPayment ORDER BY paymentId DESC LIMIT 1", nativeQuery = true)
    String generatePaymentId();

}
