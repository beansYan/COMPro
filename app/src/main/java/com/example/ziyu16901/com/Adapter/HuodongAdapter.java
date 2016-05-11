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
import com.example.ziyu16901.com.Bean.CardData;
import com.example.ziyu16901.com.Activity.Huodong_detail;
import com.example.ziyu16901.com.R;

/**
 * Created by 16901 on 2015/12/21.
 */
public class HuodongAdapter extends RecyclerView.Adapter {


    //创建自定义类
    class ViewHolder extends RecyclerView.ViewHolder {
       // private View Card;
        private TextView CaTitle,CaOrganization,CaTime;
        private ImageView CaImage;

        //绑定子对象视图,关联TextView和ViewHolder
        public ViewHolder(View huodong) {
            super(huodong);

       //获取布局控件
         CaImage = (ImageView) huodong.findViewById(R.id.CaImage);
            CaTitle = (TextView) huodong.findViewById(R.id.CaTitle);
            CaOrganization = (TextView) huodong.findViewById(R.id.CaOrganization);
            CaTime = (TextView) huodong.findViewById(R.id.CaTime);
        }


        public TextView getCaTime() {
            return CaTime;
        }

        public TextView getCaOrganization() {
            return CaOrganization;
        }

        public TextView getCaTitle() {
            return CaTitle;
        }

//        public ImageView getCaImage() {
//            return CaImage;
//        }

    }

    @Override
    //创建ViewHoulder类
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //创建ViewHoulder      //创建一个布局解释器
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_huodonglist,parent,false));
    }

    @Override
    //给ViewHoulder赋值           ViewHolder                           索引确定子对象条数
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        ViewHolder vh = (ViewHolder) holder;
//                vh.getTv().setText("item"+position);
        //展示数据
          CardData cd = data[position];

        vh.getCaTitle().setText(cd.title);
        vh.getCaOrganization().setText(cd.organization);
        vh.getCaTime().setText(cd.time);


//item点击事件，展示详细
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, Huodong_detail.class);
                context.startActivity(intent);
            }
        });

        //glide 获取图片
        Glide.with(((ViewHolder) holder).CaImage.getContext())
                .load(CardData.getHuodongImage())
                .fitCenter()
                .into(((ViewHolder) holder).CaImage);
    }



    @Override
    //获取RecycleView子对象数量
    public int getItemCount() {
//                return 10;
        return data.length;
    }

    //定义数组
//    private String[] data = new String[]{"文学艺术", "体育休闲", "社会实践", "理论研究", "技能培养", "学术科技"};
private CardData[] data = new CardData[]{
            new CardData("青春开讲啦","团工委","10月20日"),
            new CardData("青春开讲啦2","团工委2","10月21日"),
            new CardData("青春开讲啦3","团工委3","10月23日"),
            new CardData("青春开讲啦4","团工委4","10月24日"),
            new CardData("青春开讲啦5","团工委5","10月25日"),
            new CardData("青春开讲啦6","团工委6","10月26日"),
            new CardData("青春开讲啦7","团工委7","10月27日"),
            new CardData("青春开讲啦8","团工委8","10月28日"),
            new CardData("青春开讲啦9","团工委9","10月29日"),
            new CardData("青春开讲啦11","团工委10","1月30日"),
            new CardData("青春开讲啦12","团工委11","2月28日"),
            new CardData("青春开讲啦13","团工委12","3月30日"),
            new CardData("青春开讲啦14","团工委13","4月30日"),
            new CardData("青春开讲啦15","团工委14","5月30日"),
            new CardData("青春开讲啦16","团工委15","6月30日"),
            new CardData("青春开讲啦17","团工委16","7月30日"),
            new CardData("青春开讲啦18","团工委17","8月30日"),
            new CardData("青春开讲啦19","团工委18","9月30日"),
            new CardData("青春开讲啦20","团工委19","10月30日"),

    };







}



