package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DriverRepo extends JpaRepository<Driver, String> {

    @Query(value = "SELECT driverId FROM Driver ORDER BY driverId DESC LIMIT 1", nativeQuery = true)
    String generateDriverId();

    @Query(value = "UPDATE Driver SET releaseOrNot=:release WHERE driverId=:driverId", nativeQuery = true)
    void updateDriverIfHeReleaseOrNot(@Param("release") String release, @Param("driverId") String driverId);

    @Query(value = "SELECT driverId FROM Driver WHERE releaseOrNot=:NO ORDER BY driverId DESC LIMIT 1", nativeQuery = true)
    String assignRandomlyDriver(@Param("NO") String NO);

    @Query(value = "SELECT COUNT(*) FROM Driver WHERE releaseOrNot=:NO", nativeQuery = true)
    int availableDriversOrOccupiedDrivers(@Param("NO") String NO);

}
