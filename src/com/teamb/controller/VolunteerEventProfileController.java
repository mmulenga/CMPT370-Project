package com.teamb.controller;

/**
 * Created by David on 2017-11-20
 */

import com.teamb.model.Event;
import com.teamb.model.VolunteerizeModel;
import com.teamb.view.BasicView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import com.teamb.view.VolunteerEventProfileView;

public class VolunteerEventProfileController extends BasicController {
    VolunteerEventProfileView volunteerView;

    public VolunteerEventProfileController(Stage s, VolunteerizeModel m){
        super(s, m);
        volunteerView = new VolunteerEventProfileView();
        volunteerView.addButton.setOnAction(new addButtonEventHandler());

    }

    class addButtonEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event){
            AddToEvent(/*editEventView*/);
        }
    }

    @Override
    public VolunteerEventProfileView GetView() {
        return volunteerView;
    }



    public void AddToEvent(){
        /**Method that calls event sign up page and adds this Volunteer
        * to Event
        */
    }


}
