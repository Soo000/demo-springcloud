package com.kkwrite.demo.consumer.clients.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class UserFeignClientFallBack implements UserFeignClient {

	@Override
	public Map<String, Object> queryUserById(Integer userId, String username) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("retCode", "1001");
		result.put("retMsg", "服务调用超时，请稍后重试");
		return result;
	}

}
