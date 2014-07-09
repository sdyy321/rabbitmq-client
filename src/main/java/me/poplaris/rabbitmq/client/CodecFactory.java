package me.poplaris.rabbitmq.client;

import java.io.IOException;

/**
 * User: poplar
 * Date: 14-7-4 下午5:59
 * 编码和解码工厂
 */
public interface CodecFactory {

	byte[] serialize(Object obj) throws IOException;
	
	Object deSerialize(byte[] in) throws IOException;

}
