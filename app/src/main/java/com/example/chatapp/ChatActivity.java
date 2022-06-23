package com.example.chatapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        ImageView returnButton = findViewById(R.id.returnToContacts);
        returnButton.setOnClickListener(v -> {
            Intent i = new Intent(this, Contacts.class);
            startActivity(i);
        });
        TextView name = findViewById(R.id.ChatNickname);
        name.setText(CurrentContact.getCurrentContact().getNickname());

        RecyclerView messageList = findViewById(R.id.messages_list);
        List<Message> cons = new ArrayList<>();
        cons.add(new Message("Hello World!", true));
        cons.add(new Message("Hello Back", false));
        cons.add(new Message("Thanks", true));
        cons.add(new Message("This is a really long message that I am sending just because I want to demonstrate how the message get cut in the middle", true));
        cons.add(new Message("Hello Back", false));
        cons.add(new Message("Hello Back", false));
        cons.add(new Message("Hello Back", false));
        cons.add(new Message("Hello Back", true));
        cons.add(new Message("Hello Back", true));
        cons.add(new Message("Hello Back", true));
        cons.add(new Message("Hello Back", true));
        cons.add(new Message("Hello Back", true));
        cons.add(new Message("Hello Back", true));
        cons.add(new Message("Hello Back", true));
        cons.add(new Message("Hello Back", true));
        cons.add(new Message("Hello Back", true));
        cons.add(new Message("Hello Back", true));
        cons.add(new Message("Hello Back", true));
        cons.add(new Message("Hello Back", true));
        cons.add(new Message("Hello Back", true));
        cons.add(new Message("Hello Back", true));
        cons.add(new Message("Hello Back", true));
        cons.add(new Message("Hello Back", true));
        cons.add(new Message("Hello Back", true));
        cons.add(new Message("Hello Back", true));
        cons.add(new Message("Hello Back", true));
        final ChatAdapter adapter = new ChatAdapter(this);
        adapter.setContacts(cons);
        messageList.setAdapter(adapter);
        messageList.setLayoutManager(new LinearLayoutManager(this));
    }
}