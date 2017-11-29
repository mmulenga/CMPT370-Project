package com.teamb.controller;

import com.teamb.model.VolunteerizeModel;
import com.teamb.view.BasicView;
import com.teamb.view.StaffLandingView;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/* CODE SMELLS
    Very similar to VolunteerLandingController
    Copied due to time constraints
 */

/**
 * Created by Sarah on 2017-11-19.
 */
public class StaffLandingController extends BasicController {

    StaffLandingView view;

    public StaffLandingController(Stage s, VolunteerizeModel m){
        super(s, m);
        view = new StaffLandingView();
        view.mvButton.setOnAction(new mvButtonEventHandler());
        view.meButton.setOnAction(new meButtonEventHandler());
        view.cpassButton.setOnAction(new cpassButtonEventHandler());
        view.helpButton.setOnAction(new helpButtonEventHandler());

    }

    class mvButtonEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            ChangeToManageVolunteersView();
        }
    }

    class meButtonEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            ChangeToManageEventsView();
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


    public void ChangeToManageVolunteersView(){
        ManageVolunteersController mvc = new ManageVolunteersController(stage, model);

        Scene scene = new Scene(mvc.GetView().GetRootPane(), 800, 600);
//        scene.getStylesheets().add
//                (Volunteerize.class.getResource("LoginStyle.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public void ChangeToManageEventsView(){
        ManageEventController mvc = new ManageEventController(stage, model);

        Scene scene = new Scene(mvc.GetView().GetRootPane(), 800, 600);
//        scene.getStylesheets().add
//                (Volunteerize.class.getResource("LoginStyle.css").toExternalForm());
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
