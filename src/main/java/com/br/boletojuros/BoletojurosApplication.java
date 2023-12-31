package com.br.boletojuros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BoletojurosApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoletojurosApplication.class, args);
	}

}
