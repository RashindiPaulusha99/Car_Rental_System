package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdminRepo extends JpaRepository<Admin, String> {

    @Query(value = "SELECT adminId FROM Admin ORDER BY adminId DESC LIMIT 1", nativeQuery = true)
    String generateAdminId();

    @Query(value = "SELECT * FROM Admin WHERE users_userId=:id", nativeQuery = true)
    Admin searchUserFromAdmin(@Param("id") String id);
}
