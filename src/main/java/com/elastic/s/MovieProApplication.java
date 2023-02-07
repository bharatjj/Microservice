package com.elastic.s;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient

public class MovieProApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieProApplication.class, args);
	}

}
