package com.teamb.controller;

import com.teamb.view.BasicView;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

/**
 * Created by Sarah on 2017-11-07.
 * Abstract class all controllers extend
 */
public abstract class BasicController {

    Stage stage;


    public BasicController(Stage s){
        stage = s;
    }



    //change view
    protected abstract void ChangeView();

    //public abstract void HelpPopUp(); //not sure if this will go here

    protected abstract BasicView GetView();



}
