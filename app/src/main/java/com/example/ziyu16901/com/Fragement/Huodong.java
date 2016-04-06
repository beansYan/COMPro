package com.example.ziyu16901.com.Fragement;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ziyu16901.com.Adapter.HuodongAdapter;
import com.example.ziyu16901.com.R;


public class Huodong extends Fragment {
    private View mhuodongView;
    private RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mhuodongView = inflater.inflate(R.layout.fragment_huodong, container, false);
        return mhuodongView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mRecyclerView = (RecyclerView) mhuodongView.findViewById(R.id.hd);
//
        //使用线性布局LinearLayoutManger
        LinearLayoutManager manager = new LinearLayoutManager(mRecyclerView.getContext());
//        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(manager);


        //      mRecyclerView.setAdapter(new FenleiAdapter(getActivity()));

        //创建adapter给recycleview填充内容
        mRecyclerView.setAdapter(new HuodongAdapter());






    }

}
