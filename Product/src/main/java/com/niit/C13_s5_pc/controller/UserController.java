package com.niit.C13_s5_pc.controller;


import com.niit.C13_s5_pc.domain.User;
import com.niit.C13_s5_pc.exception.CustomerAlreadyExistException;
import com.niit.C13_s5_pc.exception.CustomerNotFoundException;
import com.niit.C13_s5_pc.service.ICustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class CustomerController {

    ICustomerService customerService;

    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/user")
    public ResponseEntity<?> addCustomer(@RequestBody User user){
        try {
            return new ResponseEntity<>(customerService.addCustomer(user), HttpStatus.CREATED);
        } catch (CustomerAlreadyExistException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/customer")
    public ResponseEntity<?> getAllCustomer(){
        return new ResponseEntity<>(customerService.getAllCustomer(),HttpStatus.CREATED);
    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity<?> deleteCustomerById(@PathVariable int id){
        try {
            return new ResponseEntity<>(customerService.deleteCustomer(id),HttpStatus.OK);
        } catch (CustomerNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/customers/{product}")
    public ResponseEntity<?> getCustomerBySamsungPhone(@PathVariable String product){
        return new ResponseEntity<>(customerService.getCustomerWhoBougthSamsungPhone(product),HttpStatus.OK);
    }

}
