package com.example.chatapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactButtonHolder> {
    class ContactButtonHolder extends RecyclerView.ViewHolder {
        private final Button button;

        private ContactButtonHolder(View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.contact_button);
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
            holder.button.setText(contacts.get(position).getNickname());
            holder.button.setOnClickListener(v -> {
                CurrentContact.setCurrentUser(contacts.get(position));
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
