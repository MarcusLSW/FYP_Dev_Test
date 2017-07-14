package com.xmppserver.services.impl;


import com.xmppserver.model.entities.CcsInMessage;
import com.xmppserver.model.entities.CcsOutMessage;
import com.xmppserver.controller.server.CcsClient;
import com.xmppserver.util.MessageHelper;
import com.xmppserver.services.PayloadProcessor;
import com.xmppserver.util.Util;

/**
 * Handles an echo request
 */
public class EchoProcessor implements PayloadProcessor {

	@Override
	public void handleMessage(CcsInMessage inMessage) {
		CcsClient client = CcsClient.getInstance();
		String messageId = Util.getUniqueMessageId();
		String to = inMessage.getFrom();

		// Send the incoming message to the the device that made the request
		CcsOutMessage outMessage = new CcsOutMessage(to, messageId, inMessage.getDataPayload());
		String jsonRequest = MessageHelper.createJsonOutMessage(outMessage);
		client.send(jsonRequest);
	}

}