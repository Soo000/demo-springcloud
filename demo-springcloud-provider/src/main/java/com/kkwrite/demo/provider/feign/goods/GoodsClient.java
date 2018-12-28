package com.kkwrite.demo.provider.feign.goods;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kkwrite.demo.product.dto.goods.GoodsDTO;

/** 
 * 商品客户端
 *
 * @author Soosky Wang
 * @date 2018年12月28日 上午11:29:42 
 * @version 1.0.0
 */

/*
 * 
 * name 表示请求哪个微服务，
 * 如果请求 demo-springcloud-product 微服务，因为 demo-springcloud-zuul 是这个为服务的网关，所以 name 的值为其网关的为服务名
 *
 */
@FeignClient(name = "demo-springcloud-zuul", fallback = GoodsClientFallback.class)
//@FeignClient(name = "demo-springcloud-product", fallback = GoodsClientFallback.class)
public interface GoodsClient {

	/**
	 * 根据 id 查询用户
	 * 这里的请求路径为 服务提供者的对应方法的路径
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/api/v1/product/goods/findGoodsById/{id}", method = RequestMethod.GET)
	//@RequestMapping(value = "/goods/findGoodsById/{id}", method = RequestMethod.GET)
	public GoodsDTO findGoodsById(@PathVariable("id") Long id);

}
