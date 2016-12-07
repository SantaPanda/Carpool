package com.example.sheng.carpool.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Cache;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.sheng.carpool.Dao.CarpoolInfo;
import com.example.sheng.carpool.Data.PublicData;
import com.example.sheng.carpool.ListViewHelp.CarpoolInfoListAdapter;
import com.example.sheng.carpool.R;
import com.example.sheng.carpool.helpers.JsonOperation;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyHaveFragment extends Fragment {

    private RequestQueue mRequestQueue;
    private View view;
    private Button my_have_publish;
    private Button my_have_join;
    private Button my_have_done;
    private TextView my_have_name;

    //ListView用的
    private CarpoolInfoListAdapter carpoolInfoListAdapter1,carpoolInfoListAdapter2,carpoolInfoListAdapter3;
    private List<CarpoolInfo> carpoolInfoArrayList1 = new ArrayList<>();
    private List<CarpoolInfo> carpoolInfoArrayList2 = new ArrayList<>();
    private List<CarpoolInfo> carpoolInfoArrayList3 = new ArrayList<>();
    private CarpoolInfo [] carpoolInfos;

    //SharedPreferences存储
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    //获取账号
    private void getAccount(){
        //之前有登陆，直接填写数据
        pref = getActivity().getSharedPreferences("data",getActivity().MODE_PRIVATE);
        String a = pref.getString("account","");
        String b = pref.getString("password","");
        if(!a.equals("")){
            my_have_name.setText(a);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_my_have, container, false);
        componentInit();
        getAccount();
        carpoolInfoListAdapter1 = new CarpoolInfoListAdapter(getContext(),
                R.layout.search_result,carpoolInfoArrayList1);
        ListView listView1 = (ListView)view.findViewById(R.id.my_have_publish_listView);
        listView1.setAdapter(carpoolInfoListAdapter1);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                CarpoolInfo carpoolInfo = carpoolInfoArrayList1.get(i);
                Toast.makeText(getContext(),""+carpoolInfo.getAccountID(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                String carpool = JsonOperation.jsonObjectStructure(carpoolInfo);
                intent.putExtra("carpool",carpool);
                intent.setClass(getContext(),Search_case.class);
                getContext().startActivity(intent);
                // finish();
            }
        });


        carpoolInfoListAdapter2 = new CarpoolInfoListAdapter(getContext(),
                R.layout.search_result,carpoolInfoArrayList2);
        ListView listView2 = (ListView)view.findViewById(R.id.my_have_join_listView);
        listView2.setAdapter(carpoolInfoListAdapter2);
        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                CarpoolInfo carpoolInfo = carpoolInfoArrayList2.get(i);
                Toast.makeText(getContext(),""+carpoolInfo.getAccountID(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                String carpool = JsonOperation.jsonObjectStructure(carpoolInfo);
                intent.putExtra("carpool",carpool);
                intent.setClass(getContext(),Search_case.class);
                getContext().startActivity(intent);
                // finish();
            }
        });

        carpoolInfoListAdapter3 = new CarpoolInfoListAdapter(getContext(),
                R.layout.search_result,carpoolInfoArrayList3);
        ListView listView3 = (ListView)view.findViewById(R.id.my_have_done_listView);
        listView3.setAdapter(carpoolInfoListAdapter3);
        listView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                CarpoolInfo carpoolInfo = carpoolInfoArrayList3.get(i);
                Toast.makeText(getContext(),""+carpoolInfo.getAccountID(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                String carpool = JsonOperation.jsonObjectStructure(carpoolInfo);
                intent.putExtra("carpool",carpool);
                intent.setClass(getContext(),Search_case.class);
                getContext().startActivity(intent);
                // finish();
            }
        });
        return view;
    }

    private void componentInit(){
        my_have_name = (TextView)view.findViewById(R.id.my_have_name);
        my_have_publish = (Button)view.findViewById(R.id.my_have_publish);
        my_have_publish.setOnClickListener(new buttonListener());
        my_have_join = (Button)view.findViewById(R.id.my_have_join);
        my_have_join.setOnClickListener(new buttonListener());
        my_have_done = (Button)view.findViewById(R.id.my_have_done);
        my_have_done.setOnClickListener(new buttonListener());
    }

    private void login(){
        final String url= PublicData.loginServer;
        mRequestQueue = Volley.newRequestQueue(getContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.equals(PublicData.TRUE_RETURN)){

                }
                Log.d("TAG", response);
            }
        },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(),"没网络",Toast.LENGTH_LONG).show();
                Cache.Entry entry = mRequestQueue.getCache().get(url);
                if(entry!=null){
                    try {
                        String data = new String(entry.data, "UTF-8");
                        if(data.equals(PublicData.TRUE_RETURN)){

                        }
                        else {
                            Toast.makeText(getContext(),"请连接网络使用！",Toast.LENGTH_SHORT).show();
                        }
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
                else {
                }
                Log.e("TAG", error.getMessage(), error);
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                //用HashMap来存储请求参数
                Map<String,String> map = new HashMap<String,String>();
                map.put("type","myHave");
                return map;
            }
        };
        mRequestQueue.add(stringRequest);
    }

    //ListView用的
    private void initCarpoolInfoList1(){
        CarpoolInfo carpoolInfo1 = new CarpoolInfo("accountID1.1","name1.1","date1.1","departure1.1",
                "destination1.1", "Time1.1", 111,114,1,"phoneNum1.1","detail1.1","addID1.1",
                "commentID");
        carpoolInfoArrayList1.add(carpoolInfo1);
        CarpoolInfo carpoolInfo2 = new CarpoolInfo("accountID1.2","name1.2","date1.2","departure1.2",
                "destination1.2", "Time1.2", 112,224,2,"phoneNum1.2","detail1.2","addID1.2",
                "commentID");
        carpoolInfoArrayList1.add(carpoolInfo2);
    }
    private void initCarpoolInfoList2(){
        CarpoolInfo carpoolInfo1 = new CarpoolInfo("accountID2.1","name2.1","date2.1","departure2.1",
                "destination2.1", "Time2.1",221,214,1,"phoneNum2.1","detail2.1","addID2.1",
                "commentID");
        carpoolInfoArrayList2.add(carpoolInfo1);
        CarpoolInfo carpoolInfo2 = new CarpoolInfo("accountID2.2","name","date","departure",
                "destination", "departureTime", 100,4,1,"phoneNum","detail","addID",
                "commentID");
        carpoolInfoArrayList2.add(carpoolInfo2);
    }
    private void initCarpoolInfoList3(){
        CarpoolInfo carpoolInfo1 = new CarpoolInfo("accountID3.1","name","date","departure",
                "destination", "departureTime", 100,4,1,"phoneNum","detail","addID",
                "commentID");
        carpoolInfoArrayList3.add(carpoolInfo1);
        CarpoolInfo carpoolInfo2 = new CarpoolInfo("accountID3.2","name","date","departure",
                "destination", "departureTime", 100,4,1,"phoneNum","detail","addID",
                "commentID");
        carpoolInfoArrayList3.add(carpoolInfo2);
    }

    class buttonListener implements View.OnClickListener {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.my_have_publish:
                    //
                    if(carpoolInfoListAdapter1.getCount()!=0){
                        carpoolInfoArrayList1.clear();
                        carpoolInfoListAdapter1.notifyDataSetChanged();
                    }
                    else{
                        initCarpoolInfoList1();
                        carpoolInfoListAdapter1.notifyDataSetChanged();
                    }
                    break;
                case R.id.my_have_join:
                    if(carpoolInfoListAdapter2.getCount()!=0){
                        carpoolInfoArrayList2.clear();
                        carpoolInfoListAdapter2.notifyDataSetChanged();
                    }
                    else{
                        initCarpoolInfoList2();
                        carpoolInfoListAdapter2.notifyDataSetChanged();
                    }
                    break;
                case R.id.my_have_done:
                    if(carpoolInfoListAdapter3.getCount()!=0){
                        carpoolInfoArrayList3.clear();
                        carpoolInfoListAdapter3.notifyDataSetChanged();
                    }
                    else{
                        initCarpoolInfoList3();
                        carpoolInfoListAdapter3.notifyDataSetChanged();
                    }
                    break;
            }
        }
    }
}
