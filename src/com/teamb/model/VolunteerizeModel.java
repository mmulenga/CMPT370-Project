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

    public void deleteProfile(Profile volunteer) {
        database.delete( "volunteers WHERE id =" + volunteer.getMemberID() + "CASCADE;");
    }

    public Profile searchVolunteer(String query, String dataType ) {

        String dbDataType;
        Profile p = new Profile();


        if (dataType.equals("Id"))
            dbDataType = "v.id  ";
        else if (dataType.equals("First Name"))
            dbDataType = "v.first_name  ";
        else if (dataType.equals("Last Name"))
            dbDataType = "v.last_name";
        else if (dataType.equals(" STUFF")) // Place holder while we wait for more options
            dbDataType = "stuff";  // What else can be searched by?
        else
            dbDataType = "fail"; // meaning you can't search by this data type


            ResultSet rs = database.select( "v.id, " +
                    "u.type, " +
                    "v.first_name, " +
                    "v.middle_name, " +
                    "v.last_name, " +
                    "v.email, " +
                    "v.hours_worked, " +
                    "v.criminal_check, " +
                    "v.medical_info, " +
                    "v.photo_path, " +
                    "g.name as volunteer_group, " +
                    "c.prefer_phone, " +
                    "c.prefer_email," +
                    "c.phone_number, " +
                    "c.address, " +
                    "c.postal_code, " +
                    "e.first_name as emergency_contact_first_name, " +
                    "e.middle_name as emergency_contact_middle_name," +
                    "e.last_name as emergency_contact_last_name, " +
                    "e.id as emergency_contact_id, " +
                    "e.phone_number as emergency_contact_phone_number, " +
                    "e.address as emergency_contact_address, " +
                    "e.postal_code as emergency_contact_postal_code " +
                    "FROM users u, " +
                    "volunteers v, " +
                    "contact_information c, " +
                    "emergency_contact e, " +
                    "volunteer_group g, " +
                    "volunteer_group_members m " +
                    "where u.volunteer_id = v.id " +
                    "and c.volunteer_id = v.id " +
                    "and c.emergency_contact_id = e.id " +
                    "and m.volunteer_id = v.id " +
                    "and m.group_id = g.id " +
                    "and " + dbDataType + " = " + query);

            try {

                p.setAllBaseInformation(rs.getString("first_name"),
                        rs.getString( "middle_name"),
                        rs.getString("last_name"),
                        rs.getString("address"),
                        rs.getString("phone_number"),
                        rs.getString( "postal_code"),
                        rs.getString("emergency_contact_phone_number"),
                        rs.getString("emergency_contact_first_name"),
                        rs.getString("emergency_contact_middle_name"),
                        rs.getString("emergency_contact_last_name"),
                        rs.getInt("emergency_contact_id"),
                        rs.getString("emergency_contact_adress"),
                        rs.getString("emergency_contact_postal_code"),
                        rs.getString("email"),
                        rs.getBoolean("prefer_phone"),
                        rs.getBoolean("prefer_email"),
                        rs.getInt("id"),
                        rs.getBoolean("criminal_check"),
                        rs.getString("medical_info"),
                        rs.getInt("hours_worked"),
                        rs.getString("photo_path"),
                        null  // availability is not clearly defined
                );


            }catch(SQLException exception) {
                System.out.println("Insert query failed.");

                exception.printStackTrace();
            }
            return p;



    }


    public Event searchEvent(String query, String dataType ) {

        Event e = new Event();
        String dbDataType;

        if (dataType.equals("Id"))
            dbDataType = "e.id  ";
        else if (dataType.equals("Name"))
            dbDataType = "e.name  ";
        else if (dataType.equals("StartTime"))
            dbDataType = "e.start_time";
        else if (dataType.equals("End Time"))
            dbDataType = "e.end_time";  // What else can be searched by?
        else
            dbDataType = "fail"; // meaning you can't search by this data type

        try{

            ResultSet rs = database.select( "e.id, " +
                    "e.name, " +
                    "e.start_time, " +
                    "e.end_time, " +
                    "e.description, " +
                    "l.name as location_name, " +
                    "l.address, " +
                    "l.postal_code " +
                    "FROM events e, locations l " +
                    "WHERE l.id = e.location.id " +
                    "and " + dbDataType + " = " + query);


            e.setEventName( rs.getString("name"));
            e.setDescription( rs.getString("description"));
            e.setStartDate( rs.getInt("start_date"));   // in database is a timestamp, so date and time are together
            e.setEndDate( rs.getInt("end_date"));
            e.setStartTime( rs.getInt ("start_time"));
            e.setEndTime( rs.getInt ("end_time"));
            e.setLocation(rs.getString( "location_name")); // do we need address?

        }catch(SQLException exception) {
            System.out.println("Insert query failed.");

            exception.printStackTrace();
        }

        return e;
    }



    public static void main(String args[]) {
        VolunteerizeModel model = new VolunteerizeModel();
        Profile newProfile = new Profile();
/*
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
*/
        model.addProfile(newProfile);
    }
}
