/*
 *Author Name : Seetha Lakshmi.G.M
 *Date : 24-11-2022
 *Created With : IntelliJ IDEA Community Edition
 */


package com.jdp.service;

import com.jdp.domain.Customer;
import com.jdp.exception.CustomerExistsAlready;
import com.jdp.exception.CustomerNotExists;
import com.jdp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {

    private CustomerRepository customerRepository;

    // A spring annotation that is used to inject the dependency.
    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    // Saving the customer details.
    public Customer saveCustomerDetails(Customer customer) throws CustomerExistsAlready {
        if (customerRepository.findById(customer.getCustomerId()).isPresent()) {
            throw new CustomerExistsAlready();
        }
        return customerRepository.save(customer);
    }

    @Override
    // Fetching all the customer details.
    public List<Customer> fetchAllCustomerDetails() {
        return customerRepository.findAll();
    }

    @Override
    // Deleting the customer details.
    public boolean deleteCustomerDetail(int customerId) throws CustomerNotExists {
        if (customerRepository.findById(customerId).isEmpty()) {
            throw new CustomerNotExists();
        }
        customerRepository.deleteById(customerId);
        return true;
    }

    @Override
    // Fetching the customer details by product name.
    public List<Customer> fetchCustomerByProductName(String productName) {
        return customerRepository.findByProductName(productName);
    }
}
