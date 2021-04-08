package com.assessment.customer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.customer.domain.HealthCheckResponse;

@RestController("healthController")
public class HealthController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HealthController.class);

    @Value("${application.version}")
    private String version;
    
    @Value("${ENV}")
    private String environment;

    @GetMapping(value = { "/health" })
    public HealthCheckResponse getHealth() {

	LOGGER.info("Health Controller: Health Route ");

	HealthCheckResponse response = new HealthCheckResponse();

	response.setName("Customer Service");
	response.setVersion(version);
	response.setEnvironment(environment);
	
	return response;
    }

}
