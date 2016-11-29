package com.example.sheng.carpool.Dao;

/**
 * Created by sheng on 16-11-28.
 */
public class CommentInfo {
    private int accountID;     //发表评论的人的ID
    private int carpoolID;     //所针对的拼车信息的ID
    private int aimCommentID;  //所回复的评论的ID
    private String detail;     //学校信息

    public CommentInfo(int accountID, int carpoolID, int aimCommentID, String detail) {
        this.accountID = accountID;
        this.carpoolID = carpoolID;
        this.aimCommentID = aimCommentID;
        this.detail = detail;
    }
}
