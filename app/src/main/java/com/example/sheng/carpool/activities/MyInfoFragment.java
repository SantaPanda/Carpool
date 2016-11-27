package com.example.sheng.carpool.activities;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.sheng.carpool.R;


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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_my_info, container, false);
        componentInit();
        return view;
    }

    //组件初始化，为组件监听
    private void componentInit(){
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
                    break;
                default:
                    break;
            }
        }
    }
}
