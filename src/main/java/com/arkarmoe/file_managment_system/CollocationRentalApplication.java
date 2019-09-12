package com.arkarmoe.file_managment_system;

import com.arkarmoe.file_managment_system.config.StorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class CollocationRentalApplication {

	public static void main(String[] args) {
		SpringApplication.run(CollocationRentalApplication.class, args);
	}

}
