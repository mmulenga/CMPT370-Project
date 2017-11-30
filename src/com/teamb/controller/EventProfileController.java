package com.teamb.controller;

import com.teamb.model.Event;
import com.teamb.model.VolunteerizeModel;
import com.teamb.view.BasicView;
import com.teamb.view.EventProfileView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EventProfileController extends BasicController {

    EventProfileView view;
    public EventProfileController(Stage s, VolunteerizeModel model) {
        super(s, model);
        view = new EventProfileView();
        view.backButton.setOnAction(new backButtonEventHandler());

        Event e = new Event();
        e.setEventFields(3,"I like this",11,12, "1010-12", "12299-12", "spink","Codingasdasdasdasdasdasdasdasadasasdasdasdasdasdasdsadasasdasdasd" );

        view.loadEventProfile(e);
    }

    @Override
    public BasicView GetView() {
        return view;
    }
    class backButtonEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            ChangeToProfileView(stage);
        }
    }
    public void ChangeToProfileView(Stage s){
        VolunteerLandingController vlc = new VolunteerLandingController(s, model);

        Scene scene = new Scene(vlc.GetView().GetRootPane(), 720, 540);
        s.setScene(scene);
        s.show();

    }
}
