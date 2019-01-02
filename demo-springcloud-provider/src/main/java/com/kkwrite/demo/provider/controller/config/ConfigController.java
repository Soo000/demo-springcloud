package com.kkwrite.demo.provider.controller.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kkwrite.demo.provider.config.ProviderConfig;

/** 
 * 配置类说明 
 *
 * @author Soosky Wang
 * @date 2019年1月2日 上午10:56:46 
 * @version 1.0.0
 */
@RestController
@RequestMapping("/config")
public class ConfigController {

	@Autowired
	private ProviderConfig providerConfig;
	
	@GetMapping("/getServerPort")
	public String getServerPort() {
		return providerConfig.getPort();
	}
	
	@GetMapping("/getProviderParam")
	public String getProviderParam() {
		return providerConfig.getParam();
	}
	
}
