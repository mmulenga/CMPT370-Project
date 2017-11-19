package com.teamb.controller;

import com.teamb.view.EventView;
import com.teamb.model.Event;

import java.sql.*;
import java.util.ArrayList;

public class EventController {
    private ArrayList<Event> eventModel;
    private EventView eventView;

    /* ------- Instance Variables ------- */
    private int id;
    private int startTime;
    private int endTime;
    private int startDate;
    private int endDate;
    private int location;
    private int type;
    private String imagePath;

    private String name;
    private String description;


    /* ------- Getters and Setters ------- */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public int getStartDate() {
        return startDate;
    }

    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }

    public int getEndDate() {
        return endDate;
    }

    public void setEndDate(int endDate) {
        this.endDate = endDate;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /* ------- Methods ------- */
    public EventController(EventView ev){
        this.eventModel = new ArrayList<Event>();
        this.eventView = ev;
        Startup start = new Startup();
        start.establishConnection();
        createEventList(start);
        eventView.displayEventList(eventModel);

    }

    public void createEventList(Startup database) {
        try {
            ResultSet result = database.createQuery("SELECT * FROM Events e");

            while(result.next()) {

                setId(result.getInt("id"));
                setName(result.getString("name"));
                setDescription(result.getString("comments"));
                setLocation(result.getInt("location_id"));
                setType(result.getInt("type_id"));

                Event temp = new Event(getId(),getName(),getDescription(),getLocation(),getType());
                eventModel.add(temp);
                System.out.println("ID: " + getId() +
                        " Event Name: " + getName() +
                        " Description: " + getDescription() +
                        " Location ID: " + getLocation() +
                        " Type ID: " + getType());
            }
        } catch(Exception e) {
            System.out.println("Event view failed.");
        }
    }


    public void createEvent(int eventId, String eventName, String eventComments, int locationId, int typeId) {

    }

    public void editEvent() {

    }

    public void deleteEvent() {

    }


    public void viewEvent(Startup database, String eventId) {
        try {
            ResultSet result = database.createQuery("SELECT * FROM Events e WHERE e.id = " + eventId);

            while(result.next()) {
                setId(result.getInt("id"));
                setName(result.getString("name"));
                setDescription(result.getString("comments"));
                setLocation(result.getInt("location_id"));
                setType(result.getInt("type_id"));

                System.out.println("ID: " + getId() +
                        " Event Name: " + getName() +
                        " Description: " + getDescription() +
                        " Location ID: " + getLocation() +
                        " Type ID: " + getType());
            }
        } catch(Exception e) {
            System.out.println("Event view failed.");
        }
    }

    public void viewAllEvents(Startup database) {
        try {
            ResultSet result = database.createQuery("SELECT * FROM Events e");

            while(result.next()) {
                setId(result.getInt("id"));
                setName(result.getString("name"));
                setDescription(result.getString("comments"));
                setLocation(result.getInt("location_id"));
                setType(result.getInt("type_id"));

                System.out.println("ID: " + getId() +
                        " Event Name: " + getName() +
                        " Description: " + getDescription() +
                        " Location ID: " + getLocation() +
                        " Type ID: " + getType());
            }
        } catch(Exception e) {
            System.out.println("Event view failed.");
        }
    }
}
