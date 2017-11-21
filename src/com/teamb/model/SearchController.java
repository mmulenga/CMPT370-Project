package com.teamb.model;

import com.teamb.controller.Startup;

import java.sql.*;

public class SearchController {

    /* ------- Instance Variables ------- */
   // private Profile[] profiles; // use int?
   // private Event[] events;

    private String toFind;
    private Profile profile;
    private Event event;

    /* ------- Getters and Setters ------- */
   // public Profile[] getProfiles() {return profiles;}
   // public Event[] getEvents() {return events;}

    public Event getEvent() {return event;}
    public void setEvent(Event e) {this.event = e}
    public Profile getProfile() {return profile;}
    public void setProfile(Profile p) {this.profile = p;}

    /* ------- Methods ------- */
   /*
    public Profile[] searchProfileid (Startup database, String profileId) {

        try {
            ResultSet result = database.createQuery("SELECT * FROM Events e WHERE e.id = " + profileId);

            while(result.next()) {


                //setProfile(); at end
                /*
                Profile p(result.getString(s: "first_name" ), result.getString(s: "last_name"), result.getString( s: "address"), result.getInt( s: "phone_number"), );

                p.setId(result.getInt("id"));
                p.setName(result.getString("name"));
                p.setDescription(result.getString("comments"));
                p.setLocation(result.getInt("location_id"));
                p.toString()etType(result.getInt("type_id"));

                */

                //  Profile(String firstName, String lastName, String address, String phoneNumber, String emergancyContactNumber, String emergancyContactName, String email,
                //boolean contactByPhone, boolean contactByEmail, String memberID, boolean criminalRecordCheck, String medicalInformation, int hoursWorked, String photoPath,
                //       Availability availability)
/*
            }
        } catch(Exception e) {
            System.out.println("Profile search failed.");
        }


    }

    public Event[] searchEvent (String searchBy) {

    }
}
*/