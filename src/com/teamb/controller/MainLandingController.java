package com.teamb.controller;

import com.teamb.view.BasicView;
import com.teamb.view.MainLandingView;
import javafx.stage.Stage;

/**
 * Created by Sarah on 2017-11-07.
 *
 */
public class MainLandingController extends BasicController{

    MainLandingView mainView;
    MainLandingController(Stage s){
        super(s);
    }

    @Override
    public void ChangeView() {
        //creates appropriate view type
        //changes the view
        //changes to staff login page or volunteer login page
    }

    @Override
    protected BasicView GetView() {
        return mainView;
    }


}
