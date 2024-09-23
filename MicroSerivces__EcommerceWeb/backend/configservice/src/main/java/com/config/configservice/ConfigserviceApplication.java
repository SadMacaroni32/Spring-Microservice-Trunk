package com.config.configservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.bootstrap.config.PropertySourceLocator;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableConfigServer
@Configuration
public class ConfigserviceApplication {

	public static void main(String[] args) {
        SpringApplication.run(ConfigserviceApplication.class, args);
    }

	@Bean
	public PropertySourceLocator customPropertySourceLocator() {
		return new CustomPropertySourceLocator();
	}

}
