package com.bluegreen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BlueServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlueServerApplication.class, args);
	}

}
