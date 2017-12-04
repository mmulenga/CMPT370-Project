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
        eventView.PopulateEventList(eventModel);
        eventView.backButton.setOnAction(new EventController.backButtonEventHandler());
        loadButtons();



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

    public void loadButtons(){
        for(int i = 0; i < eventView.buttons.size(); i++){
            int temp = i;
            eventView.buttons.get(i).setOnAction((ActionEvent)->{
                changeToVolunterEventProfileView(temp);
                System.out.println(eventView.readMore.getId());
            });


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

    public void changeToVolunterEventProfileView(int id){
        Event event = eventModel.get(id);
        VolunteerEventProfileController vlc = new VolunteerEventProfileController(stage, model, event);

        Scene scene = new Scene(vlc.GetView().GetRootPane(), 720, 540);
        stage.setScene(scene);
        stage.show();

    }

    public EventView GetView(){
        return eventView;
    }

}
