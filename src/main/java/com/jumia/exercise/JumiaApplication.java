package com.jumia.exercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = { "com.jumia.entities" })
@EnableJpaRepositories(basePackages = { "com.jumia.repositories" })
@ComponentScan(basePackages = {"com.jumia.controllers", "com.jumia.service", "com.jumia.serviceImpl"})
public class JumiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JumiaApplication.class, args);
	}

}
