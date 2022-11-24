/*
 *Author Name : Seetha Lakshmi.G.M
 *Date : 24-11-2022
 *Created With : IntelliJ IDEA Community Edition
 */


package com.jdp.service;

import com.jdp.domain.Customer;
import com.jdp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer saveCustomerDetails(Customer customer) {
        return null;
    }

    @Override
    public List<Customer> fetchAllCustomerDetails() {
        return null;
    }

    @Override
    public boolean deleteCustomerDetail(int customerId) {
        return false;
    }
}
