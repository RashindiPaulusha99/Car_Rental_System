package lk.ijse.spring.controller;

import lk.ijse.spring.dto.RentPaymentDTO;
import lk.ijse.spring.service.RentPaymentService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("payment")
@CrossOrigin
public class RentPaymentController {

    @Autowired
    RentPaymentService rentPaymentService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil savePayment(@ModelAttribute RentPaymentDTO rentPaymentDTO){
        rentPaymentService.savePayment(rentPaymentDTO);
        return new ResponseUtil(200, "Successfully Saved.",null);
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchPayment(@PathVariable String id){
        return new ResponseUtil(200, "Ok.",rentPaymentService.searchPayment(id));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updatePayment(@RequestBody RentPaymentDTO rentPaymentDTO){
        rentPaymentService.updatePayment(rentPaymentDTO);
        return new ResponseUtil(200, "Successfully Updated.",null);
    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deletePayment(@RequestParam String id){
        rentPaymentService.deletePayment(id);
        return new ResponseUtil(200, "Successfully Deleted.", null);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllPayments(){
        return new ResponseUtil(200, "Ok", rentPaymentService.getAllPayments());
    }

    @GetMapping(params = {"test"})
    public ResponseUtil generatePaymentIds(@RequestParam String test) {
        return new ResponseUtil(200, "Ok", rentPaymentService.generatePaymentIds());
    }

    @GetMapping(path = "/INCOME/{date}")
    public ResponseUtil dailyIncome(@PathVariable String date) {
        return new ResponseUtil(200, "Ok", rentPaymentService.dailyIncome(date));
    }

    @GetMapping(path = "/{firstdate}/{lastdate}")
    public ResponseUtil calculateIncome(@PathVariable String firstdate, @PathVariable String lastdate) {
        return new ResponseUtil(200, "Ok", rentPaymentService.calculateIncome(firstdate,lastdate));
    }

}
