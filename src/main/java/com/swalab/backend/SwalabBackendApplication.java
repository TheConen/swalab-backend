package com.swalab.backend;

import com.swalab.backend.database.TechnicianDatabase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SwalabBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwalabBackendApplication.class, args);
	}

	@Bean
	public TechnicianDatabase database() {
		return new TechnicianDatabase();
	}
}
