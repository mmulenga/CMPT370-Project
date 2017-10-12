package com.teamb.model;

import java.util.ArrayList;

/**
 * Created by Sarah on 2017-10-10.
 */
public class Availability {

    private boolean[][] availablility;


    Availability(){
        availablility = new boolean[7][2];
    }

    //0 = sunday, 1 = monday etc
    //0 = morning, 1 = afternoon
    void ChangeAvailability(int day, int shift, boolean isAvailable){
        availablility[day - 1][shift] = isAvailable;
    }


}
