package com.example.jasypt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.StandardEnvironment;

@SpringBootApplication
public class EnvironmentMergingApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(EnvironmentMergingApplication.class,
				"--spring.profiles.active=other");
		SpringApplicationBuilder builder = new SpringApplicationBuilder(NoBeanContext.class);
		builder.parent(context);
		StandardEnvironment environment = new StandardEnvironment();
		environment.merge(context.getEnvironment());
		builder.environment(context.getEnvironment());
		builder.run();
	}

	public static class NoBeanContext {

	}
}
