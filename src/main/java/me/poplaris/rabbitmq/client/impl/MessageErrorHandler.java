package me.poplaris.rabbitmq.client.impl;

import org.apache.log4j.Logger;
import org.springframework.util.ErrorHandler;

public class MessageErrorHandler implements ErrorHandler{

	private static final Logger logger = Logger.getLogger(MessageErrorHandler.class);
	
	@Override
	public void handleError(Throwable t) {
		logger.error("RabbitMQ happen a error:" + t.getMessage(), t);
	}

}
