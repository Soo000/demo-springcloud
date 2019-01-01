package com.kkwrite.demo.product.controller.goods;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kkwrite.demo.product.dto.OutDTO;
import com.kkwrite.demo.product.dto.goods.GoodsDTO;
import com.kkwrite.demo.product.exception.ServiceException;
import com.kkwrite.demo.product.service.goods.GoodsService;

@RestController
@RequestMapping("/goods")
public class GoodsController {

	private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);
	
	@Autowired
	private GoodsService goodsService;
	
	@GetMapping("/getGoodsById/{goodsId}")
	public OutDTO getGoodsById(@PathVariable Long goodsId) {
		if (logger.isDebugEnabled()) {
			logger.debug("UserController.getUserById(Long userId); userId = {}", goodsId);			
		}
		
		OutDTO outDTO = new OutDTO();
		try {
			//GoodsDTO goodsDTO = goodsService.getGoodsById(goodsId);
			GoodsDTO goodsDTO = new GoodsDTO();
			goodsDTO.setGoodsId(1L);
			goodsDTO.setGoodsName("三星64G内存条");
			outDTO.setData(goodsDTO);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
		return outDTO;
	}
	
	@GetMapping("/findGoodsById/{goodsId}")
	public GoodsDTO findGoodsById(@PathVariable Long goodsId) {
		if (logger.isDebugEnabled()) {
			logger.debug("UserController.getUserById(Long userId); userId = {}", goodsId);			
		}
		
		GoodsDTO goodsDTO = new GoodsDTO();
		try {
			//goodsDTO = goodsService.getGoodsById(goodsId);
			goodsDTO.setGoodsId(1L);
			goodsDTO.setGoodsName("三星笔记本内存条 DDR4 128G    第5次调用");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
		/*try {
			logger.info("商品服务 findGoodsById 准备进入休眠...");
			Thread.currentThread().sleep(4000);
			logger.info("商品服务 findGoodsById 休眠结束");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		
		return goodsDTO;
	}
	
}
