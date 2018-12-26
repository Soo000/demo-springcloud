package com.kkwrite.demo.product.dto;

import java.io.Serializable;

/** 
 * 类说明 
 *
 * @author Soosky Wang
 * @date 2018年12月26日 下午5:07:29 
 * @version 1.0.0
 */
public class OutDTO implements Serializable {

	private static final long serialVersionUID = 4877130826999288934L;
	
	private String retCode;
	private String retMsg;
	
	private Object data;

	public String getRetCode() {
		return retCode;
	}

	public void setRetCode(String retCode) {
		this.retCode = retCode;
	}

	public String getRetMsg() {
		return retMsg;
	}

	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
}
