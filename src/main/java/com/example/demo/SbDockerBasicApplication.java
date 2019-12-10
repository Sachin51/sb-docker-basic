package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SbDockerBasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbDockerBasicApplication.class, args);
	}

}
