package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Admin;
import lk.ijse.spring.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepo extends JpaRepository<Admin, String> {

    @Query(value = "SELECT adminId FROM Admin ORDER BY adminId DESC LIMIT 1", nativeQuery = true)
    String generateAdminId();


}
