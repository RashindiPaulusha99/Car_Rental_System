package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.service.CustomerService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveCustomer(@RequestBody CustomerDTO cusDto){
        customerService.saveCustomer(cusDto);
        return new ResponseUtil(200, "Successfully Registered.",null);
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchCustomer(@PathVariable String id){
        return new ResponseUtil(200, "Ok.",customerService.searchCustomer(id));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO cusDto){
        customerService.updateCustomer(cusDto);
        return new ResponseUtil(200, "Successfully Updated.",null);
    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteCustomer(@RequestParam String id){
        customerService.deleteCustomer(id);
        return new ResponseUtil(200, "Successfully Deleted.", null);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllCustomer(){
        return new ResponseUtil(200, "Ok", customerService.getAllCustomers());
    }

    @GetMapping(params = {"test"})
    public ResponseUtil generateCustomersIds(@RequestParam String test) {
        return new ResponseUtil(200, "Ok", customerService.generateCustomerIds());
    }

    @GetMapping(path ="/COUNT/{count}")
    public ResponseUtil countCustomers(@PathVariable String count){
        return new ResponseUtil(200, "Ök", customerService.countRegisteredCustomers());
    }

    @GetMapping(path ="/COUNT/{date}")
    public ResponseUtil countDailyRegisteredCustomers(@PathVariable String date){
        return new ResponseUtil(200, "Ök", customerService.countDailyRegisteredCustomers(date));
    }

    @GetMapping(path = "/USER/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchUserFromCustomer(@PathVariable("id") String id){
        return new ResponseUtil(200, "Ok.",customerService.searchUserFromCustomer(id));
    }

}
