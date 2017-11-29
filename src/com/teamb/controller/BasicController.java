package com.teamb.controller;

import com.teamb.Volunteerize;
import com.teamb.model.VolunteerizeModel;
import com.teamb.view.BasicView;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

/* CODE SMELLS
    All controllers are very similar - have similar functions
    Tried to reduce code smell using this abstract class
    Could be used to do more controller functions
    Much more could be done to reduce this code duplication
 */

/**
 * Created by Sarah on 2017-11-07.
 * Abstract class all controllers extend
 */
public abstract class BasicController {

    Stage stage;
    VolunteerizeModel model;


    public BasicController(Stage s, VolunteerizeModel model){
        stage = s;
        this.model = model;
    }



    //public abstract void HelpPopUp(); //not sure if this will go here

    protected abstract BasicView GetView();
}
