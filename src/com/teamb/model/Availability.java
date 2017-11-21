package com.teamb.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

import java.util.ArrayList;

/**
 * Created by Sarah on 2017-10-10.
 */
public class Availability {
    public String shift;
    //public int shift; //1-morning 2-afternoon 3-evening
   public boolean mon,tue,wed,thur,fri,sat,sun;

    public Availability(String  s, boolean m,boolean tu,boolean w, boolean th, boolean f, boolean sa, boolean su ){
        shift = s;
        mon = m;
        tue = tu;
        wed = w;
        thur = th;
        fri = f;
        sat = sa;
        sun = su;
    }

    public String PrintAvailability (int shift, int day ){
        String temp;
        if(shift == 1){
            temp = "morning";
        }else if(shift == 2){
            temp = "afternoon";
        }else if(shift == 3){
            temp = "night";
        }else{
            return "shift not exist";
        }
        if(day == 1){
            if(mon){
                temp = "Monday " + temp + " is available";
            }else{
                temp = "Monday " + temp + " isn't available";
            }
        }else if(day == 2){
            if(tue){
                temp = "Tuesday " + temp + " is available";
            }else{
                temp = "Tuesday " + temp + " isn't available";
            }
        }else if(day == 3){
            if(wed){
                temp = "Wednesday " + temp + " is available";
            }else{
                temp = "Wednesday " + temp + " isn't available";
            }
        }else if(day == 4){
            if(thur){
                temp = "Thursday " + temp + " is available";
            }else{
                temp = "Thursday " + temp + " isn't available";
            }
        }else if(day == 5){
            if(fri){
                temp = "Friday " + temp + " is available";
            }else{
                temp = "Friday " + temp + " isn't available";
            }
        }else if(day == 6){
            if(sat){
                temp = "Saturday " + temp + " is available";
            }else{
                temp = "Saturday " + temp + " isn't available";
            }
        }else if(day == 7){
            if(sun){
                temp = "Sunday " + temp + " is available";
            }else{
                temp = "Sunday " + temp + " isn't available";
            }
        }else{
            return "Day entered is not exist.";
        }
        return temp;
    }

    public boolean isMonAvailable() {
        return mon;
    }

    public boolean isTueAvailable() {
        return tue;
    }

    public boolean isWedAvailable() {
        return wed;
    }

    public boolean isThurAvailable() {
        return thur;
    }

    public boolean isFriAvailable() {
        return fri;
    }

    public boolean isSatAvailable() {
        return sat;
    }

    public boolean isSunAvailable() {
        return sun;
    }

    public String getShift() {
        return shift;
    }
    public String getShiftLable(int s){
        if(s == 1){
            return "morning";
        }else if (s == 2) {
            return "afternoon";
        }else {
            return "evening";
        }
    }

    //    final BooleanProperty Mon,Tue,Wed,Thur,Fri,Sat,Sun;
//    public Availability(){
//        Mon = new SimpleBooleanProperty(false);
//        Tue = new SimpleBooleanProperty(false);
//        Wed = new SimpleBooleanProperty(false);
//        Thur = new SimpleBooleanProperty(false);
//        Fri = new SimpleBooleanProperty(false);
//        Sat = new SimpleBooleanProperty(false);
//        Sun = new SimpleBooleanProperty(false);
//    }
//
//    public BooleanProperty monProperty() {
//        return Mon;
//    }
//
//        private boolean[][] availablility;
//
//
//    public Availability()
//    {
//        availablility = new boolean[7][3];
//        for(int i=0;i<7;i++){
//            for(int j=0;j<3;j++){
//                availablility[i][j] = false;
//            }
//        }
//    }
//
//    //0 = sunday, 1 = monday etc
//    //0 = morning, 1 = afternoon
//    void ChangeAvailability(int day, int shift, boolean isAvailable){
//        availablility[day - 1][shift] = isAvailable;
//    }
//
//    public Boolean GetAvailablity(int day, int  shift){
//        return availablility[day-1][shift];
//    }



}
