package com.example.sheng.carpool.activities;

import android.app.TimePickerDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
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
import com.example.sheng.carpool.helpers.TextDatePickerDialog;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;


public class MainFragment extends Fragment {

    private View view;
    private EditText main_start_input;
    private EditText main_end_input;
    private EditText main_day_input;
    private Button main_sure;
    private String str_main_start_input, str_main_end_input, str_main_day_input;
    private RequestQueue mRequestQueue;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main, container, false);
        componentInit();
        return view;
    }
    private void componentInit(){
        main_start_input = (EditText)view.findViewById(R.id.main_start_input);
        main_end_input = (EditText)view.findViewById(R.id.main_end_input);
        main_day_input = (EditText)view.findViewById(R.id.main_day_input);
        main_sure = (Button)view.findViewById(R.id.main_sure);
    }
    private void getValue(){
        str_main_start_input =  main_start_input.getText().toString();
        str_main_end_input = main_end_input.getText().toString();
        str_main_day_input = main_day_input.getText().toString();
    }
    private void searchServer(){
        getValue();
        final String url= PublicData.loginServer;
        mRequestQueue = Volley.newRequestQueue(getContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(!response.equals(PublicData.FALSE_RETURN)){
                    /**
                     *将response传递到“我发布的信息”
                     */

                }
                else {
                    Toast.makeText(getContext(),"查找不到数据，请重新输入有效地点和时间",Toast.LENGTH_SHORT).show();
                }
                Log.d("TAG", response);
            }
        },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(),"请连接网络使用",Toast.LENGTH_SHORT).show();
                Log.e("TAG", error.getMessage(), error);
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                //用HashMap来存储请求参数
                Map<String,String> map = new HashMap<String,String>();
                map.put("type","search");
                map.put("main_start_input",str_main_start_input);
                map.put("main_end_input",str_main_end_input);
                map.put("main_day_input",str_main_day_input);
                return map;
            }
        };
        mRequestQueue.add(stringRequest);
    }

    class buttonListener implements View.OnClickListener {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.main_sure:
                    searchServer();
            }
        }
    }
}
