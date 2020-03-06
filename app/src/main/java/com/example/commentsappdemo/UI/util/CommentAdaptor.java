package com.example.commentsappdemo.UI.util;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.commentsappdemo.R;
import com.example.commentsappdemo.model.Comments;
import java.util.ArrayList;
import java.util.List;

public class CommentAdaptor extends RecyclerView.Adapter<CommentAdaptor.RowViewHolder> {



    class RowViewHolder extends  RecyclerView.ViewHolder{

        private TextView tvUser;
        private TextView tvContent;

        public RowViewHolder(@NonNull View itemView) {
            super(itemView);

            tvUser = itemView.findViewById(R.id.tv_user);
            tvContent = itemView.findViewById(R.id.tv_content);

        }

    }

    private List<Comments>items;

    public CommentAdaptor() {
        items = new ArrayList<>();

    }

    @NonNull
    @Override
    public RowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_row, parent, false);
        return new RowViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull RowViewHolder holder, int position) {

        Comments c = items.get(position);

        holder.tvUser.setText(c.getUserName());
        holder.tvContent.setText(c.getContent());

    }

    @Override
    public int getItemCount() {
        return items.size();

    }

    public  void  addItems(List<Comments> newItems ){

        items.clear();
        items.addAll(newItems);

    }

}
