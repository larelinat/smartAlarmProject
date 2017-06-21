package com.example.issid.brevnoalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity  {

    LinearLayout llMain;
    Button b1;
    CheckBox c1;
    PendingIntent pendingIntent;
    AlarmManager alarmManager;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        llMain = (LinearLayout) findViewById(R.id.llMain);
        b1 = (Button) findViewById(R.id.b1);
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        final Calendar calendar = Calendar.getInstance();
        final Intent alarm_intent = new Intent(getApplicationContext(), AlarmReceiver.class);


        c1 = (CheckBox) findViewById(R.id.c1);
        c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Log.d("LOG", "checked");

                    pendingIntent = PendingIntent.getBroadcast(MainActivity.this,0,alarm_intent,PendingIntent.FLAG_UPDATE_CURRENT);
                    alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent );
                    String date_str = new SimpleDateFormat("HH:mm:ss dd.MM.yyyy").format(calendar.getTimeInMillis());
                    Log.d("LOG", date_str);
                }else{
                    Log.d("LOG", "unchecked");
                    alarmManager.cancel(pendingIntent);
                }
            }
        });


        for (int btnloadcount = 0; btnloadcount < 5; btnloadcount++) {
            final int btnID = getIntent().getIntExtra("btnID", 0);
            final int hour ;
            final int minute ;

            if (btnID != 0) {
                String selectedTime;


                hour = getIntent().getIntExtra("hour", 0);
                minute = getIntent().getIntExtra("minute", 0);

                calendar.set(Calendar.HOUR_OF_DAY, hour);
                calendar.set(Calendar.MINUTE, minute);
                calendar.set(Calendar.SECOND, 0);

                if (minute< 10) {
                    selectedTime = "" + hour + ":0" + minute;
                } else{
                    selectedTime = "" + hour + ":" + minute;
                }


                ((Button) findViewById(btnID)).setText(selectedTime);

            }
        }

        View.OnClickListener oclBtn = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, Settings.class);
                        intent.putExtra("btnID", v.getId());
                        startActivity(intent);
            }
        };
        b1.setOnClickListener(oclBtn);




    }



    protected void onDestroy(){
        super.onDestroy();
    }
}


