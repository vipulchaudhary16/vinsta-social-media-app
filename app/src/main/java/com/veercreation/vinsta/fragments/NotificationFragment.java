package com.veercreation.vinsta.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.veercreation.vinsta.R;
import com.veercreation.vinsta.adapter.ViewPagerAdapter;

public class NotificationFragment extends Fragment {

    ViewPager viewPager;
    TabLayout tabLayout;

    public NotificationFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notification, container, false);
        viewPager = view.findViewById(R.id.viewPagerInNotificationFragment);
        assert getFragmentManager() != null;
        viewPager.setAdapter(new ViewPagerAdapter(getFragmentManager()));
        tabLayout = view.findViewById(R.id.notificationTabLayout);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }
}