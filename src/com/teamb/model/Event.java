package com.teamb.model;

import java.util.ArrayList;

/**
 * Represents a volunteering event.
 */

public class Event{

    private String eventId;
    private String name;
    private String startTime;
    private String endTime;
    private String date;
    private String location;
    private String description;

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



}

