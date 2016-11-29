package com.example.sheng.carpool.helpers;

import android.app.DatePickerDialog;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.sheng.carpool.R;

import java.util.Calendar;

public class TextListener implements  View.OnFocusChangeListener {
    EditText editTextData, editTextTime;
    public TextListener(EditText editTextData){
        this.editTextData = editTextData;
    }
    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        /*
        if (hasFocus) {
            switch (v.getId()) {
                case R.id.editDate:
                    Calendar c = Calendar.getInstance();
                    new DatePickerDialog(WriteShareInfo.this, new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                            // TODO Auto-generated method stub
                            editDate.setText(year + "/" + (monthOfYear + 1) + "/" + dayOfMonth);
                        }
                    }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show();
                    editDeparture.requestFocus();
                    break;

                    case R.id.editArriveTime:
                        Calendar c2 = Calendar.getInstance();
                        new TimePickerDialog(WriteShareInfo.this, new TimePickerDialog.OnTimeSetListener(){
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                editArriveTime.setText(hourOfDay+":"+minute);
                            }
                        },c2.get(Calendar.HOUR_OF_DAY),c2.get(Calendar.MINUTE),DateFormat.is24HourFormat(WriteShareInfo.this)).show();
                        editDestination.requestFocus();
                        break;

                default:
                    break;
            }//switch
        }//if
*/
    }
}