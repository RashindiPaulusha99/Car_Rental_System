package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.service.CarService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("car")
@CrossOrigin
public class CarController {

    @Autowired
    CarService carService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveCar(@RequestBody CarDTO carDTO){
        carService.saveCar(carDTO);
        return new ResponseUtil(200, "Successfully Saved.",null);
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchCar(@PathVariable String id){
        return new ResponseUtil(200, "Ok.",carService.searchCar(id));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateCar(@RequestBody CarDTO carDTO){
        carService.updateCar(carDTO);
        return new ResponseUtil(200, "Successfully Updated.",null);
    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteCar(@RequestParam String id){
        carService.deleteCar(id);
        return new ResponseUtil(200, "Successfully Deleted.", null);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllCar(){
        return new ResponseUtil(200, "Ok", carService.getAllCars());
    }

    @GetMapping(params = {"test"})
    public ResponseUtil generateCarIds(@RequestParam String test) {
        return new ResponseUtil(200, "Ok", carService.generateCarIds());
    }

    @GetMapping(path = "/COUNT/{available}")
    public ResponseUtil NoOfAvailableOrReservedCars(@PathVariable String available) {
        return new ResponseUtil(200, "Ok", carService.NoOfAvailableOrReservedCars(available));
    }

    @GetMapping(path = "/COUNT/{maintain}")
    public ResponseUtil needMaintenanceOrUnderMaintenanceCars(@PathVariable String maintain) {
        return new ResponseUtil(200, "Ok", carService.needMaintenanceOrUnderMaintenanceCars(maintain));
    }

    @GetMapping(path = "{distance}/{carId}")
    public ResponseUtil calculateKmUntil5000km(@PathVariable String distance, @PathVariable String carId ) {
        return new ResponseUtil(200, "Ok", carService.calculateKmUntil5000km(distance,carId));
    }

    @GetMapping(path = "/TYPE/{tratype}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil findByTransmissionType(@PathVariable String tratype) {
        return new ResponseUtil(200, "Ok", carService.findByTransmissionType(tratype));
    }

    @GetMapping(path = "/TYPE/{brand}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil findByBrand(@PathVariable String brand) {
        return new ResponseUtil(200, "Ok", carService.findByBrand(brand));
    }

    @GetMapping(path = "/TYPE/{type}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil findByType(@PathVariable String type) {
        return new ResponseUtil(200, "Ok", carService.findByType(type));
    }

    @GetMapping(path = "/TYPE/{ftype}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil findByFuelType(@PathVariable String ftype) {
        return new ResponseUtil(200, "Ok", carService.findByFuelType(ftype));
    }

    @GetMapping(path = "/SORT/{passengersDsc}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil sortAccordingToPassengersByDescending() {
        return new ResponseUtil(200, "Ok", carService.sortAccordingToPassengersByDescending());
    }

    @GetMapping(path = "/SORT/{passengersAsc}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil sortAccordingToPassengersByAscending() {
        return new ResponseUtil(200, "Ok", carService.sortAccordingToPassengersByAscending());
    }

    @GetMapping(path = "/SORT/{dailyRatePriceDsc}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil sortAccordingToDailyRatePriceByDescending() {
        return new ResponseUtil(200, "Ok", carService.sortAccordingToDailyRatePriceByDescending());
    }

    @GetMapping(path = "/SORT/{dailyRatePriceAsc}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil sortAccordingToDailyRatePriceByAscending() {
        return new ResponseUtil(200, "Ok", carService.sortAccordingToDailyRatePriceByAscending());
    }

    @GetMapping(path = "/SORT/{monthlyRatePriceAsc}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil sortAccordingToMonthlyRatePriceByAscending() {
        return new ResponseUtil(200, "Ok", carService.sortAccordingToMonthlyRatePriceByAscending());
    }

    @GetMapping(path = "/SORT/{monthlyRatePriceDsc}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil sortAccordingToMonthlyRatePriceByDescending() {
        return new ResponseUtil(200, "Ok", carService.sortAccordingToMonthlyRatePriceByDescending());
    }

    @GetMapping(path = "{available}/{carId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil carAvailableOrNot(@PathVariable String available, @PathVariable String carId) {
        return new ResponseUtil(200, "Ok", carService.carAvailableOrNot(available,carId));
    }

}
