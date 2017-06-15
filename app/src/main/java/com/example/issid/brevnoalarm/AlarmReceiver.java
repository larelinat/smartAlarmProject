package com.example.issid.brevnoalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.util.Log;
import android.widget.Toast;

import java.text.SimpleDateFormat;

/**
 * Created by issid on 04.06.2017.
 */


public class AlarmReceiver extends BroadcastReceiver {



    @Override
    public void onReceive(Context context, Intent intent) {


        Intent intent1 = new Intent(context, AlarmOff.class);
        intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent1);



    }
}
