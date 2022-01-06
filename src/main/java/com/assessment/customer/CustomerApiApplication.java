package com.assessment.customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

/**
 * 
 * @author lahirua
 *
 */
@SpringBootApplication(scanBasePackages = "com.assessment.customer")
@PropertySource(value = { "classpath:/application.properties", "classpath:${ENV:}/environment.properties" })
public class CustomerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerApiApplication.class, args);
	}

}
