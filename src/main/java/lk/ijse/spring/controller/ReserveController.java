package lk.ijse.spring.controller;

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
    public ResponseUtil getAllOrders(){
        return new ResponseUtil(200,"Ok",placeOrderService.getAllOrders());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveOrder(@RequestBody OrderDTO orderDTO){
        placeOrderService.placeOrder(orderDTO);
        return new ResponseUtil(200, "Successfully Purchased Order.",null);
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchOrder(@PathVariable String id){
        System.out.println(id);
        return new ResponseUtil(200, "Ok.",placeOrderService.searchOrder(id));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateOrder(@RequestBody OrderDTO orderDTO){
        placeOrderService.updateOrder(orderDTO);
        return new ResponseUtil(200, "Order Successfully Updated.",null);
    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteOrder(@RequestParam String id){
        placeOrderService.deleteOrder(id);
        return new ResponseUtil(200, "Order Successfully Deleted.", null);
    }

    @GetMapping(params = {"test"})
    public ResponseUtil generateOrderId(@RequestParam String test) {
        return new ResponseUtil(200, "Ok", placeOrderService.generateOrderId());
    }

    @GetMapping(path ="/COUNT/{count}")
    public ResponseUtil countOrders(@PathVariable String count){
        return new ResponseUtil(200, "Ök", placeOrderService.countOrders());
    }

    @GetMapping(path = "/INCOME/{income}")
    public ResponseUtil calculateIncome(@PathVariable String income){
        return new ResponseUtil(200, "Ok", placeOrderService.calculateIncome());
    }


}
