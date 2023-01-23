package com.k.price;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableCaching  

public class PriceApp {

	public static void main(String[] args) {
		SpringApplication.run(PriceApp.class, args);
	}

}
