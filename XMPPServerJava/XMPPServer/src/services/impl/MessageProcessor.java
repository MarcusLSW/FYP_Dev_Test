package services.impl;


import Entities.CcsInMessage;
import Entities.CcsOutMessage;
import server.CcsClient;
import server.MessageHelper;
import services.PayloadProcessor;
import util.Util;

/**
 * Handles an upstream message request
 */
public class MessageProcessor implements PayloadProcessor {

	@Override
	public void handleMessage(CcsInMessage inMessage) {
		CcsClient client = CcsClient.getInstance();
		String messageId = Util.getUniqueMessageId();
		String to = inMessage.getDataPayload().get(Util.PAYLOAD_ATTRIBUTE_RECIPIENT);

		// TODO: handle the data payload sent to the client device. Here, I just
		// resend the incoming message.
		CcsOutMessage outMessage = new CcsOutMessage(to, messageId, inMessage.getDataPayload());
		String jsonRequest = MessageHelper.createJsonOutMessage(outMessage);
		client.send(jsonRequest);
	}

}