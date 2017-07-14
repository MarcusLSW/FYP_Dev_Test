package com.xmppserver.controller.server;


import com.xmppserver.services.PayloadProcessor;
import com.xmppserver.services.impl.EchoProcessor;
import com.xmppserver.services.impl.MessageProcessor;
import com.xmppserver.services.impl.RegisterProcessor;
import com.xmppserver.util.Util;

/**
 * Manages the creation of different payload processors based on the desired
 * action
 */

public class ProcessorFactory {

	public static PayloadProcessor getProcessor(String action) {
		if (action == null) {
			throw new IllegalStateException("ProcessorFactory: Action must not be null");
		}
		if (action.equals(Util.BACKEND_ACTION_REGISTER)) {
			return new RegisterProcessor();
		} else if (action.equals(Util.BACKEND_ACTION_ECHO)) {
			return new EchoProcessor();
		} else if (action.equals(Util.BACKEND_ACTION_MESSAGE)) {
			return new MessageProcessor();
		}
		throw new IllegalStateException("ProcessorFactory: Action " + action + " is unknown");
	}
}