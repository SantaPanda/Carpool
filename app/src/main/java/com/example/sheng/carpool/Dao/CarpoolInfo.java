package com.example.sheng.carpool.Dao;

/**
 * Created by sheng on 16-11-28.
 */
public class CarpoolInfo {
    private String accountID;     //账号
    private String date;          //日期
    private String departure;     //出发点
    private String destination;   //目的地
    private String departureTime;//出发时间
    private int price;             //价格
    private int totalNum;         //总人数
    private int haveNum;          //已有的人数
    private String phoneNum;      //手机号码
    private String detail;        //详细信息
    private String addID;         //要拼车的人的ID
    private String commentID;     //发表评论的人的ID

    public CarpoolInfo(String accountID, String date, String departure, String destination,
                       String departureTime, int price, int totalNum, int haveNum,
                       String phoneNum, String detail, String addID, String commentID) {
        this.accountID = accountID;
        this.date = date;
        this.departure = departure;
        this.destination = destination;
        this.departureTime = departureTime;
        this.price = price;
        this.totalNum = totalNum;
        this.haveNum = haveNum;
        this.phoneNum = phoneNum;
        this.detail = detail;
        this.addID = addID;
        this.commentID = commentID;
    }
}
