package com.teamb.controller;

import com.teamb.view.BasicView;
import com.teamb.view.StaffLandingView;
import javafx.stage.Stage;


/* CODE SMELLS
    Very similar to VolunteerLandingController
    Copied due to time constraints
 */

/**
 * Created by Sarah on 2017-11-19.
 */
public class StaffLandingController extends BasicController {

    StaffLandingView view;

    public StaffLandingController(Stage s){
        super(s);
        view = new StaffLandingView(this);

    }

    public void ChangeToManageVolunteersView(){
        //TODO
    }

    public void ChangeToManageEventsView(){
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
