/*
 *Author Name : Seetha Lakshmi.G.M
 *Date : 24-11-2022
 *Created With : IntelliJ IDEA Community Edition
 */


package com.jdp.controller;

import com.jdp.domain.Customer;
import com.jdp.exception.CustomerExistsAlready;
import com.jdp.exception.CustomerNotExists;
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
    public ResponseEntity<?> saveCustomerDetails(@RequestBody Customer customer) throws CustomerExistsAlready {
        try {
            return new ResponseEntity<>(iCustomerService.saveCustomerDetails(customer), HttpStatus.CREATED);
        } catch (CustomerExistsAlready e) {
            throw new CustomerExistsAlready();
        } catch (Exception e) {
            return new ResponseEntity<>("Server Error!!!try after Sometime", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/fetchCustomerDetails")
    public ResponseEntity<?> fetchCustomerDetails() {
        return new ResponseEntity<>(iCustomerService.fetchAllCustomerDetails(), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteCustomer/{customerId}")
    public ResponseEntity<?> deleteCustomer(@PathVariable int customerId) throws CustomerNotExists {
        try {
            return new ResponseEntity<>(iCustomerService.deleteCustomerDetail(customerId), HttpStatus.OK);
        } catch (CustomerNotExists e) {
            throw new CustomerNotExists();
        } catch (Exception e) {
            return new ResponseEntity<>("Server Error!!!try after Sometime", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/fetchCustomerByProductName/{productName}")
    public ResponseEntity<?> fetchCustomerByProductName(@PathVariable String productName) {
        return new ResponseEntity<>(iCustomerService.fetchCustomerByProductName(productName), HttpStatus.ACCEPTED);
    }
}
