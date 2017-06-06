package com.example.issid.brevnoalarm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

public class Settings extends AppCompatActivity {

    TimePicker timePicker;
    Button savebutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        final int btnID = getIntent().getIntExtra("btnID", 0);

        timePicker = (TimePicker) findViewById(R.id.timePicker);
        timePicker.setIs24HourView(true);
        savebutton = (Button) findViewById(R.id.savebutton);



        View.OnClickListener ocl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int hour = timePicker.getCurrentHour();
                int minute = timePicker.getCurrentMinute();


                Intent intent = new Intent(Settings.this, MainActivity.class);
                intent.putExtra("btnID", btnID);
                intent.putExtra("hour", hour);
                intent.putExtra("minute", minute);
                startActivity(intent);


            }
        };
        savebutton.setOnClickListener(ocl);

    }
}
