package com.swalab.backend;

import com.swalab.backend.database.NoJsTechnicianDatabase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SwalabBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwalabBackendApplication.class, args);
	}

	@Bean
	public NoJsTechnicianDatabase database() {
		return new NoJsTechnicianDatabase();
	}
}
