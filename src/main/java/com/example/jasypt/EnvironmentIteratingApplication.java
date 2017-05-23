package com.example.jasypt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.StandardEnvironment;

@SpringBootApplication
public class EnvironmentIteratingApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(EnvironmentIteratingApplication.class,
				"--spring.profiles.active=other");
		for (PropertySource<?> propertySource : context.getEnvironment().getPropertySources()) {
			propertySource.getProperty("encrypted.value");
		}
	}

	public static class NoBeanContext {

	}
}
