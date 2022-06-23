package com.example.chatapp;


import java.util.Date;

public class Contact {
    private String username;
    private String nickname;
    private String lastMessage = "hello world ho";
    private Date lastDate = new Date();
    private String server;

    public Contact(String username, String nickname) {
        this.username = username;
        this.nickname = nickname;
    }
    public String getUsername() {
        return username;
    }

    public String getNickname() {
        return nickname;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public Date getLastDate() {
        return lastDate;
    }

    public String getServer() {
        return server;
    }
}
