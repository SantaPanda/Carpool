package com.example.sheng.carpool.localDatabase;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.TabHost;
import android.widget.Toast;

import com.example.sheng.carpool.Dao.MyInfo;
/**
 * Created by sheng on 2016/11/19.
 */
/*
public class OperateDatabase {

    private MyInfo myInfo;
    public OperateDatabase() { }
    public OperateDatabase(MyInfo myInfo){
        this.myInfo = myInfo;
    }
    private CreatDataBase creatDataBase;
    //插入
    public void insert(CreatDataBase creatDataBase){
        this.creatDataBase = creatDataBase;
        SQLiteDatabase db = creatDataBase.getWritableDatabase();
        String sql = "insert into carpool(account,date,departure,destination,departureTime," +
                "arriveTime,lackNum,detail,phoneNum,issueTime,likeNum,addID ,commentID) "+
                "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        db.execSQL(sql, new String[]{shareInfo.getAccount(),shareInfo.getDate()+"", shareInfo.getDeparture(),
            shareInfo.getDestination(), shareInfo.getDepartureTime()+"", shareInfo.getArriveTime()+"",
            shareInfo.getLackNum()+"", shareInfo.getDetail(), shareInfo.getPhoneNum()+"",
            shareInfo.getIssueTime()+"", shareInfo.getLikeNum()+"", shareInfo.getAddID(),
            shareInfo.getCommentID()});
    }
    //删除
    public void delete(){

    }
    //查询
    public ShareInfo[] query(CreatDataBase creatDataBase){
        String account,date,departure,destination,departureTime,arriveTime,lackNum;
        String detail,phoneNum,issueTime,likeNum,addID ,commentID;
        this.creatDataBase= creatDataBase;
        String temp = "";
        int i=0;
        ShareInfo []shareInfos = new ShareInfo[PublicData.clientStoreNum];
        for(i=0;i< PublicData.clientStoreNum;i++){
            shareInfos[i] = new ShareInfo("","","","","","",0,"","","",0,"","");
        }
        SQLiteDatabase db = creatDataBase.getWritableDatabase();
        Cursor cursor= db.rawQuery("select * from carpool",null);
        i=0;
        if(cursor.moveToFirst()){
            do{
                account=cursor.getString(cursor.getColumnIndex("account"));
                date=cursor.getString(cursor.getColumnIndex("date"));
                departure=cursor.getString(cursor.getColumnIndex("departure"));
                destination=cursor.getString(cursor.getColumnIndex("destination"));
                departureTime=cursor.getString(cursor.getColumnIndex("departureTime"));
                arriveTime=cursor.getString(cursor.getColumnIndex("arriveTime"));
                lackNum=cursor.getString(cursor.getColumnIndex("lackNum"));
                detail=cursor.getString(cursor.getColumnIndex("detail"));
                phoneNum=cursor.getString(cursor.getColumnIndex("phoneNum"));
                issueTime=cursor.getString(cursor.getColumnIndex("issueTime"));
                likeNum=cursor.getString(cursor.getColumnIndex("likeNum"));
                addID=cursor.getString(cursor.getColumnIndex("addID"));
                commentID=cursor.getString(cursor.getColumnIndex("commentID"));

                shareInfos[i]= new ShareInfo(account,date,departure,destination,departureTime,arriveTime,Integer.parseInt(lackNum),
                        detail,phoneNum,issueTime,Integer.parseInt(likeNum),addID ,commentID);
                i++;
            }while (cursor.moveToNext());
            cursor.close();
        }
        return shareInfos;
    }
    //删除

    //
}
*/