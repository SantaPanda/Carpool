package com.example.sheng.carpool.activities;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.example.sheng.carpool.R;

public class MyHaveFragment extends Fragment {

    private RequestQueue mRequestQueue;
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_my_have, container, false);
        return view;
    }
    class buttonListener implements View.OnClickListener {
        public void onClick(View v) {
            switch (v.getId()) {

            }
        }
    }
}
