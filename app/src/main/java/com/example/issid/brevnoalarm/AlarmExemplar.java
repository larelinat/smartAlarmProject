package com.example.issid.brevnoalarm;

/**
 * Created by issid on 16.06.2017.
 */

public class AlarmExemplar {
    String time;
    int alarmID;
    boolean check;
    int checkID;

    AlarmExemplar (){
        time = "00:00";
        alarmID = 0;
        check = false;
        checkID = 0;
    }

    public void setAlarmID(int alarmID){
        this.alarmID = alarmID;
    }

    public int getAlarmID(){
        return this.alarmID;
    }

    public void setCheck(boolean check){
        this.check = check;
    }

    public boolean getCheck(){
        return this.check;
    }
    public void setCheckID(int checkID){
        this.checkID = checkID;
    }

    public int getCheckID(){
        return this.checkID;
    }
    public void setTime(String time){
        this.time = time;
    }

    public String getTime(){
        return this.time;
    }
}
