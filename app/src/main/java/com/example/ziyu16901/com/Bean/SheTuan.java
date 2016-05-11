package com.example.ziyu16901.com.Bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by yan on 16/4/20.
 */
public class SheTuan extends BmobObject{
    private String id;      //社团ID
    private String username;  //社团成员
    private String name;    //社团名称
    private String leibie;  //社团类别
    private String guakao;  //挂靠单位
    private String chair;   //理事长
    private String vice_chair; //团支书
    private String jianjie;  //简介
    private String activity;  //活动



    public String getVice_chair() {
        return vice_chair;
    }

    public void setVice_chair(String vice_chair) {
        this.vice_chair = vice_chair;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String usename) {
        this.username = username;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getChair() {
        return chair;
    }

    public void setChair(String chair) {
        this.chair = chair;
    }

    public String getGuakao() {
        return guakao;
    }

    public void setGuakao(String guakao) {
        this.guakao = guakao;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJianjie() {
        return jianjie;
    }

    public void setJianjie(String jianjie) {
        this.jianjie = jianjie;
    }

    public String getLeibie() {
        return leibie;
    }

    public void setLeibie(String leibie) {
        this.leibie = leibie;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




}
