package com.example.sheng.carpool.ListViewHelp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.sheng.carpool.Dao.CarpoolInfo;

import java.util.List;

/**
 * Created by sheng on 16-11-29.
 */
public class CarpoolInfoListAdapter extends ArrayAdapter<CarpoolInfo> {
    private int resourceId;
    private Context context;
    public CarpoolInfoListAdapter(Context context, int textViewRescourceId,
                                  List<CarpoolInfo> objects){
        super(context,textViewRescourceId,objects);
        resourceId = textViewRescourceId;
        this.context=context;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        CarpoolInfo carpoolInfo = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,null);
        /*
        TextView accountName = (TextView) view.findViewById(R.id.item_account_name);
        TextView shareDetail = (TextView) view.findViewById(R.id.item_share_detail);
        commentImage = (ImageButton) view.findViewById(R.id.comment_image);
        accountName.setText(shareInfo.getAccount());
        String strShareDetail="在"+shareInfo.getDate()+
                "\n从"+shareInfo.getDeparture()+"===>"+shareInfo.getDestination()+
                "\n出发时间："+shareInfo.getDepartureTime()+
                "\n到达时间："+shareInfo.getArriveTime()+
                "\n还缺人数："+shareInfo.getLackNum()+
                "\n"+shareInfo.getDetail()+
                "\n"+
                "\n";
        shareDetail.setText(strShareDetail);
        */
        return view;
    }
    class buttonListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
            }
        }
    }
}
