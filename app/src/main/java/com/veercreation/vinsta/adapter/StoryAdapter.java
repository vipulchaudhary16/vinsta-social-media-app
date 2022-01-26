package com.veercreation.vinsta.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;
import com.veercreation.vinsta.R;
import com.veercreation.vinsta.databinding.StoryRvDesignBinding;
import com.veercreation.vinsta.model.StoryModel;
import com.veercreation.vinsta.model.User;
import com.veercreation.vinsta.model.UserStories;

import java.util.ArrayList;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.viewHolder> {

    ArrayList<StoryModel> list;
    Context context;

    public StoryAdapter(ArrayList<StoryModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.story_rv_design, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        StoryModel storyModel = list.get(position);
        if(!storyModel.getStories().isEmpty()) {


            UserStories lastStories = storyModel.getStories()
                    .get(0);
            if (storyModel.getStories().size() >= 2) {
                lastStories = storyModel.getStories()
                        .get(storyModel.getStories().size() - 1);
            }
            Picasso.get()
                    .load(lastStories.getImageUrl())
                    .placeholder(R.drawable.user)
                    .into(holder.binding.storyImage);
            holder.binding.storyCircleView.setPortionsCount(storyModel.getStories().size());
            FirebaseDatabase.getInstance()
                    .getReference()
                    .child("Users")
                    .child(storyModel.getStoryBy())
                    .addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            User user = snapshot.getValue(User.class);
                            Picasso.get()
                                    .load(user.getProfile_picture())
                                    .placeholder(R.drawable.user)
                                    .into(holder.binding.profileImageInStory);

                            holder.binding.usernameInStoryCard.setText(user.getName());

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        StoryRvDesignBinding binding;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            binding = StoryRvDesignBinding.bind(itemView);

        }
    }
}
