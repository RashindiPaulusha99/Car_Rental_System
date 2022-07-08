package lk.ijse.spring.repo;

import lk.ijse.spring.entity.RentPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RentPaymentRepo extends JpaRepository<RentPayment ,String> {

    @Query(value = "SELECT paymentId FROM RentPayment ORDER BY paymentId DESC LIMIT 1", nativeQuery = true)
    String generatePaymentId();

    @Query(value = "SELECT SUM(fullPayment) FROM RentPayment WHERE paymentDate=:date", nativeQuery = true)
    Double dailyIncome(@Param("date") String date);

    @Query(value = "SELECT SUM(fullPayment) FROM RentPayment WHERE paymentDate BETWEEN =:firstdate  AND =:lastdate", nativeQuery = true)
    Double calculateIncome(@Param("firstdate") String firstdate, @Param("lastdate") String lastdate);

}
