package com.kkwrite.demo.provider.dto;

/** 
 * 类说明 
 *
 * @author Soosky Wang
 * @date 2018年12月25日 下午10:37:27 
 * @version 1.0.0
 */
public class OutDTO {

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
