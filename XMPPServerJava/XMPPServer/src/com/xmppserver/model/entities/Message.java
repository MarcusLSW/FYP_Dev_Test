package com.xmppserver.model.entities;

import java.util.Map;

/**
 * Created by MarcusLSW on 15-Jul-17.
 */
public class Message {
    private String from;
    private String category;
    private String messageId;
    private Map<String , Object> messageBody;

    public Message(String from, String category, String messageId, Map<String, Object> messageBody) {
        this.from = from;
        this.category = category;
        this.messageId = messageId;
        this.messageBody = messageBody;

    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public Map<String, Object> getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(Map<String, Object> messageBody) {
        this.messageBody = messageBody;
    }
}
