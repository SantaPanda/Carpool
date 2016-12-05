package com.example.sheng.carpool.activities;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.android.volley.RequestQueue;
import com.example.sheng.carpool.R;

public class MyHaveFragment extends Fragment {

    private RequestQueue mRequestQueue;
    private View view;
    private Button my_have_publish;
    private Button my_have_join;
    private Button my_have_done;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_my_have, container, false);
        componentInit();
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
    class buttonListener implements View.OnClickListener {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.my_have_publish:

                    break;
                case R.id.my_have_join:
                    break;
                case R.id.my_have_done:
                    break;
            }
        }
    }
}
