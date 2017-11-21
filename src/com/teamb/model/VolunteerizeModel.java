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

    public Profile GetVolunteer(String query, String dataType ) {

        String dbDataType;
        Profile p;


        if (dataType == "Id")
            dbDataType = "v.id  ";
        else if (dataType == "First Name")
            dbDataType = "v.first_name  ";
        else if (dataType == "Last Name")
            dbDataType = "v.last_name";
        else if (dataType == " STUFF")
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
                        rs.getString("last_name"),
                        rs.getString("address"),
                        rs.getInt("phone_number"),
                        rs.getInt("emergency_contact_phone_number"),
                        rs.getString("emergency_contact_first_name"),
                        rs.getString("email"),
                        rs.getBoolean("prefer_phone"),
                        rs.getBoolean("prefer_email"),
                        rs.getInt("id"),
                        rs.getBoolean("criminal_check"),
                        rs.getString("medical_info"),
                        rs.getInt("hours_worked"),
                        rs.getString("photo_path")//,
                        //rs.getString(avail)
                );
            }catch(SQLException exception) {
                System.out.println("Insert query failed.");

                exception.printStackTrace();
            }
            return p;


        return p;
    }


    public Event GetEvent(String query, String dataType ) {

        Event e;
        String dbDataType;

        if (dataType == "Id")
            dbDataType = "e.id  ";
        else if (dataType == "Name")
            dbDataType = "e.name  ";
        else if (dataType == "StartTime")
            dbDataType = "e.start_time";
        else if (dataType == "End Time")
            dbDataType = "e.end_time";  // What else can be searched by?
        else
            dbDataType = "fail"; // meaning you can't search by this data type

        try{

            ResultSet rs = database.select( "e.id, " +
                    "e.name, ");

            // NEED DATA BASE ACCESS
            e.setEventName(rs.getString("name"));

        }catch(SQLException exception) {
            System.out.println("Insert query failed.");

            exception.printStackTrace();
        }

        return e;
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
