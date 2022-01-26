package com.veercreation.vinsta.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.FirebaseDatabase;
import com.veercreation.vinsta.R;
import com.veercreation.vinsta.databinding.CommentSampleBinding;
import com.veercreation.vinsta.model.Comment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.viewHolder> {
    Context context;
    ArrayList<Comment> comments;

    public CommentAdapter(Context context, ArrayList<Comment> comments) {
        this.comments = comments;
        this.context = context;
    }


    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.comment_sample, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Comment comment = comments.get(position);
        holder.binding.commentBody.setText(comment.getCommentBody());
        holder.binding.commentTime.setText(setCommentTime(comment.getCommentedAt()));

    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {
        CommentSampleBinding binding;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            binding = CommentSampleBinding.bind(itemView);
        }
    }

    private String setCommentTime(Long commentTime){
        long currentTime = new Date().getTime();
        long timeGap = (currentTime-commentTime)/60000;
        if(timeGap==0){
            return  "just now";
        }
        if(timeGap<=60){
            return timeGap +" min";
        } else {
            DateFormat formatter = new SimpleDateFormat("HH:mm:aa dd-MMM");
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(commentTime);
            return formatter.format(calendar.getTime());
        }
    }
}
