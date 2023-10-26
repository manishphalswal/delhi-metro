package com.transport.delhi.metro;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(
title = "Delhi Metro Service",
		description = "This service provide the endpoints to perform booking, calculate fare and get route information in Delhi metro",
		version = "1.0"
),
servers = {@Server(url = "/")}
)
@SpringBootApplication
public class DelhiMetroApplication {

	public static void main(String[] args) {
		SpringApplication.run(DelhiMetroApplication.class, args);
	}

}
