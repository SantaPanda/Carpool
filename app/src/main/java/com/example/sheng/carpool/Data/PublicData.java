package com.example.sheng.carpool.Data;

import android.text.InputFilter;
import android.text.Spanned;
import android.widget.EditText;

/**
 * Created by sheng on 16-11-26.
 */
public class PublicData {

    private static final String server = "http://172.22.5.200:8080/CarpoolWeb_war_exploded/";
    public static final String loginServer = server +"net-work";
    public static final String registerServer = server+"net-work";
    public static final String myInfoServer = server+"networks-myinfo";
    public static final String publishServer = server+"net-publish";
    public static final String firstproject ="http://172.22.5.200:8080/firstProject_war_exploded/server-plus-demo";
    public static final int clientStoreNum =10;   //手机数据库存储10条信息
    public static final String TRUE_RETURN = "true";
    public static final String FALSE_RETURN = "false";

    //设置EditText是否可以编辑
    public static void changeEditState(boolean value, EditText editText) {
        if (value) {
            editText.setFocusable(true);
            editText.setFocusableInTouchMode(true);
            editText.setFilters(new InputFilter[] { new InputFilter() {
                @Override
                public CharSequence filter(CharSequence source, int start,
                                           int end, Spanned dest, int dstart, int dend) {
                    return null;
                }
            } });
        }
        else {
            editText.setFocusable(false);
            editText.setFocusableInTouchMode(false);
            //输入框无法输入新的内容
            /*
            editText.setFilters(new InputFilter[] { new InputFilter() {
                @Override
                public CharSequence filter(CharSequence source,
                                           int start, int end, Spanned dest, int dstart, int dend) {
                    return source.length() < 1 ? dest.subSequence(dstart, dend) : "";
                }
            } });
            */
        }
    }

    //判断EditText是否可编辑
    private boolean isEdit(){
        return false;
    }





}
