package com.mobdev.class_retrofit_with_rest_api;

import android.content.Context;
import android.os.PowerManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobdev.class_retrofit_with_rest_api.Model.Post;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    List<Post> itemResponseList;
    Context context;

    public ItemAdapter(Context context, List<Post> itemResponseList) {
        this.itemResponseList = itemResponseList;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_holder,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Post post = itemResponseList.get(position);

        holder.id.setText("ID : "+post.getId());
        holder.userId.setText("Post ID : "+post.getUserId());
        holder.title.setText("Title : "+post.getTitle());
        holder.text.setText("Text : "+post.getText());
    }

    @Override
    public int getItemCount() {
        return itemResponseList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView id,userId,title,text;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.textView_id);
            userId = itemView.findViewById(R.id.textView_userId);
            title = itemView.findViewById(R.id.textView_title);
            text =itemView.findViewById(R.id.textView_text);
        }
    }
}
