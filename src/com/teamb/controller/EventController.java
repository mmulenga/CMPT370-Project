package com.teamb.controller;

import com.teamb.view.EventView;
import com.teamb.model.Event;
import javafx.stage.Stage;

import java.sql.*;
import java.util.ArrayList;

public class EventController extends BasicController {

    private ArrayList<Event> eventModel;
    private EventView eventView;


    EventController(Stage s) {
        super(s);

        this.eventModel = new ArrayList<Event>();
        //TODO: CALL Method that gets event list from database

        eventView = new EventView(this);

    }

    public void editEvent(Event event) {
        //TODO: CAll method that changes event in database
    }

    public void deleteEvent(Event event) {
        //TODO:Call method that deletes event from database
    }

    public ArrayList<Event> GetEventModel() {
        return eventModel;

    }

    public EventView GetView(){
        return eventView;
    }

}