package com.assessment.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import com.assessment.customer.data.entity.Customers;
import com.assessment.customer.data.repository.CustomerRepository;

/**
 * 
 * @author lahirua
 *
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * 
     * @param name
     * @param paging
     * @return
     */
    public Slice<Customers> getCustomer(String name, Pageable paging) {

	if (name != null) {
	    return customerRepository.findByNameContaining(name, paging);
	}
	else {
	    return customerRepository.findAll(paging);
	}
    }
}
