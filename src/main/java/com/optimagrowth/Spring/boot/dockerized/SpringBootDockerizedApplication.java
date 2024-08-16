package com.optimagrowth.Spring.boot.dockerized;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringBootDockerizedApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDockerizedApplication.class, args);
	}

}
