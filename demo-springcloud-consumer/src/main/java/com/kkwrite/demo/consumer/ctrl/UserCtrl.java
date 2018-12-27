package com.kkwrite.demo.consumer.ctrl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.kkwrite.demo.consumer.clients.user.UserFeignClient;
import com.kkwrite.demo.product.dto.OutDTO;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/user")
public class UserCtrl {
	
	private Logger logger = LoggerFactory.getLogger(UserCtrl.class);
	
	private volatile int i = 0;
	
	@Autowired
	private UserFeignClient userFeignClient;

	// zuul 代理地址前缀
	private final String proxyPrefix = "http://demo-springcloud-zuul/api/v1/provider";

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/qryUserById")
//	@HystrixCommand(fallbackMethod = "qryUserByIdFallBack")
	public OutDTO qryUserById(Integer userId, String username) {
		logger.info("[ begin ] UserCtrl.qryUserById().");
		
		String url = proxyPrefix + "/user/getUserById/1";
		OutDTO outDTO = restTemplate.getForObject(url, OutDTO.class);
		
		logger.info("[ end ] UserCtrl.qryUserById(), outDTO = " + outDTO);
		return outDTO;
	}
	
	/**
	 * qryUserById 服务降级
	 * @param userId
	 * @param username
	 * @return
	 */
	public OutDTO qryUserByIdFallBack(Integer userId, String username) {
		logger.info("[ begin ] UserCtrl.qryUserByIdFallBack().");
		
		OutDTO outDTO = new OutDTO();
		outDTO.setRetCode("1001");
		outDTO.setRetMsg("服务调用超时，请稍后重试！");
		
		logger.info("[ end ] UserCtrl.qryUserByIdFallBack().");
		return outDTO;
	}
	
	@GetMapping("/qryuserbyid2")
	public Map<String, Object> qryUserById2(Integer userId, String username) {
		logger.info("[ begin ] UserCtrl.qryUserById2(), i = " + i);
		
		i++;
		String url = proxyPrefix + "/queryuserbyid2?userId=" + userId + "&username=" + username + "&token=1";
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
