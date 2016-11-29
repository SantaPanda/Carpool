package com.example.sheng.carpool.activities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Cache;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.sheng.carpool.Data.PublicData;
import com.example.sheng.carpool.R;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;


public class PublishFragment extends Fragment {

    private View view;
    private EditText publish_day;
    private EditText publish_start;
    private EditText publish_end;
    private EditText publish_time;
    private EditText publish_pay;
    private EditText publish_people;
    private EditText publish_have_people;
    private EditText publish_phone;
    private EditText publish_info;
    private Button publish_sure;
    private String str_publish_day, str_publish_start, str_publish_end, str_publish_time;
    private String str_publish_pay, str_publish_people ,str_publish_have_people;
    private String str_publish_phone, str_publish_info;
    private RequestQueue mRequestQueue;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_publish, container, false);
        componentInit();
        return view;
    }

    private void componentInit(){
        publish_day = (EditText)view.findViewById(R.id.publish_day);
        publish_start = (EditText)view.findViewById(R.id.publish_start);
        publish_end = (EditText)view.findViewById(R.id.publish_end);
        publish_time = (EditText)view.findViewById(R.id.publish_time);
        publish_pay = (EditText)view.findViewById(R.id.publish_pay);
        publish_people = (EditText)view.findViewById(R.id.publish_people);
        publish_have_people = (EditText)view.findViewById(R.id.publish_have_people);
        publish_phone = (EditText)view.findViewById(R.id.publish_phone);
        publish_info = (EditText)view.findViewById(R.id.publish_info);
        publish_sure = (Button)view.findViewById(R.id.publish_sure);
        publish_sure.setOnClickListener(new buttonListener());
    }

    private void getValue(){
        str_publish_day = publish_day.getText().toString();
        str_publish_start = publish_start.getText().toString();
        str_publish_end = publish_end.getText().toString();
        str_publish_time = publish_time.getText().toString();
        str_publish_pay = publish_pay.getText().toString();
        str_publish_people = publish_people.getText().toString();
        str_publish_have_people = publish_have_people.getText().toString();
        str_publish_phone = publish_phone.getText().toString();
        str_publish_info = publish_info.getText().toString();
    }

    private void publishServer(){
        final String account = "";       //还需要获取账号。。。。。。。。。。。。。。。。。。。。。
        getValue();
        final String url = PublicData.publishServer;
        mRequestQueue = Volley.newRequestQueue(getContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.equals(PublicData.TRUE_RETURN)){
                    Toast.makeText(getContext(),"发布成功!",Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(getContext(),response,Toast.LENGTH_SHORT).show();
                Log.d("TAG", response);
            }
        },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(),"请连接网络使用！",Toast.LENGTH_SHORT).show();
                Log.e("TAG", error.getMessage(), error);
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<String,String>();
                map.put("type","publish");
                map.put("account",account);
                map.put("data",str_publish_day);
                map.put("publish_start",str_publish_start);
                map.put("publish_end",str_publish_end);
                map.put("publish_time",str_publish_time);
                map.put("publish_pay",str_publish_pay);
                map.put("publish_people",str_publish_people);
                map.put("publish_have_people",str_publish_have_people);
                map.put("publish_phone",str_publish_phone);
                map.put("publish_info",str_publish_info);
                return map;
            }
        };
        mRequestQueue.add(stringRequest);
    }
    class buttonListener implements View.OnClickListener {
        public void onClick(View v){
            switch (v.getId()){
                case R.id.publish_sure:
                    publishServer();
                    break;
                default:
                    break;
            }
        }
    }
}
