package com.teamb.controller;

import com.teamb.view.BasicView;
import com.teamb.view.VolunteerLandingView;
import javafx.stage.Stage;

/**
 * Created by Sarah on 2017-11-19.
 */
public class VolunteerLandingController extends BasicController {

    VolunteerLandingView view;

    public VolunteerLandingController(Stage s){
        super(s);
        view = new VolunteerLandingView(this);
    }

    @Override
    protected void ChangeView() {

    }

    public void ChangeToEditProfileView(){
        //TODO
    }

    public void ChangeToBrowseEventsView(){
        //TODO
    }

    public void ChangeToProfileView(){
        //TODO
    }

    public void ChangeToChangePasswordView(){
        //TODO
    }

    public void HelpPopUp(){
        //TODO
    }

    @Override
    protected BasicView GetView() {
        return view;
    }
}
