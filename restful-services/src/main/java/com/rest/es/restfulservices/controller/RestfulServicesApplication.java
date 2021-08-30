package com.rest.es.restfulservices.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.rest.*")
public class RestfulServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulServicesApplication.class, args);
	}

}
