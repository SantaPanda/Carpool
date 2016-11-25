package com.example.sheng.carpool;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    private EditText login_num_input;
    private EditText login_pass_input;
    private Button login_sure;
    private Button login_forget;
    private Button login_register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        componentInit();
    }
    //组件初始化，为组件监听
    private void componentInit(){
        login_num_input = (EditText) findViewById(R.id.login_num_input);
        login_pass_input = (EditText) findViewById(R.id.login_pass_input);
        login_sure = (Button) findViewById(R.id.login_sure);
        login_sure.setOnClickListener(new buttonListener());
        login_forget = (Button) findViewById(R.id.login_forget);
        login_register = (Button) findViewById(R.id.login_register);
    }


    class buttonListener implements View.OnClickListener {
        public void onClick(View v){
            switch (v.getId()){
                case R.id.login_sure:

                    Intent intent = new Intent();
                    intent.setClass(Login.this,MainActivity.class);
                    Login.this.startActivity(intent);
                    finish();
                    break;
                default:
                    break;
            }
        }
    }
}
