package com.example.sheng.carpool.activities;

import android.app.Activity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sheng.carpool.R;

public class Message extends Activity {

    private EditText message_input;
    private Button message_send;
    private String str_message_input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        componentInit();
    }
    private void componentInit(){
        message_input = (EditText)findViewById(R.id.message_input);
        message_send = (Button)findViewById(R.id.message_send);
        message_send.setOnClickListener(new buttonListener());
    }
    class buttonListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            str_message_input = message_input.getText().toString();
        }
    }
}
