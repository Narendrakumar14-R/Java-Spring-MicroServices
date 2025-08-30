package com.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer

public class DcmServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DcmServiceApplication.class, args);
	}

}
