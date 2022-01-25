package com.veercreation.vinsta.adapter;

import android.content.Context;
import android.provider.ContactsContract;
import android.text.Html;
import android.util.Log;
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
import com.veercreation.vinsta.databinding.DashboardRvDesignBinding;
import com.veercreation.vinsta.model.PostModel;
import com.veercreation.vinsta.model.User;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.viewholder> {

    ArrayList<PostModel> postList;
    Context context;
    DateFormat dateFormatter = new SimpleDateFormat("hh:mm:aa dd-MMM");


    public PostAdapter(Context context, ArrayList<PostModel> postList) {
        this.postList = postList;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.dashboard_rv_design, parent, false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        PostModel model = postList.get(position);
        try {
            Picasso.get()
                    .load(model.getPostImage())
                    .placeholder(R.drawable.sample_cover)
                    .into(holder.binding.postImage);


            FirebaseDatabase.getInstance().getReference()
                    .child("Users")
                    .child(model.getPostedBy())
                    .addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            User user = snapshot.getValue(User.class);
                            Picasso.get()
                                    .load(user.getProfile_picture())
                                    .placeholder(R.drawable.user)
                                    .into(holder.binding.profileImageInPost);
                            holder.binding.usernameInPost.setText(user.getName());
                            holder.binding.postTime.setText(dateFormatter.format(Long.parseLong(model.getPostedAt())));
                            String postDesc =" <b>" + user.getName()+ "</b> " + model.getPostDesc();
                            holder.binding.postDesc.setText(Html.fromHtml(postDesc));
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
        } catch (Exception e) {
            Log.i("postsize", e.toString());
        }
    }

    @Override
    public int getItemCount() {
        Log.i("postsize", postList.size() + "");
        return postList.size();
    }

    public static class viewholder extends RecyclerView.ViewHolder {
        DashboardRvDesignBinding binding;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            binding = DashboardRvDesignBinding.bind(itemView);
        }
    }
}
