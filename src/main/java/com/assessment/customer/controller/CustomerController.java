package com.assessment.customer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.customer.data.entity.Customers;
import com.assessment.customer.service.CustomerService;

/**
 * 
 * @author lahirua
 *
 */
@RestController
@RequestMapping("/v1/customers")
public class CustomerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
    
    @Autowired
    private CustomerService customerService;
    
    /**
     * Get Customer Details.
     * 
     * @param name:
     *            Customer Name
     */
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public Slice<Customers> get(@RequestParam(value = "name", required = false) String name,
		@RequestParam(value = "page", required = false, defaultValue = "0") int page,
		@RequestParam(value = "size", required = false, defaultValue = "10") int size) {

	LOGGER.info("GET Customer by Name: {} ", name);
	
	Pageable paging = PageRequest.of(page, size);
	
	return customerService.getCustomer(name, paging);

    }
}
