package com.example.sheng.carpool.activities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sheng.carpool.R;


public class PublishFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_publish, container, false);
    }



    class buttonListener implements View.OnClickListener {
        public void onClick(View v){
            switch (v.getId()){

            }
        }
    }
}
