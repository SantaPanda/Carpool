package com.example.sheng.carpool.activities;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
import java.util.HashMap;
import java.util.Map;

public class Login extends Activity {

    private EditText login_num_input;
    private EditText login_pass_input;
    private Button login_sure;
    private Button login_forget;
    private Button login_register;
    private String str_login_num_input,str_login_pass_input;
//volly网络请求处理
    public static final String TAG = Login.class
            .getSimpleName();
    private RequestQueue mRequestQueue;
    private static Login mInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        componentInit();
    }
    //组件初始化，为组件监听
    private void componentInit(){
        login_num_input = (EditText) findViewById(R.id.login_num_input);
        login_pass_input = (EditText) findViewById(R.id.login_pass_input);
        login_sure = (Button) findViewById(R.id.login_sure);
        login_sure.setOnClickListener(new buttonListener());
        login_forget = (Button) findViewById(R.id.login_forget);
        login_forget.setOnClickListener(new buttonListener());
        login_register = (Button) findViewById(R.id.login_register);
        login_register.setOnClickListener(new buttonListener());
    }

    private void login(){
        str_login_num_input = login_num_input.getText().toString();
        str_login_pass_input = login_pass_input.getText().toString();
        String url="http://172.22.5.200:8080/CarpoolWeb_war_exploded/net-work";
        String url2="http://172.22.5.200:8080/CarpoolWeb_war_exploded/test4";
        mRequestQueue = Volley.newRequestQueue(getApplicationContext());
/*get请求
        StringRequest stringRequest = new StringRequest(Request.Method.GET,"https://api.thinkpage.cn/v3/weather/now.json?key=rot2enzrehaztkdk&location=guangzhou&language=zh-Hans&unit=c",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        //String s即为服务器返回的数据
                        Log.d("cylog", s);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("cylog", error.getMessage(),error);
            }

        });
*/
/*
        Map<String,String> map=new HashMap<String,String>();
        //传一个参数，user=zhangqi
        map.put("user", "zhangqi");
        JSONObject params=new JSONObject(map);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,
                url, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
*/
/*
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                url2, new Response.Listener<JSONArray>() {
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
                login_num_input.setText(str);
                Toast.makeText(Login.this,str,Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
*/
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.equals(PublicData.TRUE_RETURN)){
                    finish();
                    /*
                    Intent intent1 = new Intent();
                    intent1.setClass(Login.this,MainActivity.class);
                    Login.this.startActivity(intent1);
                    finish();
                    */
                }
                Toast.makeText(Login.this,response,Toast.LENGTH_SHORT).show();
                Log.d("TAG", response);
            }
            },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG", error.getMessage(), error);
            }
            }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                //用HashMap来存储请求参数
                Map<String,String> map = new HashMap<String,String>();
                map.put("type","register");
                map.put("account",str_login_num_input);
                map.put("password",str_login_pass_input);
                return map;
            }
            };
        //3、将请求添加进请求队列
        mRequestQueue.add(stringRequest);
        //mRequestQueue.add(jsonArrayRequest);
    }
/*
    public String parseJSON(String jsonStream){
        String str="";
        try {
            JSONArray jsonArray = new JSONArray(jsonStream);
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                str += jsonObject.getString("a");
                str += jsonObject.getString("b");
                str += "\n";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  str;
    }
*/
    class buttonListener implements View.OnClickListener {
        public void onClick(View v){
            switch (v.getId()){
                case R.id.login_sure:
                    login();
                    break;
                case R.id.login_forget:
                    Intent intent2 = new Intent();
                    intent2.setClass(Login.this,Forget.class);
                    Login.this.startActivity(intent2);
                    break;
                case R.id.login_register:
                    Intent intent3 = new Intent();
                    intent3.setClass(Login.this,Register.class);
                    Login.this.startActivity(intent3);
                    finish();
                    break;
                default:
                    break;
            }
        }
    }
}
