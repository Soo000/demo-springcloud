package com.kkwrite.demo.consumer.ctrl;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.kkwrite.demo.consumer.clients.user.UserFeignClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/userctrl")
public class UserCtrl {
	
	private Logger logger = Logger.getLogger(UserCtrl.class);
	
	private volatile int i = 0;
	
	@Autowired
	private UserFeignClient userFeignClient;

	// zuul 代理地址前缀
	private final String proxyPrefix = "http://demo-springcloud-zuul/my-provider/userservice";
	// 服务地址前缀
	private final String prefix = "http://demo-springcloud-provider/userservice";

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/qryuserbyid")
	@HystrixCommand(fallbackMethod = "qryUserByIdFallBack")
	public Map<String, Object> qryUserById(Integer userId, String username) {
		logger.info("[ begin ] UserCtrl.qryUserById().");
		String url = prefix + "/queryuserbyid?userId=" + userId + "&username=" + username;
		Map<String, Object> result = restTemplate.getForObject(url, Map.class);
		logger.info("[ end ] UserCtrl.qryUserById(), result = " + result);
		return result;
	}
	
	/**
	 * qryUserById 服务降级
	 * @param userId
	 * @param username
	 * @return
	 */
	public Map<String, Object> qryUserByIdFallBack(Integer userId, String username) {
		logger.info("[ begin ] UserCtrl.qryUserByIdFallBack().");
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("retCode", "1001");
		result.put("retMsg", "服务调用超时，请稍后重试！");
		logger.info("[ end ] UserCtrl.qryUserByIdFallBack().");
		return result;
	}
	
	@GetMapping("/qryuserbyid2")
	public Map<String, Object> qryUserById2(Integer userId, String username) {
		i++;
		logger.info("[ begin ] UserCtrl.qryUserById2(), i = " + i);
		String url = prefix + "/queryuserbyid2?userId=" + userId + "&username=" + username + "&token=1";
		Map<String, Object> result = restTemplate.getForObject(url, Map.class);
		logger.info("[ end ] UserCtrl.qryUserById2(), result = " + result);
		return result;
	}
	
	@GetMapping("/qryuserfeignclient")
	public Map<String, Object> qryUserFeignClient(Integer userId, String username) {
		return userFeignClient.queryUserById(userId, username);
	}
	
	@GetMapping("/qryuserproxy")
	public Map<String, Object> qryUserProxy(Integer userId, String username) {
		logger.info("[ begin ] UserCtrl.qryUserProxy().");
		String url = proxyPrefix + "/queryuserbyid?userId=" + userId + "&username=" + username + "&token=1";
		Map<String, Object> result = restTemplate.getForObject(url, Map.class);
		logger.info("[ begin ] UserCtrl.qryUserProxy(), result = " + result);
		return result;
	}
	
}
