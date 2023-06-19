package com.example.acopiosservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AcopiosServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcopiosServiceApplication.class, args);
	}

}
