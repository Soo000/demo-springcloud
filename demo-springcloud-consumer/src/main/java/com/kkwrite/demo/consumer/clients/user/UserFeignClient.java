package com.kkwrite.demo.consumer.clients.user;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "demo-springcloud-provider", fallback = UserFeignClientFallBack.class)
public interface UserFeignClient {

	@RequestMapping(value = "/userservice/queryuserbyid", method = RequestMethod.GET)
	public Map<String, Object> queryUserById(@RequestParam("userId") Integer userId, 
			@RequestParam("username") String username);
	
}
