package com.assessment.customer.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.assessment.customer.data.entity.Customers;
import com.assessment.customer.service.CustomerService;

/**
 * 
 * @author lahirua
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerControllerTest {

    @InjectMocks
    CustomerController customerController = new CustomerController();
    
    @Mock
    CustomerService customerService;
    
    
    Customers customers;
    Pageable paging;
    
    /**
     * Process before executing tests.
     * 
     * @throws Exception
     */
    @Before
    public void setup() throws Exception {
	customers = new Customers();
	customers.setId(new Long(1000));
	customers.setName("Homer Simpson");
	customers.setUrl(
		"https://vignette.wikia.nocookie.net/simpsons/images/b/bd/Homer_Simpson.png/revision/latest/scale-to-width-down/72?cb=20140126234206");

	paging = PageRequest.of(1, 10);
    }
    
    @Test
    public void testGet() {
	List<Customers> list = new ArrayList<Customers>();
	list.add(customers);
	Slice<Customers> content = new SliceImpl<>(list, paging, false);
	
	Mockito.when(customerService.getCustomer(Mockito.anyString(), Mockito.any(Pageable.class))).thenReturn(content);
    
	Slice<Customers> result = customerController.get("Homer Simpson", 0, 5);
	
	Assert.assertNotNull(result);
	Assert.assertEquals(content, result);
    }
}
