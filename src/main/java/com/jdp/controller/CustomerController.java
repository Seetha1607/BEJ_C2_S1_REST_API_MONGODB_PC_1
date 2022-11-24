/*
 *Author Name : Seetha Lakshmi.G.M
 *Date : 24-11-2022
 *Created With : IntelliJ IDEA Community Edition
 */


package com.jdp.controller;

import com.jdp.domain.Customer;
import com.jdp.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {
    private ICustomerService iCustomerService;

    @Autowired
    public CustomerController(ICustomerService iCustomerService) {
        this.iCustomerService = iCustomerService;
    }

    @PostMapping("/saveCustomerDetails")
    public ResponseEntity<?> saveCustomerDetails(@RequestBody Customer customer) {
        return new ResponseEntity<>(iCustomerService.saveCustomerDetails(customer), HttpStatus.CREATED);
    }

    @GetMapping("/fetchCustomerDetails")
    public ResponseEntity<?> fetchCustomerDetails() {
        return new ResponseEntity<>(iCustomerService.fetchAllCustomerDetails(), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteCustomer/{customerId}")
    public ResponseEntity<?> deleteCustomer(@PathVariable int customerId) {
        return new ResponseEntity<>(iCustomerService.deleteCustomerDetail(customerId), HttpStatus.OK);
    }
}
