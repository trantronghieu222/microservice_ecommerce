package com.shop.receivedservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ReceivedServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReceivedServiceApplication.class, args);
	}

}
