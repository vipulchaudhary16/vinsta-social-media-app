package com.veercreation.vinsta.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.veercreation.vinsta.R;
import com.veercreation.vinsta.adapter.PostAdapter;
import com.veercreation.vinsta.adapter.StoryAdapter;
import com.veercreation.vinsta.databinding.FragmentHomeBinding;
import com.veercreation.vinsta.model.PostModel;
import com.veercreation.vinsta.model.StoryModel;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;
    RecyclerView storyRV, dashboardRV;
    ArrayList<StoryModel> storyList = new ArrayList<>();
    ArrayList<PostModel> postList = new ArrayList<>();
    PostAdapter postAdapter;

    FirebaseDatabase database;
    FirebaseAuth auth;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        database = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();

        //story recycler view
        storyRV = binding.storyRV;
        StoryAdapter adapter = new StoryAdapter(storyList, getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        storyRV.setLayoutManager(linearLayoutManager);
        storyRV.setNestedScrollingEnabled(false);
        storyRV.setAdapter(adapter);

        //post recycler view
        dashboardRV = binding.dashboardRV;
        postAdapter = new PostAdapter(getContext(), postList);
        LinearLayoutManager linearLayoutManagerForPost = new LinearLayoutManager(getContext());
        dashboardRV.setLayoutManager(linearLayoutManagerForPost);
        dashboardRV.setNestedScrollingEnabled(false);
        dashboardRV.setAdapter(postAdapter);

//        getPosts();

        return binding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();
        getPosts();
    }

    @Override
    public void onResume() {
        super.onResume();
        getPosts();
    }

    public void getPosts() {
        database.getReference()
                .child("posts")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        postList.clear();
                        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                            PostModel postModel = dataSnapshot.getValue(PostModel.class);
                            postList.add(postModel);
                            Log.i("postsize" , postModel.getPostDesc());
                        }
                        postAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
    }
}