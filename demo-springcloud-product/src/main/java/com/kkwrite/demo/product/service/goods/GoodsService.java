package com.kkwrite.demo.product.service.goods;

import com.kkwrite.demo.product.dto.goods.GoodsDTO;
import com.kkwrite.demo.product.exception.ServiceException;

/** 
 * 商品服务接口
 *
 * @author Soosky Wang
 * @date 2018年12月25日 下午10:08:56 
 * @version 1.0.0
 */
public interface GoodsService {

	GoodsDTO getGoodsById(Long goodsId) throws ServiceException;
	
	Integer getGoodsCount() throws ServiceException;
	
}
