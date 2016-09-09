package com.example.tutorial1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tutorial1.backend.UserJava;

import java.util.List;

public class JavaRecyclerView extends RecyclerView.Adapter<JavaRecyclerView.ViewHolder> {

    private List<UserJava> list;
    private Context application;

    public JavaRecyclerView(Context application) {
        this.application = application;
    }

    public void setList(List<UserJava> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        UserJava user = list.get(i);
        viewHolder.author.setText(user.getAuthor());
        viewHolder.vote.setText(user.getVote().toString());
        viewHolder.comments.setText(user.getComments());
        viewHolder.thumbnail.setText(user.getThumbnail());
        viewHolder.more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(application, "Button " + i + " clicked.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.recycler_view_adapter, viewGroup, false);
        return new ViewHolder(itemView);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        protected TextView author;
        protected TextView comments;
        protected TextView vote;
        protected TextView thumbnail;
        protected Button more;

        public ViewHolder(View v) {
            super(v);
            author = (TextView) v.findViewById(R.id.author);
            comments = (TextView) v.findViewById(R.id.comments);
            vote = (TextView) v.findViewById(R.id.vote);
            thumbnail = (TextView) v.findViewById(R.id.thumbnail);
            more = (Button) v.findViewById(R.id.more);
        }
    }

}