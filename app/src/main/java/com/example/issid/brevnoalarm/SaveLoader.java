package com.example.issid.brevnoalarm;

import java.util.ArrayList;

/**
 * Created by issid on 16.06.2017.
 */

public class SaveLoader {

    AlarmExemplar alarmExemplar;
    ArrayList<AlarmExemplar> alarmExemplars;
    int count = 5;


    public void Saver(){



    }


    public void Loader() {

        if (count != 0) {
            for (int i = 0; i < count; i++) {
                alarmExemplars.add(i, alarmExemplar);
            }
        }
    }
}