package lk.ijse.spring.controller;

import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.service.DriverService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("driver")
@CrossOrigin
public class DriverController {

    @Autowired
    DriverService driverService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveDriver(@RequestBody DriverDTO driverDTO){
        driverService.saveDriver(driverDTO);
        return new ResponseUtil(200, "Successfully Saved.",null);
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchDriver(@PathVariable String id){
        return new ResponseUtil(200, "Ok.",driverService.searchDriver(id));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateDriver(@RequestBody DriverDTO driverDTO){
        driverService.updateDriver(driverDTO);
        return new ResponseUtil(200, "Successfully Updated.",null);
    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteDriver(@RequestParam String id){
        driverService.deleteDriver(id);
        return new ResponseUtil(200, "Successfully Deleted.", null);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllDrivers(){
        return new ResponseUtil(200, "Ok", driverService.getAllDrivers());
    }

    @GetMapping(params = {"test"})
    public ResponseUtil generateDriverIds(@RequestParam String test) {
        return new ResponseUtil(200, "Ok", driverService.generateDriverIds());
    }

    @GetMapping(path = "{release}/{driverId}")
    public ResponseUtil updateDriverIfHeReleaseOrNot(@PathVariable("release") String release, @PathVariable("driverId") String driverId ) {
        driverService.updateDriverIfHeReleaseOrNot(release,driverId);
        return new ResponseUtil(200, "Ok", null);
    }

    @GetMapping(path = "/ASSIGN/{release}")
    public ResponseUtil assignRandomlyDriver(@PathVariable("release") String release) {
        return new ResponseUtil(200, "Ok", driverService.assignRandomlyDriver(release));
    }

    @GetMapping(path = "/AVAILABLE/{release}")
    public ResponseUtil availableDriversOrOccupiedDrivers(@PathVariable("release") String release) {
        return new ResponseUtil(200, "Ok", driverService.availableDriversOrOccupiedDrivers(release));
    }

    @GetMapping(path = "/USER/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchUserFromDriver(@PathVariable("id") String id){
        return new ResponseUtil(200, "Ok.",driverService.searchUserFromDriver(id));
    }

    @GetMapping(path = "/RELEASE/{release}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchAvailableDriversOrOccupiedDrivers(@PathVariable("release") String release){
        return new ResponseUtil(200, "Ok.",driverService.searchAvailableDriversOrOccupiedDrivers(release));
    }

}
