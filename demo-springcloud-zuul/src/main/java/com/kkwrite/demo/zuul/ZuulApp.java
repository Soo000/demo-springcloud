package com.kkwrite.demo.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.kkwrite.demo.zuul.filter.ParamFilter;

@SpringBootApplication
@EnableZuulProxy
public class ZuulApp {
	
	/**
	 * 在主类中开启 ParamFilter 
	 */
	@Bean  
    public ParamFilter paramFilter() {  
        return new ParamFilter();  
    }

	public static void main(String[] args) {
		SpringApplication.run(ZuulApp.class, args);
	}
	
}
