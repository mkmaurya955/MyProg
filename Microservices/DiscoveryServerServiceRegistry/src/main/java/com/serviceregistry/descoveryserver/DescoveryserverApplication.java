package com.serviceregistry.descoveryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DescoveryserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(DescoveryserverApplication.class, args);
	}

}
