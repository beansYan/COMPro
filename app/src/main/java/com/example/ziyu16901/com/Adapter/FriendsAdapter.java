package com.example.ziyu16901.com.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ziyu16901.com.Activity.MessageActivity;
import com.example.ziyu16901.com.Bean.CardData;
import com.example.ziyu16901.com.R;

/**
 * Created by 16901 on 2016/1/6.
 */
public class FriendsAdapter extends RecyclerView.Adapter {


//创建自定义类
class ViewHolder extends RecyclerView.ViewHolder {
    private View fenlei;
    private TextView FenleiTitle;
    private ImageView FenleiImage;


    //绑定子对象视图,关联TextView和ViewHolder
    public ViewHolder(View fenlei) {
        super(fenlei);
        FenleiImage = (ImageView) fenlei.findViewById(R.id.FenleiImage);
        FenleiTitle = (TextView) fenlei.findViewById(R.id.FenleiTitle);
    }

    //返回TextView
    public TextView getFenleiTitle() {
        return FenleiTitle;
    }

}

    @Override
    //创建ViewHoulder类
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //创建ViewHoulder
        //  return new ViewHolder(new TextView(parent.getContext()));
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fenleilist,null));
    }

    @Override
    //给ViewHoulder赋值           ViewHolder                           索引确定子对象条数
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder vh = (ViewHolder) holder;
//                vh.getTv().setText("item"+position);
        vh.getFenleiTitle().setText(data[position]);



//item点击事件，展示详细
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, MessageActivity.class);
                context.startActivity(intent);
            }
        });

        //glide 获取图片
        Glide.with(((ViewHolder) holder).FenleiImage.getContext())
                .load(CardData.getfenleiImage())
                .fitCenter()
                .into(((ViewHolder) holder).FenleiImage);
    }


    @Override
    //获取RecycleView子对象数量
    public int getItemCount() {
//                return 10;
        return data.length;
    }

//定义数组
private String[] data = new String[]{"FRIENDS1", "FRIENDS2", "FRIENDS3", "FRIENDS4", "FRIENDS5", "FRIENDS6",
        "FRIENDS7", "FRIENDS8", "FRIENDS9", "FRIENDS10", "FRIENDS11", "FRIENDS12"


};

}
