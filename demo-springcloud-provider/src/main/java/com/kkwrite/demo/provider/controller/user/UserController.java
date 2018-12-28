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

import com.kkwrite.demo.product.dto.OutDTO;
import com.kkwrite.demo.product.dto.goods.GoodsDTO;
import com.kkwrite.demo.provider.dto.user.UserDTO;
import com.kkwrite.demo.provider.exception.ServiceException;
import com.kkwrite.demo.provider.feign.goods.GoodsClient;
import com.kkwrite.demo.provider.service.user.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/user")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	// zuul 代理地址前缀
	private final String proxyPrefix = "http://demo-springcloud-zuul/api/v1/product";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private GoodsClient goodsClient;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/getUserById/{userId}")
	@HystrixCommand(fallbackMethod = "getUserByIdBack")
	public OutDTO getUserById(@PathVariable Long userId) {
		if (logger.isDebugEnabled()) {
			logger.debug("UserController.getUserById(Long userId); userId = {}", userId);			
		}
		
		OutDTO outDTO = new OutDTO();
		Map<String, Object> data = new HashMap<>();
		try {			
			UserDTO userDTO = userService.getUserById(userId);
			data.put("userDTO", userDTO);
			
			//GoodsDTO goodsDTO = getGoodsById(1L);
			//GoodsDTO goodsDTO = findGoodsById(1L);
			GoodsDTO goodsDTO = goodsClient.findGoodsById(1L);
			data.put("goodsDTO", goodsDTO);
			
			outDTO.setData(data);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return outDTO;
	}
	
	public OutDTO getUserByIdBack(@PathVariable Long userId) {
		OutDTO outDTO = new OutDTO();
		outDTO.setRetCode("0002");
		outDTO.setRetMsg("服务 getUserById(Long userId) 调用超时");
		return outDTO;
	}
	
	/**
	 * 根据商品 id 查询商品
	 * @param goodsId
	 * @return
	 */
	private GoodsDTO getGoodsById(Long goodsId) {
		String url = proxyPrefix + "/goods/getGoodsById/1";
		OutDTO outDTO = restTemplate.getForObject(url, OutDTO.class);
		if (outDTO != null && OutDTO.SUCCESS_RETURN_CODE.equalsIgnoreCase(outDTO.getRetCode())) {
			GoodsDTO goodsDTO = (GoodsDTO) outDTO.getData();
			return goodsDTO;
		}
		
		return new GoodsDTO();
	}
	
	/**
	 * 根据商品 id 查询商品
	 * @param goodsId
	 * @return
	 */
	private GoodsDTO findGoodsById(Long goodsId) {
		String url = proxyPrefix + "/goods/findGoodsById/1";
		GoodsDTO goodsDTO = restTemplate.getForObject(url, GoodsDTO.class);
		return goodsDTO;
	}
	
}
