package lk.ijse.spring.repo;

import lk.ijse.spring.entity.ReserveCars;
import lk.ijse.spring.entity.ReserveDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReserveDetailsRepo extends JpaRepository<ReserveDetails, ReserveCars> {

}
