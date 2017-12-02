package com.teamb.controller;

import com.teamb.Volunteerize;
import com.teamb.model.VolunteerizeModel;
import com.teamb.view.EventView;
import com.teamb.model.Event;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.*;
import java.util.ArrayList;

public class EventController extends BasicController {

    private ArrayList<Event> eventModel;
    private EventView eventView;
    private Event tempEvent;

    EventController(Stage s, VolunteerizeModel m) {
        super(s, m);

        this.eventModel = model.getUpcomingEvents();
        //TODO: CALL Method that gets event list from database

        eventView = new EventView();
        eventView.backButton.setOnAction(new EventController.backButtonEventHandler());
        PopulateEventList();


    }

    public void editEvent(Event event) {
        //TODO: CAll method that changes event in database

        VolunteerizeModel model = new VolunteerizeModel();
        //event passed in must already be altered.
        model.editEvent(event);

    }

    public void deleteEvent(Event event) {
        //TODO:Call method that deletes event from database

        VolunteerizeModel model = new VolunteerizeModel();
        //event passed in is one to be deleted.
        model.deleteEvent(event);
    }

    public ArrayList<Event> GetEventModel() {
        return eventModel;

    }

    public void PopulateEventList(){
        for(int i = 0; i < eventModel.size(); i++){
            eventView.gp = new GridPane();
            ColumnConstraints column1 = new ColumnConstraints();
            column1.setPercentWidth(33);
            eventView.gp.getColumnConstraints().addAll(column1, column1, column1);
            Label title = new Label();

            title.setText(eventModel.get(i).getEventName());
            Label description = new Label();
            description.setWrapText(true);
            description.setText(eventModel.get(i).getDescription());
            eventView.readMore = new Button("Read More");
            tempEvent = eventModel.get(i);
            eventView.readMore.setOnAction((ActionEvent)->{
                changeToVolunterEventProfileView(tempEvent);
            });
            eventView.gp.add(title, 1, 0 );
            eventView.gp.add(description, 1, 1, 2, 1);
            eventView.gp.add(eventView.readMore, 2, 2 );
            eventView.eventListBox.getChildren().add(eventView.gp);
            System.out.println(i + " " +title.getText());
        }
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

    public void changeToVolunterEventProfileView(Event event){
        VolunteerEventProfileController vlc = new VolunteerEventProfileController(stage, model, event);

        Scene scene = new Scene(vlc.GetView().GetRootPane(), 720, 540);
        stage.setScene(scene);
        stage.show();

    }

    public EventView GetView(){
        return eventView;
    }

}
