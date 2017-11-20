package com.teamb.controller;

import com.teamb.view.BasicView;
import com.teamb.view.MainLandingView;
import com.teamb.view.StaffEventProfileView;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.teamb.model.Event;

/**
 * Created by David on 2017-11-20
 */
public class StaffEventProfileController{
    StaffEventProfileView staffView;
    Event event;
    Stage stage;

    public StaffEventProfileController(Stage s, Event e){
       // super(s);
        stage = s;
        event = e;
        staffView = new StaffEventProfileView(this, event);

    }

    //StaffEventProfileView staffView = new StaffEventProfileView(this, event);

    //@Override
    public StaffEventProfileView GetView() {
        return staffView;
    }

    public void ChangeToSearchReturnView(){
        //TODO
    }

    public void ChangeToEditEventView(){
        //TODO
    }



}
