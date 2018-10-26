package com.gradle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.gradle.repository")
@ComponentScan({"com.gradle"})
@EntityScan("com.gradle.model")
@EnableAutoConfiguration
@SpringBootApplication
public class CrudOperationUsingGradleApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudOperationUsingGradleApplication.class, args);
	}

}
