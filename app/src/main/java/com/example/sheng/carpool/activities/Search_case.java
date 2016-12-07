package com.example.sheng.carpool.activities;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ExpandedMenuView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sheng.carpool.Dao.CarpoolInfo;
import com.example.sheng.carpool.R;
import com.example.sheng.carpool.helpers.JsonOperation;

import org.json.JSONException;
import org.json.JSONObject;

public class Search_case extends Activity {

    private TextView case_public_name;
    private TextView case_people;
    private TextView case_good_show;
    private TextView case_bad_show;
    private TextView case_credit_show;
    private TextView case_start;
    private TextView case_time;
    private TextView case_end;
    private TextView case_day;
    private TextView case_phone;
    private TextView case_pay;
    private TextView case_show;
    private Button case_send_massage;
    private Button case_join_in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_case);
        Intent intent = getIntent();
        String data = intent.getStringExtra("carpool");
        CarpoolInfo carpoolInfo = null;
        if(!data.equals("")){
            carpoolInfo = JsonOperation.jsonObjectAnalysis(data);
        }
        componentInit();
        if(!data.equals("")){
            Toast.makeText(getApplicationContext(),""+carpoolInfo.getName(),Toast.LENGTH_LONG).show();
            setValue(carpoolInfo);
        }
    }

    private void setValue(CarpoolInfo carpoolInfo){
        case_public_name.setText(carpoolInfo.getName());
        case_people.setText(carpoolInfo.getHaveNum()+"/"+carpoolInfo.getHaveNum());
        //case_good_show.setText(carpoolInfo.ge);
       // case_bad_show;
        //case_credit_show;
        case_start.setText(carpoolInfo.getDeparture());
        case_time.setText(carpoolInfo.getDepartureTime());
        case_end.setText(carpoolInfo.getDestination());
        case_day.setText(carpoolInfo.getDate());
        case_phone.setText(carpoolInfo.getPhoneNum());
        case_pay.setText(""+carpoolInfo.getPrice());
        case_show.setText(carpoolInfo.getDetail());
    }
    private void componentInit(){
        case_public_name = (TextView) findViewById(R.id.case_public_name);
        case_people = (TextView) findViewById(R.id.case_people);
        case_good_show = (TextView)findViewById(R.id.case_good_show);
        case_bad_show = (TextView)findViewById(R.id.case_bad_show);
        case_credit_show = (TextView)findViewById(R.id.case_credit_show);
        case_start = (TextView)findViewById(R.id.case_start);
        case_time = (TextView)findViewById(R.id.case_time);
        case_end = (TextView)findViewById(R.id.case_end);
        case_day = (TextView)findViewById(R.id.case_day);
        case_phone = (TextView)findViewById(R.id.case_phone);
        case_pay = (TextView)findViewById(R.id.case_pay);
        case_show = (TextView)findViewById(R.id.case_show);
        case_send_massage = (Button)findViewById(R.id.case_send_massage);
        case_send_massage.setOnClickListener(new buttonListener());
        case_join_in = (Button)findViewById(R.id.case_join_in);
        case_join_in.setOnClickListener(new buttonListener());
    }
    private void dialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(Search_case.this);
        builder.setMessage("请及时联系发布人,确认是否成功加入！");
        builder.setTitle("提示");
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                //加入处理。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }
    class buttonListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.case_send_massage:
                    Intent intent = new Intent();
                    intent.setClass(Search_case.this,Message.class);
                    Search_case.this.startActivity(intent);
                    //finish();
                    break;
                case R.id.case_join_in:
                    dialog();
                    break;
                default:
                    break;
            }
        }
    }

}
