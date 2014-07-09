package me.poplaris.rabbitmq.client.impl;

import java.io.Serializable;
import java.util.Arrays;

/**
 * User: poplar
 * Date: 14-7-4 下午5:59
 * 在App和RabbitMQ之间转送的消息
 */
@SuppressWarnings("serial")
public class EventMessage implements Serializable{

	private String queueName;
	
	private String exchangeName;
	
	private byte[] eventData;

	public EventMessage(String queueName, String exchangeName, byte[] eventData) {
		this.queueName = queueName;
		this.exchangeName = exchangeName;
		this.eventData = eventData;
	}

	public EventMessage() {
	}	

	public String getQueueName() {
		return queueName;
	}

	public String getExchangeName() {
		return exchangeName;
	}

	public byte[] getEventData() {
		return eventData;
	}

	@Override
	public String toString() {
		return "EopEventMessage [queueName=" + queueName + ", exchangeName="
				+ exchangeName + ", eventData=" + Arrays.toString(eventData)
				+ "]";
	}
}
