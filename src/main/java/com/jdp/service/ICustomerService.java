package com.jdp.service;

import com.jdp.domain.Customer;

import java.util.List;

public interface ICustomerService {
    public Customer saveCustomerDetails(Customer customer);

    public List<Customer> fetchAllCustomerDetails();

    public boolean deleteCustomerDetail(int customerId);

    public List<Customer> fetchCustomerByProductName(String productName);
}
