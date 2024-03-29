package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReserveRepo extends JpaRepository<Reserve, String> {

    @Query(value = "SELECT reserveId FROM Reserve ORDER BY reserveId DESC LIMIT 1", nativeQuery = true)
    String generateReserveId();

    @Query(value = "SELECT COUNT(*) FROM Reserve", nativeQuery = true)
    int countAllReservation();

    @Query(value = "SELECT COUNT(*) FROM Reserve WHERE reserveDate=:date", nativeQuery = true)
    int countDailyReservation(@Param("date") String date);

    @Query(value = "SELECT COUNT(*) FROM Reserve WHERE requestAcceptOrDeny=:accept AND reserveDate=:date", nativeQuery = true)
    int activeReservationPerDay(@Param("date") String date, @Param("accept") String accept);

    @Query(value = "UPDATE ReserveDetails SET driverId=:driverId WHERE reserveId=:reserveId AND carId=:carId", nativeQuery = true)
    void updateDriverId(@Param("driverId") String driverId, @Param("reserveId") String reserveId, @Param("carId") String carId);

    @Query(value = "UPDATE ReserveDetails SET driverId=:driverId, driverName=:driverName, driverContact =:driverContact  WHERE reserveId=:reserveId", nativeQuery = true)
    void updateDriverDetails(@Param("driverId") String driverId, @Param("driverName") String driverName,@Param("driverContact") String driverContact, @Param("reserveId") String reserveId);



}
