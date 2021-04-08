package com.assessment.customer.domain;

/**
 * The response class for the Health Route.
 * 
 * @author lahirua
 *
 */

public class HealthCheckResponse {

    private String name;

    private String version;

    private String environment;

    public String getEnvironment() {
	return environment;
    }

    public void setEnvironment(String environment) {
	this.environment = environment;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getVersion() {
	return version;
    }

    public void setVersion(String version) {
	this.version = version;
    }

}
