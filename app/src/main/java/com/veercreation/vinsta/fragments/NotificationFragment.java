package com.veercreation.vinsta.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.veercreation.vinsta.R;
import com.veercreation.vinsta.adapter.ViewPagerAdapter;
import com.veercreation.vinsta.databinding.FragmentNotificationBinding;
import com.veercreation.vinsta.databinding.FragmentProfileBinding;

public class NotificationFragment extends Fragment {

    ViewPager viewPager;
    TabLayout tabLayout;
    FragmentNotificationBinding binding;

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
        binding = FragmentNotificationBinding.inflate(inflater, container, false);
        viewPager = binding.viewPagerInNotificationFragment;

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        assert getFragmentManager() != null;
        viewPager.setAdapter(new ViewPagerAdapter(getFragmentManager()));
        tabLayout = binding.notificationTabLayout;
        tabLayout.setupWithViewPager(viewPager);
    }
}