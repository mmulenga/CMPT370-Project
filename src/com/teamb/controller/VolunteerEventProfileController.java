package com.teamb.controller;

/**
 * Created by David on 2017-11-20
 */

import com.teamb.model.Event;
import com.teamb.view.BasicView;
import javafx.stage.Stage;
import com.teamb.view.VolunteerEventProfileView;

public class VolunteerEventProfileController extends BasicController {
    VolunteerEventProfileView volunteerView;

    public VolunteerEventProfileController(Stage s){
        super(s);
        volunteerView = new VolunteerEventProfileView(this);

    }


    @Override
    public BasicView GetView() {
        return volunteerView;
    }



    public void AddToEvent(){
        /**Method that calls event sign up page and adds this Volunteer
        * to Event
        */
    }


}
