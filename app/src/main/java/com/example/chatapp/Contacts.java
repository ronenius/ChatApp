package com.example.chatapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Contacts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        RecyclerView contactsList = findViewById(R.id.contactsList);
        List<Contact> cons = new ArrayList<>();
        cons.add(new Contact("Shlomy", "shlomy"));
        cons.add(new Contact("Shlom", "shlom"));
        cons.add(new Contact("Shlim", "shlim"));
        final ContactAdapter adapter = new ContactAdapter(this);
        adapter.setContacts(cons);
        contactsList.setAdapter(adapter);
        contactsList.setLayoutManager(new LinearLayoutManager(this));
    }
}