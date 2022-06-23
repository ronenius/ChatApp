package com.example.chatapp;

public class CurrentContact {
    private static Contact currentContact = null;

    public static void setCurrentContact(Contact currentUser) {
        CurrentContact.currentContact = currentUser;
    }

    public static Contact getCurrentContact() {
        return currentContact;
    }
}
