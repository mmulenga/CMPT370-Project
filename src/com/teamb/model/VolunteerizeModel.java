package com.teamb.model;
import java.sql.*;

public class VolunteerizeModel {
    private DatabaseInterface database;
    private ResultSet result;

    public VolunteerizeModel() {
        database = new DatabaseInterface();
    }

    /**
     * Wraps the given string in single quotes (needed for database queries).
     * @param value - Attribute that from either Profile or Event.
     * @return - Returns the wrapped string.
     */
    public String wrap(String value) {
        return "'" + value + "'";
    }


    /**
     * Creates a query which takes the attributes from the given profile and inserts them
     * into the appropriate tables within the database.
     * @param volunteer - Profile of a volunteer.
     */
    public void addProfile(Profile volunteer) {
        // Insert all relevant volunteer table information.
        database.insert("volunteers (id, first_name, last_name, email, hours_worked, criminal_check)\n" +
                "VALUES(" +
                volunteer.getMemberID() +
                ", " +
                wrap(volunteer.getFirstName()) +
                ", " +
                wrap(volunteer.getLastName()) +
                ", " +
                wrap(volunteer.getEmail()) +
                ", " +
                volunteer.getHoursWorked() +
                ", " +
                "'YES'" +
                ");");
    }



    public Profile getProfile() {
        Profile profile = new Profile();

        return profile;
    }

    public void deleteProfile() {

    }

    public static void main(String args[]) {
        VolunteerizeModel model = new VolunteerizeModel();
        Profile newProfile = new Profile();

        newProfile.setAllBaseInformation("Matt",
                "Mulenga",
                "1 Evergreen Blvd",
                "3065551234",
                "3065551234",
                "Bert",
                "bert@sesamestreet.com",
                true,
                true,
                100001,
                true,
                "N/A",
                40,
                "C:/Photos",
                null);

        model.addProfile(newProfile);
    }
}
