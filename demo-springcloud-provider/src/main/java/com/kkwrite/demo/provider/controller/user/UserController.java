package com.kkwrite.demo.provider.controller.user;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.kkwrite.demo.product.dto.goods.GoodsDTO;
import com.kkwrite.demo.provider.dto.OutDTO;
import com.kkwrite.demo.provider.dto.user.UserDTO;
import com.kkwrite.demo.provider.exception.ServiceException;
import com.kkwrite.demo.provider.service.user.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	// zuul 代理地址前缀
	private final String proxyPrefix = "http://demo-springcloud-zuul/api/v1";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/getUserById/{userId}")
	public OutDTO getUserById(@PathVariable Long userId) {
		if (logger.isDebugEnabled()) {
			logger.debug("UserController.getUserById(Long userId); userId = {}", userId);			
		}
		
		OutDTO outDTO = new OutDTO();
		Map<String, Object> data = new HashMap<>();
		try {			
			UserDTO userDTO = userService.getUserById(userId);
			data.put("userDTO", userDTO);
			
			OutDTO goodsOutDTO = getGoodsById(1L);
			GoodsDTO goodsDTO = (GoodsDTO) goodsOutDTO.getData();
			data.put("goodsDTO", goodsDTO);
			
			outDTO.setData(data);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return outDTO;
	}
	
	private OutDTO getGoodsById(Long goodsId) {
		String url = proxyPrefix + "/product/goods/getGoodsById/1";
		OutDTO outDTO = restTemplate.getForObject(url, OutDTO.class);
		return outDTO;
	}
	
}
