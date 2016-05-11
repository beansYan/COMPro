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

import com.example.ziyu16901.com.Activity.Fenlei_Detail;
import com.example.ziyu16901.com.Bean.CardData;
import com.example.ziyu16901.com.R;

/**
 * Created by 16901 on 2015/12/20.
 */
public class FenleiAdapter extends RecyclerView.Adapter {


    //定义数组
    private String[] data = new String[]{"文学艺术", "体育休闲", "社会实践", "理论研究", "技能培养", "学术科技"};

    @Override
    //创建ViewHoulder类
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //创建ViewHoulder
        //  return new ViewHolder(new TextView(parent.getContext()));
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fenleilist, parent, false));
    }

    @Override
    //给ViewHoulder赋值           ViewHolder                           索引确定子对象条数
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ViewHolder vh = (ViewHolder) holder;
//                vh.getTv().setText("item"+position);
        vh.getFenleiTitle().setText(data[position]);


//item点击事件，展示详细
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, Fenlei_Detail.class);
                //用bundle携带数据
//                Bundle bundle= new Bundle();
                if (data[position] == "文学艺术") {
                    intent.putExtra("leibie", "文学艺术类");

                } else if (data[position] == "体育休闲") {
                    intent.putExtra("leibie", "体育休闲类");

                } else if (data[position] == "社会实践") {
                    intent.putExtra("leibie", "社会实践类");
//                    intent.putExtras(bundle);
                } else if (data[position] == "理论研究") {
                    intent.putExtra("leibie", "理论研究类");

                } else if (data[position] == "技能培养") {
                    intent.putExtra("leibie", "技能培养类");

                } else if (data[position] == "学术科技") {
                    intent.putExtra("leibie", "学术科技类");

                }
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


}