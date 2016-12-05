package com.example.sheng.carpool.activities;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.sheng.carpool.Dao.CarpoolInfo;
import com.example.sheng.carpool.ListViewHelp.CarpoolInfoListAdapter;
import com.example.sheng.carpool.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Search extends Activity {

    //ListView用的
    private CarpoolInfoListAdapter carpoolInfoListAdapter;
    private List<CarpoolInfo> carpoolInfoArrayList = new ArrayList<>();
    private CarpoolInfo [] carpoolInfos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        //ListView中的内容

        initCarpoolInfoList();
        carpoolInfoListAdapter = new CarpoolInfoListAdapter(getApplicationContext(),
                R.layout.search_result,carpoolInfoArrayList);
        ListView listView = (ListView)findViewById(R.id.search_listView);
        listView.setAdapter(carpoolInfoListAdapter);
    }
    private void initCarpoolInfoList(){
        CarpoolInfo carpoolInfo1 = new CarpoolInfo("accountID","date","departure",
                "destination", "departureTime", 100,4,1,"phoneNum","detail","addID",
                "commentID");
        carpoolInfoArrayList.add(carpoolInfo1);
        CarpoolInfo carpoolInfo2 = new CarpoolInfo("accountID","date","departure",
                "destination", "departureTime", 100,4,1,"phoneNum","detail","addID",
                "commentID");
        carpoolInfoArrayList.add(carpoolInfo1);
    }
}