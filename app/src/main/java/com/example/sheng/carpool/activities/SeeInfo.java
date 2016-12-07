package com.example.sheng.carpool.activities;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.TextView;

import com.example.sheng.carpool.R;

public class SeeInfo extends Activity {

    private TextView see_info_name;
    private TextView see_info_nickname;
    private TextView see_info_sex;
    private TextView see_info_phone;
    private TextView see_info_wechat;
    private TextView see_info_qq;
    private TextView see_info_good;
    private TextView see_info_bad;
    private TextView see_info_show_other;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_info);
        componentInit();
    }
    /*
    private void setValue(){
        see_info_name;
        see_info_nickname;
        see_info_sex;
        see_info_phone;
        see_info_wechat;
        see_info_qq;
        see_info_good;
        see_info_bad;
        see_info_show_other;
    }
    */
    private void componentInit(){
        see_info_name = (TextView)findViewById(R.id.see_info_name);
        see_info_nickname = (TextView)findViewById(R.id.see_info_nickname);
        see_info_sex = (TextView)findViewById(R.id.see_info_sex);
        see_info_phone = (TextView)findViewById(R.id.see_info_phone);
        see_info_wechat = (TextView)findViewById(R.id.see_info_wechat);
        see_info_qq = (TextView)findViewById(R.id.see_info_qq);
        see_info_bad = (TextView)findViewById(R.id.see_info_bad);
        see_info_show_other = (TextView)findViewById(R.id.see_info_show_other);
    }
}
