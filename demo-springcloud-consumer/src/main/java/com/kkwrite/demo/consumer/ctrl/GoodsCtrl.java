package com.kkwrite.demo.consumer.ctrl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.kkwrite.demo.product.dto.OutDTO;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/goods")
public class GoodsCtrl {
	
	private Logger logger = LoggerFactory.getLogger(GoodsCtrl.class);
	
	// zuul 代理地址前缀
	private final String proxyPrefix = "http://demo-springcloud-zuul/api/v1/product";

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/qryGoodsById")
//	@HystrixCommand(fallbackMethod = "qryGoodsByIdFallBack")
	public OutDTO qryGoodsById(Long goodsId) {
		logger.info("[ begin ] GoodsCtrl.qryGoodsById().");
		
		String url = proxyPrefix + "/goods/getGoodsById/1";
		OutDTO outDTO = restTemplate.getForObject(url, OutDTO.class);
		
		logger.info("[ end ] GoodsCtrl.qryGoodsById(), outDTO = " + outDTO);
		return outDTO;
	}
	
	/**
	 * qryUserById 服务降级
	 * @param userId
	 * @param username
	 * @return
	 */
	public OutDTO qryGoodsByIdFallBack(Long goodsId) {
		logger.info("[ begin ] GoodsCtrl.qryGoodsByIdFallBack().");
		
		OutDTO outDTO = new OutDTO();
		outDTO.setRetCode("1001");
		outDTO.setRetMsg("服务调用超时，请稍后重试！");
		
		logger.info("[ end ] GoodsCtrl.qryGoodsByIdFallBack().");
		return outDTO;
	}
	
}
