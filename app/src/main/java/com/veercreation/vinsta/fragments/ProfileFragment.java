package com.veercreation.vinsta.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.veercreation.vinsta.R;
import com.veercreation.vinsta.adapter.FriendAdapter;
import com.veercreation.vinsta.model.FriendModel;

import java.util.ArrayList;

public class ProfileFragment extends Fragment {

    RecyclerView myFriendsRV;
    ArrayList<FriendModel> myFriendList;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_profile, container, false);
        myFriendsRV = view.findViewById(R.id.myFriendRV);
        myFriendList = new ArrayList<>();

        myFriendList.add(new FriendModel(R.drawable.sample_01));
        myFriendList.add(new FriendModel(R.drawable.sample_02));
        myFriendList.add(new FriendModel(R.drawable.sample_03));
        myFriendList.add(new FriendModel(R.drawable.sample_02));
        myFriendList.add(new FriendModel(R.drawable.sample_02));
        myFriendList.add(new FriendModel(R.drawable.sample_01));
        myFriendList.add(new FriendModel(R.drawable.sample_03));
        myFriendList.add(new FriendModel(R.drawable.sample_01));
        myFriendList.add(new FriendModel(R.drawable.sample_01));
        myFriendList.add(new FriendModel(R.drawable.sample_01));
        myFriendList.add(new FriendModel(R.drawable.sample_01));
        myFriendList.add(new FriendModel(R.drawable.sample_01));

        FriendAdapter friendAdapter = new FriendAdapter(myFriendList  , getContext());
        LinearLayoutManager myFriendRvManager = new LinearLayoutManager(getContext() , LinearLayoutManager.HORIZONTAL , false );

        myFriendsRV.setLayoutManager(myFriendRvManager);;
        myFriendsRV.setAdapter(friendAdapter);

        return view;
    }
}