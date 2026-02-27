package com.example.swagger3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
@OpenAPIDefinition(info = @Info(title = "Employees API", version = "2.0", description = "Employees Information"))
@SpringBootApplication
public class Swagger3Application {

	public static void main(String[] args) {
		SpringApplication.run(Swagger3Application.class, args);
	}

}
