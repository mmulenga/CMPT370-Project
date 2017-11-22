package com.teamb.model;
import java.sql.*;

public class VolunteerizeModel {
    private DatabaseInterface database;
    private ResultSet result;

    /**
     * Constructor for VolunteerizeModel.
     */
    public VolunteerizeModel() {
        database = new DatabaseInterface();
    }

    /**
     * Wraps the given string in single quotes (needed for database queries,
     * specifically strings within queries).
     * @param value - String to be wrapped in single quotes
     *              - eg. John -> 'John'
     * @return - Returns the wrapped string.
     */
    private String wrap(String value) {
        return "'" + value + "'";
    }


    /**
     * Creates a query which takes the attributes from the given profile and inserts them
     * into the appropriate tables within the database.
     * @param volunteer - Profile with insert information.
     */
    public void addProfile(Profile volunteer) {
        // Insert all relevant volunteer table information.
        database.insert("volunteers (id, first_name, last_name, email, hours_worked, criminal_check)\n" +
                "VALUES (DEFAULT, " +
                wrap(volunteer.getFirstName()) + ", " +
                wrap(volunteer.getLastName()) + ", " +
                wrap(volunteer.getEmail()) + ", " +
                volunteer.getHoursWorked() + ", " +
                "'YES'" +
                ");");

        // Insert all emergency contact information.
        database.insert("emergency_contact (id, first_name, middle_name, last_name," +
                " phone_number, address, postal_code, volunteer_id)\n " +
                "VALUES (DEFAULT, " +
                wrap(volunteer.getEmergencyContactFirst()) + ", " +
                wrap(volunteer.getEmergencyContactMiddle()) + ", " +
                wrap(volunteer.getEmergencyContactLast()) + ", " +
                wrap(volunteer.getEmergencyContactPhoneNumber()) + ", " +
                wrap(volunteer.getEmergencyContactAddress()) + ", " +
                wrap(volunteer.getEmergencyContactPostalCode()) + ", " +
                volunteer.getMemberID() +
                ");");

        // Insert all contact information.
        database.insert("contact_information (prefer_phone, prefer_email, phone_number, address, postal_code, " +
                "volunteer_id)\n " +
                "VALUES (" +
                volunteer.getContactByPhone() + ", " +
                volunteer.getContactByEmail() + ", " +
                volunteer.getPhoneNumber() + ", " +
                wrap(volunteer.getAddress()) + ", " +
                wrap(volunteer.getPostalCode()) + ", " +
                volunteer.getMemberID() +
                ");");
    }

    /**
     * Updates the database entry for the given profile.
     * PROFILE ID MUST MATCH
     * @param volunteer - Profile with update information.
     */
    public void editProfile(Profile volunteer) {
        // Insert all relevant volunteer table information.
        database.update("volunteers SET \n" +
                "first_name = " + wrap(volunteer.getFirstName()) + ", \n" +
                "last_name = " + wrap(volunteer.getLastName()) + ", \n" +
                "email = " + wrap(volunteer.getEmail()) + ", \n" +
                "hours_worked = " + volunteer.getHoursWorked() + ", \n" +
                "criminal_check = " + "'YES'" + " \n" +
                "WHERE id = " + volunteer.getMemberID() + ";");

        // Insert all contact information.
        database.update("contact_information SET \n " +
                "prefer_phone = " + volunteer.getContactByPhone() + ", \n" +
                "prefer_email = " + volunteer.getContactByEmail() + ", \n" +
                "phone_number = " + volunteer.getPhoneNumber() + ", \n" +
                "address = " + wrap(volunteer.getAddress()) + ", \n" +
                "postal_code = " + wrap(volunteer.getPostalCode()) + ", \n" +
                "volunteer_id = " + volunteer.getMemberID() + " \n" +
                "WHERE volunteer_id = " + volunteer.getMemberID() + ";");

        // Insert all emergency contact information.
        database.update("emergency_contact SET \n " +
                "id = " + volunteer.getEmergencyContactID() + ", \n" +
                "first_name = " + wrap(volunteer.getEmergencyContactFirst()) + ", \n" +
                "middle_name = " + wrap(volunteer.getEmergencyContactMiddle()) + ", \n" +
                "last_name = " + wrap(volunteer.getEmergencyContactLast()) + ", \n" +
                "phone_number = " + wrap(volunteer.getEmergencyContactPhoneNumber()) + ", \n" +
                "address = " + wrap(volunteer.getEmergencyContactAddress()) + ", \n" +
                "postal_code = " + wrap(volunteer.getEmergencyContactPostalCode()) + "\n " +
                "WHERE volunteer_id = " + volunteer.getMemberID() + ";");
    }

