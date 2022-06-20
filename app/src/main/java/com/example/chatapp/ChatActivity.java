package com.example.chatapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        RecyclerView messageList = findViewById(R.id.messages_list);
        List<Message> cons = new ArrayList<>();
        cons.add(new Message("Hello World!", true));
        cons.add(new Message("Hello Back", false));
        cons.add(new Message("Thanks", true));
        final ChatAdapter adapter = new ChatAdapter(this);
        adapter.setContacts(cons);
        messageList.setAdapter(adapter);
        messageList.setLayoutManager(new LinearLayoutManager(this));
    }
}