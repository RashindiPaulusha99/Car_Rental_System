package lk.ijse.spring.controller;

import lk.ijse.spring.dto.ReserveDTO;
import lk.ijse.spring.service.ReserveService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("reserve")
@CrossOrigin
public class ReserveController {

    @Autowired
    ReserveService reserveService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllReservations(){
        return new ResponseUtil(200,"Ok",reserveService.getAllReservations());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveReservation(@RequestBody ReserveDTO reserveDTO){
        reserveService.reservationCars(reserveDTO);
        return new ResponseUtil(200, "Reserved Successfully.",null);
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchReservation(@PathVariable String id){
        return new ResponseUtil(200, "Ok.",reserveService.searchReservation(id));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateReservation(@RequestBody ReserveDTO reserveDTO){
        reserveService.updateReservation(reserveDTO);
        return new ResponseUtil(200, "Reservation Updated.",null);
    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteReservation(@RequestParam String id){
        reserveService.deleteReservation(id);
        return new ResponseUtil(200, "Reservation Deleted.", null);
    }

    @GetMapping(params = {"test"})
    public ResponseUtil generateReserveId(@RequestParam String test) {
        return new ResponseUtil(200, "Ok", reserveService.generateReserveId());
    }

    @GetMapping(path ="/COUNT/{countall}")
    public ResponseUtil countAllReservation(@PathVariable String countall){
        return new ResponseUtil(200, "Ök", reserveService.countAllReservation());
    }

    @GetMapping(path ="/COUNT/{countdaily}")
    public ResponseUtil countDailyReservation(@PathVariable String countdaily){
        return new ResponseUtil(200, "Ök", reserveService.countDailyReservation(countdaily));
    }

    @GetMapping(path ="/COUNT/{countactive}")
    public ResponseUtil activeReservationPerDay(@PathVariable String countactive){
        return new ResponseUtil(200, "Ök", reserveService.activeReservationPerDay(countactive));
    }

}
