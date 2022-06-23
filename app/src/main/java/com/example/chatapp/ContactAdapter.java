package com.example.chatapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Calendar;
import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactButtonHolder> {
    class ContactButtonHolder extends RecyclerView.ViewHolder {
        private final CardView button;
        private final TextView name;
        private final TextView lastMessage;
        private final TextView time;
        private final TextView date;
        private ContactButtonHolder(View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.ChangedImageView);
            name = itemView.findViewById(R.id.contactNameButton);
            lastMessage = itemView.findViewById(R.id.lastMessageButton);
            time = itemView.findViewById(R.id.lastMessageTimeButton);
            date = itemView.findViewById(R.id.lastMessageDateButton);
        }
    }

    private final LayoutInflater inflater;
    private List<Contact> contacts;
    private Context context;

    public ContactAdapter(Context context) {
        inflater = LayoutInflater.from(context);
        this.context = context;
    }

    public ContactButtonHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.contact_button, parent, false);
        return new ContactButtonHolder(itemView);
    }

    public void onBindViewHolder(ContactButtonHolder holder, int position) {
        if (contacts != null) {
            final Contact contact = contacts.get(position);
            //holder.button.setText(contacts.get(position).getNickname());
            holder.name.setText("\n" + contact.getNickname());
            if (contact.getLastMessage() != null) {
                if (contact.getLastMessage().length()>20)
                    holder.lastMessage.setText(contact.getLastMessage().substring(0,17) + "...");
                else
                    holder.lastMessage.setText(contact.getLastMessage());
                Calendar c = Calendar.getInstance();
                c.setTime(contact.getLastDate());
                holder.time.setText("\n\n" + c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE));
                holder.date.setText(c.get(Calendar.DAY_OF_MONTH) + "/" + c.get(Calendar.MONTH) + "/" + c.get(Calendar.YEAR));
            }
            else {
                holder.lastMessage.setText("");
                holder.time.setText("");
                holder.date.setText("");
            }
            holder.button.setOnClickListener(v -> {
                CurrentContact.setCurrentContact(contacts.get(position));
                Intent intent = new Intent(context, ChatActivity.class);
                context.startActivity(intent);
            });
        }
    }

    public int getItemCount() {
        if (contacts == null)
            return 0;
        return contacts.size();
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
        notifyDataSetChanged();
    }

    public List<Contact> getContacts() {
        return contacts;
    }
}
