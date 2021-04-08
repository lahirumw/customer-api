package com.assessment.customer;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.assessment.customer.controller.CustomerControllerTest;
import com.assessment.customer.controller.HealthControllerTest;
import com.assessment.customer.data.repository.CustomerRepositoryTest;
import com.assessment.customer.interceptor.AccessLogInterceptorTest;
import com.assessment.customer.interceptor.CorrelationIdInterceptorTest;
import com.assessment.customer.service.CustomerServiceTest;

/**
 * Unit Test Suit
 * 
 * @author lahiru
 */
@RunWith(Suite.class)
@SuiteClasses({ HealthControllerTest.class, CustomerServiceTest.class, CustomerControllerTest.class,
    CustomerRepositoryTest.class, AccessLogInterceptorTest.class, CorrelationIdInterceptorTest.class })
public class CustomerApiTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerApiTest.class);

    @BeforeClass
    public static void startup() {
	LOGGER.info("UNIT TEST STARTING UP");
    }

    @AfterClass
    public static void tearDown() {
	LOGGER.info("UNIT TEST COMPLETION");
    }

}
