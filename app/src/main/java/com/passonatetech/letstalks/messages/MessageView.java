package com.passonatetech.letstalks.messages;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.passonatetech.letstalks.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MessageView extends RecyclerView.Adapter<MessageView.MyViewHolder> {

    private final List<MessagesList> messagesList;
    private final Context context;
    public MessageView(List<MessagesList> messagesList, Context context) {
        this.messagesList = messagesList;
        this.context = context;
    }

    @NonNull
    @Override
    public MessageView.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.messages_layout,null));
    }

    @Override
    public void onBindViewHolder(@NonNull MessageView.MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return messagesList.size();

    }
    //constructor created
    static class MyViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView profilePic;
        private TextView name,lastMessage,UnseenMessage;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            profilePic=itemView.findViewById(R.id.dp);
            name=itemView.findViewById(R.id.name);
            lastMessage=itemView.findViewById(R.id.lastMessage);
            UnseenMessage=itemView.findViewById(R.id.unseenMessage);
        }
    }
}
