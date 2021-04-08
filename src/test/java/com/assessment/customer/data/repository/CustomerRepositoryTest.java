package com.assessment.customer.data.repository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.assessment.customer.data.entity.Customers;



@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class CustomerRepositoryTest {
    
    @Autowired
    CustomerRepository customerRepository;
    
    Customers customers;
    
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

    }
    
    @Test
    public void findAllTest() {
	
	Customers result = customerRepository.save(customers);
	
	Assert.assertNotNull(customerRepository.findAll());
	Assert.assertEquals(customers.getName(), result.getName());
	Assert.assertEquals(customers.getUrl(), result.getUrl());
	
    }

}
