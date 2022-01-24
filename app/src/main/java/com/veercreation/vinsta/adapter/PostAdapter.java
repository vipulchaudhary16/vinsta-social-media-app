package com.veercreation.vinsta.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.veercreation.vinsta.R;
import com.veercreation.vinsta.model.PostModel;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.viewholder> {

    ArrayList<PostModel> postList;
    Context context;

    public PostAdapter(ArrayList<PostModel> postList, Context context) {
        this.postList = postList;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.dashboard_rv_design , parent , false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        PostModel model = postList.get(position);

    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{
        ImageView profile , postImage , save;
        TextView username , about , likes , comments , share;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            profile = itemView.findViewById(R.id.profile_image_in_post);
            postImage = itemView.findViewById(R.id.postImage);
            save = itemView.findViewById(R.id.saveButton);
            username = itemView.findViewById(R.id.username_in_post);
            about = itemView.findViewById(R.id.about_in_post);
            likes = itemView.findViewById(R.id.likes);
            comments = itemView.findViewById(R.id.comments);
            share = itemView.findViewById(R.id.shareCount);
        }
    }
}
