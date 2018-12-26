package com.kkwrite.demo.product.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "goods")
public class GoodsDO extends BaseDO {

	private static final long serialVersionUID = 3289865486522416549L;
	
	@Id
    @Column(name = "goods_id")
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
		return "GoodsDO [goodsId=" + goodsId + ", goodsName=" + goodsName + "]";
	}
	
}
