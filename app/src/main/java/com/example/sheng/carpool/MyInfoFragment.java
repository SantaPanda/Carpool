package com.example.sheng.carpool;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class MyInfoFragment extends Fragment {

    private Button btnexit;
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_my_info, container, false);
        componentInit();
        return view;
    }

    //组件初始化，为组件监听
    private void componentInit(){
        btnexit = (Button)view.findViewById(R.id.btn_exit);
        btnexit.setOnClickListener(new buttonListener());
    }

    class buttonListener implements View.OnClickListener {
        public void onClick(View v){
            switch (v.getId()){
                case R.id.btn_exit:
                    Intent intent = new Intent();
                    intent.setClass(getContext(),Login.class);
                    getContext().startActivity(intent);
                    getActivity().finish();
                    break;
            }
        }
    }
}
