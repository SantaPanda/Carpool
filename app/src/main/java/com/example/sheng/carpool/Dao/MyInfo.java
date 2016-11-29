package com.example.sheng.carpool.Dao;

/**
 * Created by sheng on 16-11-28.
 */
public class MyInfo {
    private String account;
    private String password;
    private String headPortrait;
    private String name;
    private String nickname;
    private String sex;
    private String phone;
    private String wechat;
    private String qq;
    private int good;
    private int bad;
    private String introduce;   //自我介绍
    private String addID;       //添加的拼车ID
    private String commentID;   //评论的拼车ID

    public MyInfo(String account, String password, String headPortrait, String name,
                  String nickname, String sex, String phone, String wechat, String qq,
                  int good, int bad, String introduce, String addID, String commentID) {
        this.account = account;
        this.password = password;
        this.headPortrait = headPortrait;
        this.name = name;
        this.nickname = nickname;
        this.sex = sex;
        this.phone = phone;
        this.wechat = wechat;
        this.qq = qq;
        this.good = good;
        this.bad = bad;
        this.introduce = introduce;
        this.addID = addID;
        this.commentID = commentID;
    }



}
