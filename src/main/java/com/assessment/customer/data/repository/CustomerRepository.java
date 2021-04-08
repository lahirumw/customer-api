package com.assessment.customer.data.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assessment.customer.data.entity.Customers;

@Repository
public interface CustomerRepository extends CrudRepository<Customers, Long> {

    Slice<Customers> findByNameContainingIgnoreCase(String name, Pageable page);
    
    Slice<Customers> findAll(Pageable page);
}
