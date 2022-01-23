package com.veercreation.vinsta.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.veercreation.vinsta.R;
import com.veercreation.vinsta.adapter.NotificationAdapter;
import com.veercreation.vinsta.adapter.ViewPagerAdapter;
import com.veercreation.vinsta.model.NotificationModel;

import java.util.ArrayList;

public class NotificationInNotificationFragment extends Fragment {
    RecyclerView recyclerviewOfNotification;
    ArrayList<NotificationModel> listOfNotification;

    public NotificationInNotificationFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listOfNotification = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notification_in_notification, container, false);
        recyclerviewOfNotification = view.findViewById(R.id.notificationRV);
        listOfNotification.add(new NotificationModel(R.drawable.profile_icon , "<b>Sweta</b> liked your post" , "just now"));
        listOfNotification.add(new NotificationModel(R.drawable.profile_icon , "<b>Sharma007</b> commented on your post\"" , "just now"));
        listOfNotification.add(new NotificationModel(R.drawable.profile_icon , "is that you should do the work now and you are great man" , "1 minute ago"));
        NotificationAdapter notificationAdapter = new NotificationAdapter(getContext() , listOfNotification);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext() , LinearLayoutManager.VERTICAL , false);
        recyclerviewOfNotification.setLayoutManager(layoutManager);
        recyclerviewOfNotification.setAdapter(notificationAdapter);
        return view;
    }
}