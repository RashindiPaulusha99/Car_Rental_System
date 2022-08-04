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
    public ResponseUtil searchCar(@PathVariable("id") String id){
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

    @GetMapping(path = "/AVAILABLECOUNT/{availableCount}")
    public ResponseUtil noOfAvailableOrReservedCars(@PathVariable("availableCount") String availableCount) {
        return new ResponseUtil(200, "Ok", carService.noOfAvailableOrReservedCars(availableCount));
    }

    @GetMapping(path = "/COUNTM/{maintain}")
    public ResponseUtil needMaintenanceOrUnderMaintenanceCars(@PathVariable("maintain") String maintain) {
        return new ResponseUtil(200, "Ok", carService.needMaintenanceOrUnderMaintenanceCars(maintain));
    }

    @GetMapping(path = "/CALCULATE/{distance}/{carId}")
    public ResponseUtil calculateKmUntil5000km(@PathVariable("distance") String distance, @PathVariable("carId") String carId ) {
        return new ResponseUtil(200, "Ok", carService.calculateKmUntil5000km(distance,carId));
    }

    @GetMapping(path = "/TYPETR/{tratype}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil findByTransmissionType(@PathVariable("tratype") String tratype) {
        return new ResponseUtil(200, "Ok", carService.findByTransmissionType(tratype));
    }

    @GetMapping(path = "/TYPEB/{brand}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil findByBrand(@PathVariable("brand") String brand) {
        return new ResponseUtil(200, "Ok", carService.findByBrand(brand));
    }

    @GetMapping(path = "/TYPET/{type}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil findByType(@PathVariable("type") String type) {
        return new ResponseUtil(200, "Ok", carService.findByType(type));
    }

    @GetMapping(path = "/TYPEF/{ftype}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil findByFuelType(@PathVariable("ftype") String ftype) {
        return new ResponseUtil(200, "Ok", carService.findByFuelType(ftype));
    }

    @GetMapping(path = "/TYPEC/{colour}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil findByColour(@PathVariable("colour") String colour) {
        return new ResponseUtil(200, "Ok", carService.findByColour(colour));
    }

    @GetMapping(path = "/SORTPD/{passengersDsc}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil sortAccordingToPassengersByDescending(@PathVariable("passengersDsc") String passengersDsc ) {
        return new ResponseUtil(200, "Ok", carService.sortAccordingToPassengersByDescending());
    }

    @GetMapping(path = "/SORTPA/{passengersAsc}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil sortAccordingToPassengersByAscending(@PathVariable("passengersAsc") String passengersAsc) {
        return new ResponseUtil(200, "Ok", carService.sortAccordingToPassengersByAscending());
    }

    @GetMapping(path = "/SORTDD/{dailyRatePriceDsc}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil sortAccordingToDailyRatePriceByDescending(@PathVariable("dailyRatePriceDsc") String dailyRatePriceDsc) {
        return new ResponseUtil(200, "Ok", carService.sortAccordingToDailyRatePriceByDescending());
    }

    @GetMapping(path = "/SORTDA/{dailyRatePriceAsc}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil sortAccordingToDailyRatePriceByAscending(@PathVariable("dailyRatePriceAsc") String dailyRatePriceAsc) {
        return new ResponseUtil(200, "Ok", carService.sortAccordingToDailyRatePriceByAscending());
    }

    @GetMapping(path = "/SORTMA/{monthlyRatePriceAsc}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil sortAccordingToMonthlyRatePriceByAscending(@PathVariable("monthlyRatePriceAsc") String monthlyRatePriceAsc) {
        return new ResponseUtil(200, "Ok", carService.sortAccordingToMonthlyRatePriceByAscending());
    }

    @GetMapping(path = "/SORTMD/{monthlyRatePriceDsc}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil sortAccordingToMonthlyRatePriceByDescending(@PathVariable("monthlyRatePriceDsc") String monthlyRatePriceDsc) {
        return new ResponseUtil(200, "Ok", carService.sortAccordingToMonthlyRatePriceByDescending());
    }

    @GetMapping(path = "/AVAILABLE/{available}/{carId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil carAvailableOrNot(@PathVariable("available") String available, @PathVariable("carId") String carId) {
        carService.carAvailableOrNot(available,carId);
        return new ResponseUtil(200, "Ok", null);
    }

    @GetMapping(path = "/SEARCH/{reg}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchRegNumberIsDuplicate(@PathVariable("reg") String reg){
        return new ResponseUtil(200, "Ok", carService.searchRegNumberIsDuplicate(reg));
    }


}
