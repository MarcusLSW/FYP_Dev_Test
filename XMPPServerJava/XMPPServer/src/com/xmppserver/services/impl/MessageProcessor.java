package com.xmppserver.services.impl;


import com.xmppserver.model.dao.DAOFactory;
import com.xmppserver.model.entities.CcsInMessage;
import com.xmppserver.model.entities.CcsOutMessage;
import com.xmppserver.controller.server.CcsClient;
import com.xmppserver.model.entities.GroupChat;
import com.xmppserver.util.MessageHelper;
import com.xmppserver.services.PayloadProcessor;
import com.xmppserver.util.Util;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Handles an upstream message request
 */
public class MessageProcessor implements PayloadProcessor {

	@Override
	public void handleMessage(CcsInMessage inMessage) {

		String messageId = Util.getUniqueMessageId();
		String to = inMessage.getDataPayload().get(Util.PAYLOAD_ATTRIBUTE_RECIPIENT);

		// TODO: handle the data payload sent to the client device. Here, I just
		// resend the incoming message.

        String groupId = inMessage.getDataPayload().get(Util.PAYLOAD_ATTRIBUTE_GROUPID);
		if(groupId != null){
			handleGroupChatMessages(to , groupId ,  messageId , inMessage.getDataPayload());
		} else {
            throw new NotImplementedException();
        }

	}

	private void handleGroupChatMessages(String to, String groupId , String messageId,
                                         Map<String , String> messagePayLoad){

        CcsClient client = CcsClient.getInstance();

		GroupChat group = DAOFactory.getDAOFactory(1).getGroupChatDAO().getGroupChat(groupId);
		ArrayList<String> memberList = group.getMembers();

		String message = messagePayLoad.get(Util.PAYLOAD_ATTRIBUTE_MESSAGE);

		Map<String , String> newOutMessagePayLoad = new HashMap<>();
		newOutMessagePayLoad.put("message" , message);
		newOutMessagePayLoad.put("group_id" , groupId);

		Map<String , String> notificationPayLoad = new HashMap<>();
		notificationPayLoad.put("title" , "New Message from" + group.getName());
		notificationPayLoad.put("body" , message);

        CcsOutMessage outMessage = new CcsOutMessage(null, messageId, newOutMessagePayLoad);
        outMessage.setNotificationPayload(notificationPayLoad);

        for (String s : memberList) {
            outMessage.setTo(s);
            String jsonRequest = MessageHelper.createJsonOutMessage(outMessage);
            client.send(jsonRequest);
        }
    }

	private void handlePrivateMessages(){

	}

}