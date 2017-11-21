package com.teamb.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

import java.util.ArrayList;

/**
 * Created by Sarah on 2017-10-10.
 */
public class Availability {
    public boolean[][] availablility;
    public Availability()
    {
        availablility = new boolean[7][3];
        for(int i=0;i<7;i++){
            for(int j=0;j<3;j++){
                availablility[i][j] = false;
            }
        }
    }

    //0 = monday, 1 = tuesday etc
    //0 = morning, 1 = afternoon
    public void ChangeAvailability(int day, int shift, boolean isAvailable){
        availablility[day][shift] = isAvailable;
    }

    public Boolean GetAvailablity(int day, int  shift){
        return availablility[day-1][shift];
   }

   public ArrayList<Shift> fetchAvailabiliity(){
        ArrayList<Shift> sList = new ArrayList<Shift>();
       Shift morningShift = new Shift("Morning",availablility[0][0],availablility[1][0],availablility[2][0],
               availablility[3][0],availablility[4][0],availablility[5][0],
               availablility[6][0]);
       Shift afternoonShift = new Shift("Afternoon",availablility[0][1],availablility[1][1],availablility[2][1],
               availablility[3][1],availablility[4][1],availablility[5][1],
               availablility[6][1]);
       Shift eveningShift = new Shift("Evening",availablility[0][2],availablility[1][2],availablility[2][2],
               availablility[3][2],availablility[4][2],availablility[5][2],
               availablility[6][2]);
       sList.add(morningShift);
       sList.add(afternoonShift);
       sList.add(eveningShift);
       return sList;
    }



}
