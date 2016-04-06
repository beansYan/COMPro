package com.example.ziyu16901.com.Bean;

import com.example.ziyu16901.com.R;

import java.util.Random;

/**
 * Created by 16901 on 2015/12/21
 */
public class CardData {

    public CardData(String title,String organization,String time){
//        this.image = image;
        this.title = title;
        this.organization = organization;
        this.time = time;
    }
//    public String image = "image";
    public String title = "title";
    public String organization ="organization";
    public String time ="time";

    //定义一个随机图片显示
    private static final Random RANDOM = new Random();

    public static int getHuodongImage() {
        switch (RANDOM.nextInt(8)) {
            default:
            case 0:
                return R.drawable.g51;
            case 1:
                return R.drawable.g57;
            case 2:
                return R.drawable.g66;
            case 3:
                return R.drawable.g67;
            case 4:
                return R.drawable.g69;
            case 5:
                return R.drawable.g75;
            case 6:
                return R.drawable.g79;
            case 7:
                return R.drawable.g80;
        }
    }

    public static int getfenleiImage() {
        switch (RANDOM.nextInt(6)) {
            default:
            case 0:
                return R.drawable.finger_1;
            case 1:
                return R.drawable.finger_2;
            case 2:
                return R.drawable.finger_3;
            case 3:
                return R.drawable.finger_4;
            case 4:
                return R.drawable.finger_5;
            case 5:
                return R.drawable.finger_6;
        }
    }
}
