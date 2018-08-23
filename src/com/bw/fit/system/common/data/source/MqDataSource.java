package com.bw.fit.system.common.data.source;

import org.springframework.stereotype.Component;

import com.bw.fit.system.common.model.RbackException;

@Component
public interface MqDataSource {
	 /**
     * 发送消息到指定交换机，（这个指定的交换机名称需要在应用级配置层）
     * 所有绑定在这个交换机上的
     * 队列，都会受到消息 
     * @param object
     */
    public void sendDataToExchange(String message)  throws  RbackException;
	 /**
     * 发送消息到指定交换机，（这个指定的交换机名称需要在应用级配置层）
     * 下绑定的那个队列
     * @param queueName 队列名称
     * @param object
     */
    public void sendDataToQueue(String queueName ,String message)  throws  RbackException;
	 /**
     * 消费数据,从指定交换机，（这个指定的交换机名称需要在应用级配置层）
     * 下绑定的那个队列
     * @param queueName 队列名称
     * @param object
     */
    public String consumeDataFormQueue(String queueName)  throws  RbackException;
	 
}
