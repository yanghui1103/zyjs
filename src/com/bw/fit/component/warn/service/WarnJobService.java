package com.bw.fit.component.warn.service;

/*****
 * 通知/预警的定时任务
 * @author yangh
 *
 */
public interface WarnJobService {

	/*****
	 * 定时隔时间发送
	 */
	public void warn();
}
