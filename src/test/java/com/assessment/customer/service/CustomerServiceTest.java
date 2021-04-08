package com.assessment.customer.service;

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
import com.assessment.customer.data.repository.CustomerRepository;

/**
 * 
 * @author lahirua
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerServiceTest {

    @InjectMocks
    CustomerService customerService = new CustomerService();

    @Mock
    CustomerRepository customerRepository;
    
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
    public void testGetWithoutName() {

	List<Customers> list = new ArrayList<Customers>();
	list.add(customers);
	Slice<Customers> content = new SliceImpl<>(list, paging, false);
	
	Mockito.when(customerRepository.findAll(Mockito.any(Pageable.class))).thenReturn(content);

	Slice<Customers> result = customerService.getCustomer(null, paging);

	Assert.assertNotNull(result);
	Assert.assertEquals(content, result);
    }

    @Test
    public void testGetWithName() {

	List<Customers> list = new ArrayList<Customers>();
	list.add(customers);
	Slice<Customers> content = new SliceImpl<>(list, paging, false);
	System.out.println(content);
	Mockito.when(customerRepository.findByNameContainingIgnoreCase(Mockito.anyString(), Mockito.any(Pageable.class)))
		.thenReturn(content);

	Slice<Customers> result = customerService.getCustomer("Homer Simpson", paging);

	Assert.assertNotNull(result);
	Assert.assertEquals(content, result);

    }
}
