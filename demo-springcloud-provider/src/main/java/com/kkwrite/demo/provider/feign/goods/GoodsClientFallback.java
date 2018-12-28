package com.kkwrite.demo.provider.feign.goods;

import org.springframework.stereotype.Component;

import com.kkwrite.demo.product.dto.goods.GoodsDTO;

/** 
 * 类说明 
 *
 * @author Soosky Wang
 * @date 2018年12月28日 上午11:48:52 
 * @version 1.0.0
 */
@Component
public class GoodsClientFallback implements GoodsClient {

	@Override
	public GoodsDTO findGoodsById(Long id) {
		GoodsDTO goodsDTO = new GoodsDTO();
		goodsDTO.setGoodsId(-1L);
		return goodsDTO;
	}

}
