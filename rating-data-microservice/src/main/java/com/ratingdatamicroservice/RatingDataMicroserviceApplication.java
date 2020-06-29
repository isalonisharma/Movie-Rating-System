package com.ratingdatamicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class RatingDataMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatingDataMicroserviceApplication.class, args);
	}

}
