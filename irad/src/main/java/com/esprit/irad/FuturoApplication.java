package com.esprit.irad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FuturoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FuturoApplication.class, args);
	}

}
