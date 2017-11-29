package com.teamb.controller;

import com.teamb.Volunteerize;
import com.teamb.model.Availability;
import com.teamb.model.Profile;
import com.teamb.model.VolunteerizeModel;
import com.teamb.view.BasicView;
import com.teamb.view.VolunteerProfileView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class VolunteerProfileController extends BasicController {

    VolunteerProfileView view;
    public VolunteerProfileController(Stage s, VolunteerizeModel m) {
        super(s, m);
        view = new VolunteerProfileView();
        view.displayProfile(model.getProfile());
        view.home.setOnAction(new homeEventHandler());
       // view.editProfile.setOnAction(new editProfileEventHandler());
    }
    class homeEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            changeToHomePageView(stage);

        }
    }


    @Override
    public BasicView GetView() {
        return view;
    }

    public void changeToHomePageView(Stage s){
        VolunteerLandingController slc = new VolunteerLandingController(s, model);

        Scene scene = new Scene(slc.GetView().GetRootPane(), 720, 540);
        s.setScene(scene);
        s.show();

    }

}

