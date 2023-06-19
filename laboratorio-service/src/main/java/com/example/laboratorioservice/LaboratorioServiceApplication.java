package com.example.laboratorioservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LaboratorioServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LaboratorioServiceApplication.class, args);
	}

}
