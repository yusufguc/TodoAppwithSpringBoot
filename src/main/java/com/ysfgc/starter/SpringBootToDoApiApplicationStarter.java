package com.ysfgc.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.ysfgc"})
@EnableJpaRepositories(basePackages = {"com.ysfgc"})
@ComponentScan(basePackages = {"com.ysfgc"})
@SpringBootApplication
public class SpringBootToDoApiApplicationStarter {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootToDoApiApplicationStarter.class, args);
	}

}
