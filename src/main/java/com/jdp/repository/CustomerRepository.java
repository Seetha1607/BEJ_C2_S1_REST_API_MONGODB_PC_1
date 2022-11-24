package com.jdp.repository;

import com.jdp.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, Integer> {
    /**
     * Finds customers by product name
     *
     * @param productName The name of the product.
     * @return A list of customers.
     */
    @Query("{'customerProduct.productName':{$in:[?0]}}")
    // A method that finds customers by product name.
    List<Customer> findByProductName(String productName);
}
