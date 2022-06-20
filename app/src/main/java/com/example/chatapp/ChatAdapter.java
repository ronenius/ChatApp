package com.example.chatapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.MessageHolder> {
    class MessageHolder extends RecyclerView.ViewHolder {
        private final TextView content;

        private MessageHolder(View itemView) {
            super(itemView);
            content = itemView.findViewById(R.id.message_content);
        }
    }

    private final LayoutInflater inflater;
    private List<Message> messages;
    private final Context context;

    public ChatAdapter(Context context) {
        inflater = LayoutInflater.from(context);
        this.context = context;
    }

    public MessageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.message, parent, false);
        return new MessageHolder(itemView);
    }

    public void onBindViewHolder(MessageHolder holder, int position) {
        if (messages != null) {
            final Message message = messages.get(position);
            if (messages.get(position).isSent())
                holder.content.setText("you: " + messages.get(position).getContent());
            else
                holder.content.setText(CurrentContact.getCurrentUser().getNickname() + ": " + messages.get(position).getContent());
        }
    }

    public int getItemCount() {
        if (messages == null)
            return 0;
        return messages.size();
    }

    public void setContacts(List<Message> messages) {
        this.messages = messages;
        notifyDataSetChanged();
    }

    public List<Message> getContacts() {
        return messages;
    }
}
