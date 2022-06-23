package com.example.chatapp;

import java.util.ArrayList;
import java.util.List;

public class ServerCommunication {
    public static List<Contact> getContacts() {
        List<Contact> cons = new ArrayList<>();
        cons.add(new Contact("Shlomy", "shlomy"));
        cons.add(new Contact("Shlom", "shlom"));
        cons.add(new Contact("Shlim", "shlim"));
        return cons;
    }
    public static Contact getContact(String username) {return null;}

}
