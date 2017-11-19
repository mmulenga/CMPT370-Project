package com.teamb.controller;

import com.teamb.view.BasicView;
import javafx.stage.Stage;

/**
 * Created by Sarah on 2017-11-07.
 * Abstract class all controllers extend
 */
public abstract class BasicController {

     public BasicController(){

    }



    //change view
    protected abstract void ChangeView(Stage stage);

    //public abstract void HelpPopUp(); //not sure if this will go here

}
