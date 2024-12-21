package org.usermanagementservice.moviemanagementservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MovieManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieManagementServiceApplication.class, args);
	}

}
