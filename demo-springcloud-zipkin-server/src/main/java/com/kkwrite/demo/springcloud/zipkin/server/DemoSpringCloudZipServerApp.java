package com.kkwrite.demo.springcloud.zipkin.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.EnableZipkinServer;

/** 
 * Zipkin Server
 *
 * @author Soosky Wang
 * @date 2018年11月23日 下午12:31:15 
 * @version 1.0.0
 */
@SpringBootApplication
@EnableZipkinServer
public class DemoSpringCloudZipServerApp {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringCloudZipServerApp.class, args);
	}
	
}
