package com.example.chatapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Calendar;
import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.MessageHolder> {
    class MessageHolder extends RecyclerView.ViewHolder {
        private final TextView content;
        private final TextView time;
        private final CardView message;
        private final TextView recContent;
        private final TextView recTime;
        private final CardView recMessage;
        private MessageHolder(View itemView) {
            super(itemView);
            content = itemView.findViewById(R.id.message_content);
            time = itemView.findViewById(R.id.sending_time);
            message = itemView.findViewById(R.id.message_wrapper);
            recContent = itemView.findViewById(R.id.rec_message_content);
            recTime = itemView.findViewById(R.id.rec_sending_time);
            recMessage = itemView.findViewById(R.id.rec_message_wrapper);
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
            Calendar c = Calendar.getInstance();
            c.setTime(message.getDate());
            if (messages.get(position).isSent()) {
                holder.content.setText(message.getContent());
                holder.time.setText(c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE));
                holder.message.setVisibility(View.VISIBLE);
                holder.recMessage.setVisibility(View.INVISIBLE);
            }
            else {
                holder.recContent.setText(message.getContent());
                holder.recTime.setText(c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE));
                holder.recMessage.setVisibility(View.VISIBLE);
                holder.message.setVisibility(View.INVISIBLE);
            }
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
