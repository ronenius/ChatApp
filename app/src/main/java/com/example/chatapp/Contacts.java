package com.example.chatapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Contacts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        ImageView search = findViewById(R.id.searchContactButton);
        search.setOnClickListener(v -> {
            EditText searchStr = findViewById(R.id.editTextTextPersonName);
            CharSequence s = searchStr.getText();
            List<Contact> contacts = ServerCommunication.getContacts(), newContacts = new ArrayList<>();
            for (Contact c : contacts) {
                if (c.getNickname().contains(s))
                    newContacts.add(c);
            }
            RecyclerView contactsList = findViewById(R.id.contactsList);
            final ContactAdapter adapter = new ContactAdapter(this);
            adapter.setContacts(newContacts);
            contactsList.swapAdapter(adapter, false);
            contactsList.setLayoutManager(new LinearLayoutManager(this));
        });
        RecyclerView contactsList = findViewById(R.id.contactsList);
        final ContactAdapter adapter = new ContactAdapter(this);
        List<Contact> cons = ServerCommunication.getContacts();
        adapter.setContacts(cons);
        contactsList.setAdapter(adapter);
        contactsList.setLayoutManager(new LinearLayoutManager(this));
    }
}