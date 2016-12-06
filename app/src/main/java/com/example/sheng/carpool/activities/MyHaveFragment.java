package com.example.sheng.carpool.activities;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.example.sheng.carpool.Dao.CarpoolInfo;
import com.example.sheng.carpool.ListViewHelp.CarpoolInfoListAdapter;
import com.example.sheng.carpool.R;

import java.util.ArrayList;
import java.util.List;

public class MyHaveFragment extends Fragment {

    private RequestQueue mRequestQueue;
    private View view;
    private Button my_have_publish;
    private Button my_have_join;
    private Button my_have_done;

    //ListView用的
    private CarpoolInfoListAdapter carpoolInfoListAdapter1,carpoolInfoListAdapter2,carpoolInfoListAdapter3;
    private List<CarpoolInfo> carpoolInfoArrayList1 = new ArrayList<>();
    private List<CarpoolInfo> carpoolInfoArrayList2 = new ArrayList<>();
    private List<CarpoolInfo> carpoolInfoArrayList3 = new ArrayList<>();
    private CarpoolInfo [] carpoolInfos;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_my_have, container, false);
        componentInit();

        carpoolInfoListAdapter1 = new CarpoolInfoListAdapter(getContext(),
                R.layout.search_result,carpoolInfoArrayList1);
        ListView listView1 = (ListView)view.findViewById(R.id.my_have_publish_listView);
        listView1.setAdapter(carpoolInfoListAdapter1);

        carpoolInfoListAdapter2 = new CarpoolInfoListAdapter(getContext(),
                R.layout.search_result,carpoolInfoArrayList2);
        ListView listView2 = (ListView)view.findViewById(R.id.my_have_join_listView);
        listView2.setAdapter(carpoolInfoListAdapter2);

        carpoolInfoListAdapter3 = new CarpoolInfoListAdapter(getContext(),
                R.layout.search_result,carpoolInfoArrayList3);
        ListView listView3 = (ListView)view.findViewById(R.id.my_have_done_listView);
        listView3.setAdapter(carpoolInfoListAdapter3);

        return view;
    }

    private void componentInit(){
        my_have_publish = (Button)view.findViewById(R.id.my_have_publish);
        my_have_publish.setOnClickListener(new buttonListener());
        my_have_join = (Button)view.findViewById(R.id.my_have_join);
        my_have_join.setOnClickListener(new buttonListener());
        my_have_done = (Button)view.findViewById(R.id.my_have_done);
        my_have_done.setOnClickListener(new buttonListener());
    }
    //ListView用的
    private void initCarpoolInfoList1(){
        CarpoolInfo carpoolInfo1 = new CarpoolInfo("accountID1.1","name","date","departure",
                "destination", "departureTime", 100,4,1,"phoneNum","detail","addID",
                "commentID");
        carpoolInfoArrayList1.add(carpoolInfo1);
        CarpoolInfo carpoolInfo2 = new CarpoolInfo("accountID1.2","name","date","departure",
                "destination", "departureTime", 100,4,1,"phoneNum","detail","addID",
                "commentID");
        carpoolInfoArrayList1.add(carpoolInfo2);
    }
    private void initCarpoolInfoList2(){
        CarpoolInfo carpoolInfo1 = new CarpoolInfo("accountID2.1","name","date","departure",
                "destination", "departureTime", 100,4,1,"phoneNum","detail","addID",
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
