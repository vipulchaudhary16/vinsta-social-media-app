package com.veercreation.vinsta.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.veercreation.vinsta.R;
import com.veercreation.vinsta.adapter.PostAdapter;
import com.veercreation.vinsta.adapter.StoryAdapter;
import com.veercreation.vinsta.model.PostModel;
import com.veercreation.vinsta.model.StoryModel;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    RecyclerView storyRV , dashboardRV;
    ArrayList<StoryModel> list;
    ArrayList<PostModel> postList;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        storyRV = view.findViewById(R.id.storyRV);
        list = new ArrayList<>();
        list.add(new StoryModel(R.drawable.sample_01 , R.drawable.profile_icon , "VipulR"));
        list.add(new StoryModel(R.drawable.sample_02 , R.drawable.profile_icon , "VipulR"));
        list.add(new StoryModel(R.drawable.sample_03 , R.drawable.profile_icon , "VipulR"));

        StoryAdapter adapter = new StoryAdapter(list , getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext() , LinearLayoutManager.HORIZONTAL , false);
        storyRV.setLayoutManager(linearLayoutManager);
        storyRV.setNestedScrollingEnabled(false);
        storyRV.setAdapter(adapter );

        dashboardRV = view.findViewById(R.id.dashboardRV);
        postList = new ArrayList<>();

        postList.add(new PostModel(R.drawable.sample_01 , R.drawable.sample_01 , R.drawable.plus ,"Vipul.js" , "Developer" , "56" , "123" , "0" ));
        postList.add(new PostModel(R.drawable.sample_01 , R.drawable.sample_02 , R.drawable.plus ,"Vipul.js" , "Developer" , "56" , "123" , "0" ));
        postList.add(new PostModel(R.drawable.sample_01 , R.drawable.sample_03 , R.drawable.plus ,"Vipul.js" , "Developer" , "56" , "123" , "0" ));

        PostAdapter postAdapter = new PostAdapter(postList , getContext());
        LinearLayoutManager linearLayoutManagerForPost = new LinearLayoutManager(getContext() );
        dashboardRV.setLayoutManager(linearLayoutManagerForPost);
        dashboardRV.setNestedScrollingEnabled(false);
        dashboardRV.setAdapter(postAdapter);

        return view;
    }
}