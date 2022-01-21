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
import com.veercreation.vinsta.model.FriendModel;
import com.veercreation.vinsta.model.StoryModel;

import java.util.ArrayList;

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.viewHolder> {
ArrayList<FriendModel> list;
Context context;

    public FriendAdapter(ArrayList<FriendModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.friend_rv_sample , parent , false);
        return new viewHolder((view));
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
    FriendModel model = list.get(position);
    holder.friendProfile.setImageResource(model.getPicture());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        ImageView friendProfile;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            friendProfile = itemView.findViewById(R.id.users_friend_photo);
        }
    }


}
