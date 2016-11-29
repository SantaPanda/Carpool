package com.example.sheng.carpool.activities;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Cache;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.sheng.carpool.Data.PublicData;
import com.example.sheng.carpool.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;


public class MyInfoFragment extends Fragment {

    private View view;
    private EditText my_info_name;
    private EditText my_info_nickname;
    private EditText my_info_sex;
    private EditText my_info_phone;
    private EditText my_info_wechat;
    private EditText my_info_qq;
    private EditText my_info_show_me;
    private ImageButton my_info_change_ok;
    private ImageButton exit;
    private TextView my_info_good;
    private TextView my_info_bad;
    private TextView my_info_credit;
    private RequestQueue mRequestQueue;
    private final String url=PublicData.myInfoServer;
    private String str_my_info_name,str_my_info_nickname,str_my_info_sex,str_my_info_phone;
    private String str_my_info_wechat,str_my_info_qq,str_my_info_show_me;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_my_info, container, false);
        componentInit();
        myInfoServer();
        return view;
    }

    //组件初始化，为组件监听
    private void componentInit(){
        my_info_good = (TextView)view.findViewById(R.id.my_info_good);
        my_info_bad = (TextView)view.findViewById(R.id.my_info_bad);
        my_info_credit = (TextView)view.findViewById(R.id.my_info_credit);
        my_info_name = (EditText) view.findViewById(R.id.my_info_name);
        my_info_nickname = (EditText) view.findViewById(R.id.my_info_nickname);
        my_info_sex = (EditText) view.findViewById(R.id.my_info_sex);
        my_info_phone = (EditText) view.findViewById(R.id.my_info_phone);
        my_info_wechat = (EditText) view.findViewById(R.id.my_info_wechat );
        my_info_qq = (EditText) view.findViewById(R.id.my_info_qq);
        my_info_show_me = (EditText) view.findViewById(R.id.my_info_show_me);
        my_info_change_ok = (ImageButton)view.findViewById(R.id.my_info_change_ok);
        my_info_change_ok.setOnClickListener(new buttonListener());
        exit = (ImageButton)view.findViewById(R.id.exit);
        exit.setOnClickListener(new buttonListener());
    }
    private void getValue(){
        str_my_info_name=my_info_name.getText().toString();
        str_my_info_nickname=my_info_nickname.getText().toString();
        str_my_info_sex=my_info_sex.getText().toString();
        str_my_info_phone=my_info_phone.getText().toString();
        str_my_info_wechat=my_info_wechat.getText().toString();
        str_my_info_qq=my_info_qq.getText().toString();
        str_my_info_show_me=my_info_show_me.getText().toString();
    }
    //设置所有EditText是否可编辑
    private void changeEdit(boolean flag){
        PublicData.changeEditState(flag,my_info_name);
        PublicData.changeEditState(flag,my_info_nickname);
        PublicData.changeEditState(flag,my_info_sex);
        PublicData.changeEditState(flag,my_info_phone);
        PublicData.changeEditState(flag,my_info_wechat);
        PublicData.changeEditState(flag,my_info_qq);
        PublicData.changeEditState(flag,my_info_show_me);
    }
    //解析JsonObject
    private void parseJsonObject(JSONObject jsonObject){
        String str_good="", str_bad="";
        double double_credit = 0.0;
        try {
            my_info_name.setText(jsonObject.getString("name"));
            my_info_nickname.setText(jsonObject.getString("nickName"));
            my_info_sex.setText(jsonObject.getString("sex"));
            my_info_phone.setText(jsonObject.getString("phoneNum"));
            my_info_wechat.setText(jsonObject.getString("weChat"));
            my_info_qq.setText(jsonObject.getString("qq"));
            my_info_show_me.setText(jsonObject.getString("introduce"));
            str_good=jsonObject.getString("good");
            str_bad=jsonObject.getString("bad");
            my_info_good.setText(str_good);
            my_info_bad.setText(str_bad);
            DecimalFormat df = new DecimalFormat(".00");
            double_credit= 100*Double.parseDouble(str_good)/(Integer.parseInt(str_good)+Integer.parseInt(str_bad));
            my_info_credit.setText(""+df.format(double_credit)+"%");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void changeMyInfoServer(){

    }
    private void myInfoServer(){
        //final String url="http://172.22.5.200:8080/CarpoolWeb_war_exploded/test4";
        mRequestQueue = Volley.newRequestQueue(getContext());
        Map<String,String> map=new HashMap<String,String>();
        //传一个参数,type=myInfo
        map.put("type", "myInfo");
        JSONObject params=new JSONObject(map);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,
                url, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                parseJsonObject(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Cache.Entry entry = mRequestQueue.getCache().get(url);
                if(entry!=null){
                    try {
                        String data = new String(entry.data, "UTF-8");
                        JSONObject jsonObject = new JSONObject(data);
                        parseJsonObject(jsonObject);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    Toast.makeText(getContext(),"Cache空的",Toast.LENGTH_SHORT).show();
                }
                Log.e("TAG", error.getMessage(), error);
            }
        });
        mRequestQueue.add(jsonObjectRequest);
/*
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                String str = "";
                for(int i=0;i<response.length();i++){
                    JSONObject jsonObject = null;
                    try {
                        jsonObject= response.getJSONObject(i);
                        str += jsonObject.getString("a");
                        str += jsonObject.getString("b");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                my_info_name.setText(str);
                Toast.makeText(getContext(),str,Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Cache.Entry entry = mRequestQueue.getCache().get(url);
                if(entry!=null){
                    try {
                        String data = new String(entry.data, "UTF-8");
                        my_info_name.setText(data);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    //login_num_input.setText(new String(mRequestQueue.getCache().get(url).data).toString());
                }
                else {
                    my_info_name.setText("空的");
                }
                Log.e("TAG", error.getMessage(), error);
            }
        });
        mRequestQueue.add(jsonArrayRequest);
*/

    }

    class buttonListener implements View.OnClickListener {
        public void onClick(View v){
            switch (v.getId()){
                case R.id.exit:
                    Intent intent = new Intent();
                    intent.setClass(getContext(),Login.class);
                    getContext().startActivity(intent);
                   // getActivity().finish();
                    break;
                case R.id.my_info_change_ok:
                    changeMyInfoServer();
                    break;
                default:
                    break;
            }
        }
    }
}
