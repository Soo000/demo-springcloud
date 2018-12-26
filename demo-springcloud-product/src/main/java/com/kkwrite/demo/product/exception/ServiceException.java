package com.kkwrite.demo.product.exception;

/** 
 * 服务层异常类
 *
 * @author Soosky Wang
 * @date 2018年12月25日 下午10:11:56 
 * @version 1.0.0
 */
public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = 5222062153962146443L;

	ServiceException(String msg) {
		super(msg);
	}
	
}
