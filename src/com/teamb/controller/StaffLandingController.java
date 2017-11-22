package com.teamb.controller;

import com.teamb.view.BasicView;
import com.teamb.view.StaffLandingView;
import javafx.scene.Scene;
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
        ManageVolunteersController mvc = new ManageVolunteersController(stage);

        Scene scene = new Scene(mvc.GetView().GetRootPane(), 800, 600);
//        scene.getStylesheets().add
//                (Volunteerize.class.getResource("LoginStyle.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public void ChangeToManageEventsView(){
        ManageEventController mvc = new ManageEventController(stage);

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
