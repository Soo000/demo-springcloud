package com.kkwrite.demo.provider.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/** 
 * 配置类
 *
 * @author Soosky Wang
 * @date 2019年1月2日 上午10:11:58 
 * @version 1.0.0
 */
@Configuration
@RefreshScope
public class ProviderConfig {

	@Value("${server.port}")
	private String port;
	
	@Value("${provider.param}")
	private String param;

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}
	
}