package com.assessment.customer.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.assessment.customer.domain.HealthCheckResponse;

/**
 * Test for {@link HealthController}.
 * 
 * @author Lahirua
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class HealthControllerTest {

    private HealthController healthController = new HealthController();

    @Before
    public void init() throws Exception {

	ReflectionTestUtils.setField(healthController, "version", "1.0.0");
	ReflectionTestUtils.setField(healthController, "environment", "TEST");
    }

    @Test
    public void testGetHealth() {
	HealthCheckResponse result = healthController.getHealth();
	Assert.assertNotNull(result);
	Assert.assertEquals("1.0.0", result.getVersion());
	Assert.assertEquals("TEST", result.getEnvironment());
    }

}
