package com.jdp.service;

import com.jdp.domain.Customer;
import com.jdp.exception.CustomerExistsAlready;
import com.jdp.exception.CustomerNotExists;

import java.util.List;

public interface ICustomerService {
    /**
     * This function saves the customer details and throws an exception if the customer already exists.
     *
     * @param customer This is the customer object that you want to save.
     * @return Customer
     */
    public Customer saveCustomerDetails(Customer customer) throws CustomerExistsAlready;

    // Fetching all the customer details.
    public List<Customer> fetchAllCustomerDetails();

    // Deleting the customer details.
    public boolean deleteCustomerDetail(int customerId) throws CustomerNotExists;

    // Fetching the customer details by product name.
    public List<Customer> fetchCustomerByProductName(String productName);
}
