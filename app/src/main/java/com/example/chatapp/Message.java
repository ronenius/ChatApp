package com.example.chatapp;

import java.util.Date;

public class Message {
    private String content;
    private Date date = new Date();
    private boolean sent;

    public Message(String content, boolean sent) {
        this.content = content;
        this.sent = sent;
    }

    public String getContent() {
        return content;
    }

    public Date getDate() {
        return date;
    }

    public boolean isSent() {
        return sent;
    }
}
