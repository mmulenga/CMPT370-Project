package com.teamb.controller;

import com.teamb.view.BasicView;
import com.teamb.view.VolunteerLandingView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
        view = new VolunteerLandingView();
        view.epButton.setOnAction(new epButtonEventHandler());
        view.ueButton.setOnAction(new ueButtonEventHandler());
        view.cpassButton.setOnAction(new cpassButtonEventHandler());
        view.helpButton.setOnAction(new helpButtonEventHandler());
        view.pButton.setOnAction(new pButtonEventHandler());
    }

    class epButtonEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            ChangeToEditProfileView();
        }
    }


    class ueButtonEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            ChangeToBrowseEventsView();
        }
    }

    class cpassButtonEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            ChangeToChangePasswordView();
        }

    }

    class helpButtonEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            HelpPopUp();
        }
    }

    class pButtonEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            ChangeToProfileView();
        }
    }



    public void ChangeToEditProfileView(){
        SignUpController editlc = new SignUpController(stage);

        Scene scene = new Scene(editlc.GetView().GetRootPane(), 720, 540);
        stage.setScene(scene);
        stage.show();
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
