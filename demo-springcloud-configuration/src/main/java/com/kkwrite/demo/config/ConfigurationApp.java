package com.kkwrite.demo.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class ConfigurationApp {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ConfigurationApp.class).run(args);
	}
	
}
