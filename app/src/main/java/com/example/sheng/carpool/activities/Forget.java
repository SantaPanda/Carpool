package com.example.sheng.carpool.activities;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.example.sheng.carpool.R;

public class Forget extends Activity {

    private RequestQueue mRequestQueue;
    private EditText forget_num_input;
    private EditText forget_new_password_input;
    private EditText forget_password_again_input;
    private Button forget_sure;
    private String str_forget_num_input,str_forget_new_password_input,str_forget_password_again_input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);
        componentInit();
    }
    private void componentInit(){
        forget_num_input = (EditText)findViewById(R.id.forget_num_input);
        forget_new_password_input = (EditText)findViewById(R.id.forget_new_password_input);
        forget_password_again_input = (EditText)findViewById(R.id.forget_password_again_input);
        forget_sure = (Button) findViewById(R.id.forget_sure);
        forget_sure.setOnClickListener(new buttonListener());
    }
    private void getValue(){
        str_forget_num_input = forget_num_input.getText().toString();
        str_forget_new_password_input = forget_new_password_input.getText().toString();
        str_forget_password_again_input = forget_password_again_input.getText().toString();

    }
    class buttonListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.forget_sure:
                    break;
                default:
                    break;
            }
        }
    }
}
