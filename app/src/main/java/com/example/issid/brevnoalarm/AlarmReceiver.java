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
        String date_str = new SimpleDateFormat("HH:mm:ss dd.MM.yyyy").format(System.currentTimeMillis());
        Log.d("LOG",date_str);

    }
}
