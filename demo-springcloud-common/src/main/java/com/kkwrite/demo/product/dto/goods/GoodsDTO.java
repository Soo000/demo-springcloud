package com.kkwrite.demo.product.dto.goods;

import java.io.Serializable;

/** 
 * 商品 DTO 
 *
 * @author Soosky Wang
 * @date 2018年12月25日 下午10:06:07 
 * @version 1.0.0
 */
public class GoodsDTO implements Serializable {

	private static final long serialVersionUID = -861193650214647272L;
	
	private Long goodsId;
	private String goodsName;
	
	public Long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	
	@Override
	public String toString() {
		return "GoodsDTO [goodsId=" + goodsId + ", goodsName=" + goodsName + "]";
	}
	
}
