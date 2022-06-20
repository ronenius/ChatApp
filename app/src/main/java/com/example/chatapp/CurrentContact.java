package com.example.chatapp;

public class CurrentContact {
    private static Contact currentUser = null;

    public static void setCurrentUser(Contact currentUser) {
        CurrentContact.currentUser = currentUser;
    }

    public static Contact getCurrentUser() {
        return currentUser;
    }
}
