package com.teamb.model;

import java.util.ArrayList;

/**
 * Represents a volunteering event.
 */

public class Event{

    public int eventId;
    public String name;
    public String startTime;
    public String endTime;
    public String date;
    public int locationId;
    public String description;
    public String imagePath;
    public int typeId;


    public Event(int eventId, String name, String comments, int locationId, int TypeId){
        this.eventId = eventId;
        this.name = name;
        this.description = comments;
        this.locationId = locationId;
        this.typeId = TypeId;
       // imagePath="sample.png";
    }
}