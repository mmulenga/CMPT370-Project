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

    public Event(){
        eventId = "1";
        name = "name";
        startTime = "StartTime";
        endTime = "EndTime";
        date = "date";
        location = "location";
        description = "description";

    }

    //TODO: IMPLEMENT GETNAME AND GETDESCIPTION (Sean is working on this currently)
    public String GetName(){
        return name;
    }

    public String GetDescription(){
        return description;
    }




    public Event(int eventId, String name, String comments, int locationId, int TypeId){
        this.eventId = eventId;
        this.name = name;
        this.description = comments;
        this.locationId = locationId;
        this.typeId = TypeId;
       // imagePath="sample.png";
    }
}

