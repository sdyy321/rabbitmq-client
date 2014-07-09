package me.poplaris.rabbitmq.client.exception;

/**
 * User: poplar
 * Date: 14-7-4 下午5:59
 */
@SuppressWarnings("serial")
public class SendRefuseException extends Exception {

	public SendRefuseException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SendRefuseException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public SendRefuseException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public SendRefuseException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

}
