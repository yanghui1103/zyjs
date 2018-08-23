package com.bw.fit.system.common.model;

/****
 * 系统级回滚事务_异常类
 * @author yangh
 *
 */
public class RbackException extends Exception {
	/****
	 * 事务回滚使用到的异常类
	 */
	private String res ;
	private String msg ;
	public RbackException(String res,String msg){
		this.res = res;
		this.msg = msg;
	}
	public String getRes() {
		return res;
	}
	public void setRes(String res) {
		this.res = res;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
