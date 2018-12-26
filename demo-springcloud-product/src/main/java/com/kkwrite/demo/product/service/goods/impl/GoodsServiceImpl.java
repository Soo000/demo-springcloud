package com.kkwrite.demo.product.service.goods.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kkwrite.demo.product.dto.goods.GoodsDTO;
import com.kkwrite.demo.product.exception.ServiceException;
import com.kkwrite.demo.product.pojo.GoodsDO;
import com.kkwrite.demo.product.repository.GoodsRepository;
import com.kkwrite.demo.product.service.goods.GoodsService;

/** 
 * 商品服务接口实现
 *
 * @author Soosky Wang
 * @date 2018年12月25日 下午10:09:28 
 * @version 1.0.0
 */
@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {
	
	@Autowired
	private GoodsRepository goodsRepository;

	@Override
	public GoodsDTO getGoodsById(Long userId) throws ServiceException {
		GoodsDTO userDTO = null;
		try {
			GoodsDO userDO = goodsRepository.findByGoodsId(userId);
			userDTO = new GoodsDTO();
			if (userDO != null) {
				BeanUtils.copyProperties(userDO, userDTO);
			}
		} catch (Exception e) {
			throw e;
		}
		return userDTO;
	}

	@Override
	public Integer getGoodsCount() throws ServiceException {
		try {
			return goodsRepository.getGoodsCount();
		} catch (Exception e) {
			throw e;
		}
	}

}
