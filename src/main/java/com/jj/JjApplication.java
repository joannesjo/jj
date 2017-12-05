package com.jj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.WebApplicationInitializer;

@SpringBootApplication
@EnableJpaAuditing
public class JjApplication {

	public static void main(String[] args) {
		SpringApplication.run(JjApplication.class, args);
	}
	}
