package com.veercreation.vinsta.adapter;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.veercreation.vinsta.R;
import com.veercreation.vinsta.model.NotificationModel;

import java.util.ArrayList;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.viewHolder> {
    ArrayList<NotificationModel> notificationModelArrayList;
    Context context;

    public NotificationAdapter( Context context , ArrayList<NotificationModel> notificationModelArrayList) {
        this.notificationModelArrayList = notificationModelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.notification_rv_design, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        NotificationModel model = notificationModelArrayList.get(position);
        holder.notification.setText(Html.fromHtml(model.getNotification()));
        holder.notificationTime.setText(model.getTime());
        holder.profilePic.setImageResource(model.getProfilePic());
    }

    @Override
    public int getItemCount() {
        return notificationModelArrayList.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {
        TextView notification;
        TextView notificationTime;
        ImageView profilePic;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            notification = itemView.findViewById(R.id.notificationTextView);
            notificationTime = itemView.findViewById(R.id.notificationTime);
            profilePic = itemView.findViewById(R.id.users_photo_in_notification);
        }
    }
}