    /**
     * Deletes the all relevant entries for the given profile.
     * @param volunteer - Profile with delete information.
     */
    public void deleteProfile(Profile volunteer) {
        // TODO - Fix cascade, currently does not delete contact_information.
        database.delete("volunteers WHERE id = " + volunteer.getMemberID() + ";");
    }


    /**
     * Creates a query which takes the attributes from the given event and inserts them
     * into the appropriate tables within the database.
     * @param newEvent - Event with insert information.
     */
    public void addEvent(Event newEvent) {
        // TODO - Figure out how we're storing locations application-side.
        String startTime = null;
        startTime.valueOf(newEvent.getStartTime());
        String endTime = null;
        endTime.valueOf(newEvent.getEndTime());

        database.insert("events (name, start_time, end_time, description, location_id)\n " +
                "VALUES (" +
                wrap(newEvent.getEventName()) + ", " +
                newEvent.getStartDate() + " " + endTime + "00, " +
                newEvent.getEndDate() + " " + startTime + "00, " +
                wrap(newEvent.getDescription()) + ", " +
                newEvent.getLocation() +
                ");");
    }

    /**
     * Updates the database entry for the given event.
     * EVENT ID MUST MATCH
     * @param newEvent - Event with update information.
     */
    public void editEvent(Event newEvent) {
        database.update("events SET\n " +
                "name = " + wrap(newEvent.getEventName()) + ", \n" +
                "start_time = " + newEvent.getStartTime() + ", \n" +
                "end_time = " + newEvent.getEndTime() + ", \n" +
                "description = " + wrap(newEvent.getDescription()) + ", \n" +
                "location_id = " + newEvent.getLocation() + " \n");
    }

    /**
     * Deletes the all relevant entries for the given profile.
     * @param newEvent - Event with delete information.
     */
    public void deleteEvent(Event newEvent) {
        database.delete("events WHERE id = " + newEvent.getEventID() + ";");
    }

    /**
     * Adds event Participants to table in Database
     * @param e - Event that participant will go to.
     * @param p - Profile of participant.
     * @param j - Job that they will do.
     */
    public void addEventParticipants( Event e, Profile p, Jobs j) {
        database.insert("event_participants (id, volunteer_id, event_id, job_id)\n " +
                "VALUES (DEFAULT" +
                e.getEventID() + ", " +
                p.getMemberID() + ", " +
                "0);");

    }



    /**
     * Discovers type of data sought, and returns a formatted type for PostgreSQL.
     * @param choice - String with data type of query.
     */
    public String getVolunteerDataType (String choice) {

        String dataType;


        if (choice.equals("Id"))
            dataType = "v.id  ";
        else if (choice.equals("First Name"))
            dataType = "v.first_name  ";
        else if (choice.equals("Last Name"))
            dataType = "v.last_name";
        else if (choice.equals("Availability")) // Place holder while we wait for more options
            dataType = "LIST ";  // What else can be searched by?
        else
            dataType = "fail"; // meaning you can't search by this data type

        return dataType;
    }

    /**
     * Discovers type of data sought, and returns a formatted type for PostgreSQL.
     * @param choice - String with data type of query.
     */
    public String getEventDataType (String choice) {

        String dataType;

        if (choice.equals("Id"))
            dataType = "e.id  ";
        else if (choice.equals("Name"))
            dataType = "e.name  ";
        else if (choice.equals("StartTime"))
            dataType = "e.start_time";
        else if (choice.equals("End Time"))
            dataType = "e.end_time";  // What else can be searched by?
        else
            dataType = "fail"; // meaning you can't search by this data type

        return dataType;

    }

    /**
     * Finds the requested profile from the database and returns it.
     * @param query - String with the data that is being looked for.
     * @param dataType - String with data type of query.
     */
    public ResultSet getVolunteer(String query, String dataType ) {

        Profile p = new Profile();

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
                    "and " + dataType + " = " + query);

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
                System.out.println("Search query failed.");

