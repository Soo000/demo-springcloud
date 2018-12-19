package com.kkwrite.demo.zuul;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.debug(true);
	}

	/**
	 * 自定义jdbc权限认证，使用自定义表
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN", "ADMIN");
	}
	
	/**
	 * http 请求权限验证
	 */
	protected void configure(HttpSecurity http) throws Exception {
		// 禁用 csrf 保护
		http.csrf().disable();
		
		// mvcMatchers(...) 不支持通配符
		http.authorizeRequests().mvcMatchers("/").access("permitAll");
		//
		http.authorizeRequests().mvcMatchers("/testRoute").access("permitAll");
		//
		http.authorizeRequests().mvcMatchers("/my-provider/userservice/queryuserbyid").access("permitAll");
		// 其它都需要认证
		http.authorizeRequests().antMatchers("/**").authenticated();
		
		// 使用 Http Base
		http.httpBasic();
	}
	
}
