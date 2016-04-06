package com.example.ziyu16901.com.Fragement;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ziyu16901.com.Adapter.FenleiAdapter;
import com.example.ziyu16901.com.Adapter.FriendsAdapter;
import com.example.ziyu16901.com.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Friends.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Friends#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Friends extends Fragment {

    private View mFriendsView;
    private RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mFriendsView = inflater.inflate(R.layout.fragment_friends, container, false);
        return mFriendsView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mRecyclerView = (RecyclerView) mFriendsView.findViewById(R.id.fl);
//
        //使用线性布局LinearLayoutManger
        LinearLayoutManager manager = new LinearLayoutManager(mRecyclerView.getContext());
//        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(manager);


        //      mRecyclerView.setAdapter(new FenleiAdapter(getActivity()));

        //创建adapter给recycleview填充内容
        mRecyclerView.setAdapter(new FriendsAdapter());






    }

}