                exception.printStackTrace();
        }
        return rs;



    }

    public Profile[] searchProfiles(String query, String dataType ) {
        String dbDataType = getEventDataType(dataType);
        int numOfValues = 0;

        try{
            ResultSet rs = database.count( "FROM users u, " +
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
                            "and " + dataType + " = " + query);
            numOfValues = rs.getInt("count");




        }catch(SQLException exception) {
            System.out.println("Count query failed.");

            exception.printStackTrace();
        }

        Profile [] profilesSearched = new Profile[numOfValues];
        ResultSet profilesSought = getEvent(query,dbDataType);

        try {

            for(int i = 0; i < numOfValues; i++){
                Event e = new Event();

                profilesSearched[i].setAllBaseInformation(profilesSought.getString("first_name"),
                        profilesSought.getString( "middle_name"),
                        profilesSought.getString("last_name"),
                        profilesSought.getString("address"),
                        profilesSought.getString("phone_number"),
                        profilesSought.getString( "postal_code"),
                        profilesSought.getString("emergency_contact_phone_number"),
                        profilesSought.getString("emergency_contact_first_name"),
                        profilesSought.getString("emergency_contact_middle_name"),
                        profilesSought.getString("emergency_contact_last_name"),
                        profilesSought.getInt("emergency_contact_id"),
                        profilesSought.getString("emergency_contact_adress"),
                        profilesSought.getString("emergency_contact_postal_code"),
                        profilesSought.getString("email"),
                        profilesSought.getBoolean("prefer_phone"),
                        profilesSought.getBoolean("prefer_email"),
                        profilesSought.getInt("id"),
                        profilesSought.getBoolean("criminal_check"),
                        profilesSought.getString("medical_info"),
                        profilesSought.getInt("hours_worked"),
                        profilesSought.getString("photo_path"),
                        null  // availability is not clearly defined
                );

                profilesSought.next();

            }

        }catch(SQLException exception) {
            System.out.println("Count query failed.");

            exception.printStackTrace();
        }



        return profilesSearched;

    }

    /**
     * Finds the requested event from the database and returns it.
     * @param query - String with the data that is being looked for.
     * @param dataType - String with data type of query.
     */
    public ResultSet getEvent(String query, String dataType ) {

        Event e = new Event();

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
                "and " + dataType + " = " + query);



        return rs;
    }

    public Event[] searchEvents(String query, String dataType ) {

        String dbDataType = getEventDataType(dataType);
        int numOfValues = 0;

        try{
            ResultSet rs = database.count( "events e, locations l " +
                "WHERE l.id = e.location.id " +
                "and " + dbDataType + " = " + query);
                numOfValues = rs.getInt("count");




        }catch(SQLException exception) {
            System.out.println("Count query failed.");

            exception.printStackTrace();
        }

        Event [] eventsSearched = new Event[numOfValues];
        ResultSet eventsSought = getEvent(query,dbDataType);

        try {

            for(int i = 0; i < numOfValues; i++){
                Event e = new Event();

                eventsSearched[i].setEventFields(eventsSought.getInt("id"),
                        eventsSought.getString("name"),
                        eventsSought.getInt( "start_time"),
                        eventsSought.getInt( "end_time"), // may need to format times properly.
                        eventsSought.getString( "start_date"),
                        eventsSought.getString( "end_date"),
                        eventsSought.getString( "location_name"),
                        eventsSought.getString("description"));

                eventsSought.next();

            }

        }catch(SQLException exception) {
            System.out.println("Count query failed.");

            exception.printStackTrace();
        }


        return eventsSearched;
    }


        public static void main(String args[]) {
        VolunteerizeModel model = new VolunteerizeModel();
        Profile newProfile = new Profile();

        newProfile.setAllBaseInformation("Matt",
                null,
                "Mulenga",
                "1 Evergreen Blvd",
                "5551234",
                "S7S 7S7",
                "5551234",
                "Ernie",
                "B.",
                "Bond",
                100001,
                "SES AME",
                "1 Sesame Street",
                "bert@sesamestreet.com",
                true,
                true,
                100001,
                true,
                "N/A",
                40,
                "C:/Photos",
                null);

        model.deleteProfile(newProfile);
    }
}
