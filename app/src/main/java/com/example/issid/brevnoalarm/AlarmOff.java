package com.example.issid.brevnoalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class AlarmOff extends AppCompatActivity {



    Button off_button, delay_button;
    MediaPlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_off);

        off_button = (Button) findViewById(R.id.off_button) ;
        delay_button = (Button) findViewById(R.id.delay_button) ;
        mPlayer = MediaPlayer.create(this, R.raw.aaa);

        mPlayer.start();


        View.OnClickListener off = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlayer.stop();
                finish();
            }
        };

        off_button.setOnClickListener(off);

        View.OnClickListener delay = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mPlayer.stop();

                final Intent delay_intent = new Intent(getApplicationContext(), AlarmReceiver.class);
                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                final Calendar calendar = Calendar.getInstance();

                PendingIntent pendingIntent = PendingIntent.getBroadcast(AlarmOff.this,0,delay_intent,PendingIntent.FLAG_UPDATE_CURRENT);
                alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis()+60000, pendingIntent );
                finish();
            }
        };

        delay_button.setOnClickListener(delay);
    }

    @Override
    protected void onDestroy() {
       mPlayer.stop();
        super.onDestroy();
    }
}
