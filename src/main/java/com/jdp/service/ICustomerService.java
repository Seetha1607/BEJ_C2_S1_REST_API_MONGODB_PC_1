package com.jdp.service;

import com.jdp.domain.Customer;
import com.jdp.exception.CustomerExistsAlready;
import com.jdp.exception.CustomerNotExists;

import java.util.List;

public interface ICustomerService {
    public Customer saveCustomerDetails(Customer customer) throws CustomerExistsAlready;

    public List<Customer> fetchAllCustomerDetails();

    public boolean deleteCustomerDetail(int customerId) throws CustomerNotExists;

    public List<Customer> fetchCustomerByProductName(String productName);
}
