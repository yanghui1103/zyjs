package com.bw.fit.system.common.data.source.impl;

import java.io.IOException;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.*;
import org.springframework.stereotype.Component;

import com.bw.fit.system.common.data.source.MqDataSource;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.system.common.util.PropertiesUtil;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.ConsumerCancelledException;
import com.rabbitmq.client.MessageProperties;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.ShutdownSignalException;


public class MqDataSourceImpl implements MqDataSource {

	@Override
	public String consumeDataFormQueue(String queueKey) throws RbackException {
		// 打开连接和创建频道，与发送端一样
		// nextDelivery是一个阻塞方法（内部实现其实是阻塞队列的take方法）
		QueueingConsumer.Delivery delivery=null;
		try {
			ConnectionFactory factory = new ConnectionFactory();
			factory.setHost(PropertiesUtil.getValueByKey("mq.ip"));
			Connection connection = factory.newConnection();
			Channel channel = connection.createChannel();
			// 声明队列，主要为了防止消息接收者先运行此程序，队列还不存在时创建队列。
			channel.queueDeclare(PropertiesUtil.getValueByKey("mq.exchangeName"), false,
					false, false, null);
			// 创建队列消费者
			QueueingConsumer consumer = new QueueingConsumer(channel);
			// 指定消费队列
			channel.basicConsume(queueKey, true,
					consumer);
			delivery = consumer.nextDelivery();
		} catch ( Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RbackException("1", "消费MQ数据异常");
		}finally{
			return new String(delivery.getBody());
		}
	}

	@Override
	public void sendDataToExchange(String message) throws RbackException {
		// TODO Auto-generated method stub
		/**
		 * 创建连接连接到rabbitMQ
		 */
		try {
			ConnectionFactory factory = new ConnectionFactory();
			// 设置MabbitMQ所在主机ip或者主机名
			factory.setHost(PropertiesUtil.getValueByKey("mq.ip"));
			// 创建一个连接
			Connection connection = factory.newConnection();
			// 创建一个频道
			Channel channel = connection.createChannel();
			// 交换机持久化
			channel.exchangeDeclare(PropertiesUtil.getValueByKey("mq.port"), "topic",
					true);
			// 指定一个队列
			channel.queueDeclare(PropertiesUtil.getValueByKey("mq.exchangeName"),
					false, false, false, null);
			// 发送的消息
			// 往队列中发出一条消息
			channel.basicPublish(PropertiesUtil.getValueByKey("mq.exchangeName"),PropertiesUtil.getValueByKey("mq.matchQueue") ,
					MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
			// 关闭频道和连接
			channel.close();
			connection.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RbackException("1", "发送数据至MQ异常");
		}
	}

	@Override
	public void sendDataToQueue(String queueName, String message)
			throws RbackException {
		/**
		 * 创建连接连接到rabbitMQ
		 */
		try {
			ConnectionFactory factory = new ConnectionFactory();
			// 设置MabbitMQ所在主机ip或者主机名
			factory.setHost(PropertiesUtil.getValueByKey("mq.ip"));
			// 创建一个连接
			Connection connection = factory.newConnection();
			// 创建一个频道
			Channel channel = connection.createChannel();
			// 交换机持久化
			channel.exchangeDeclare(PropertiesUtil.getValueByKey("mq.port"), "topic",
					true);
			// 指定一个队列
			channel.queueDeclare(PropertiesUtil.getValueByKey("mq.exchangeName"),
					false, false, false, null);
			// 发送的消息
			// 往队列中发出一条消息
			channel.basicPublish(PropertiesUtil.getValueByKey("mq.exchangeName"), queueName ,
					MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
			// 关闭频道和连接
			channel.close();
			connection.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RbackException("1", "发送数据至MQ异常");
		}
	}

}
