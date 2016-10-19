package com.bamusasoft.mycontactlist;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.text.format.Time;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ContactActivity extends FragmentActivity implements DatePickerDialog.SaveDateListner {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        initChangeDateButton();
    }

    private void initChangeDateButton(){
        Button changeDate = (Button) findViewById(R.id.btnBirthday);
        changeDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager();
                DatePickerDialog datePickerDialog = new DatePickerDialog();
                datePickerDialog.show(fm, "DatePick");
            }
        });
    }

    @Override
    public void didFinishDatePickerDialog(Time selecteTime) {
        TextView birthDay = (TextView)findViewById(R.id.textBirthday);
        birthDay.setText(DateFormat.format("dd/MM/yyyy", selecteTime.toMillis(false))
        .toString());

    }
}
