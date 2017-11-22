package com.teamb.controller;

import com.teamb.view.BasicView;
import com.teamb.view.VolunteerLandingView;
import javafx.scene.Scene;
import javafx.stage.Stage;

/* CODE SMELLS
    Very similar to StaffLandingController
    Copied due to time constraints
 */



/**
 * Created by Sarah on 2017-11-19.
 */
public class VolunteerLandingController extends BasicController {

    VolunteerLandingView view;

    public VolunteerLandingController(Stage s){
        super(s);
        view = new VolunteerLandingView(this);
    }

    public void ChangeToEditProfileView(){
        //TODO
    }

    public void ChangeToBrowseEventsView(){
        EventController ec = new EventController(stage);
        Scene scene = new Scene(ec.GetView().GetRootPane(), 600, 600);
        stage.setScene(scene);
        stage.show();
    }

    public void ChangeToProfileView(){
        VolunteerProfileController vlc = new VolunteerProfileController(stage);
        Scene scene = new Scene(vlc.GetView().GetRootPane(), 600, 600);
        stage.setScene(scene);
        stage.show();
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
