package com.teamb.model;
import java.sql.*;

public class VolunteerizeModel {
    private DatabaseInterface database;
    private Profile profile;
    private Users user;

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    /**
     * Constructor for VolunteerizeModel.
     */
    public VolunteerizeModel() {
        database = new DatabaseInterface();
        profile = new Profile();
        user = new Users();
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
     *
     * @param username
     * @param password
     * @return
     */
    public void login(String username, String password) {
        ResultSet result = database.select("* FROM users u WHERE u.username = " +
                wrap(username) + " AND password = " + wrap(password) + ";");

        try {
            result.next();
            user.setUsername("username");
            user.setProfileID(result.getInt("volunteer_id"));
            user.setIsStaff(result.getBoolean("is_staff"));
            profile = getProfile(user.getProfileID());
        } catch(SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void addUser(Users user) {
        database.insert("users (username, password, is_staff, volunteer_id)\n " +
                "VALUES (" +
                wrap(user.getUsername()) + ", " +
                wrap(user.getPassword()) + ", " +
                user.getIsStaff() + ", " +
                user.getProfileID() +
                ");");
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
     * Retrieves the profile associated with the given ID.
     * @param id - An integer referring to the profile we want.
     * @return Returns the profile associated with the given ID.
     */
    public Profile getProfile(int id) {
        ResultSet volunteer;
        ResultSet contactInformation;
        ResultSet emergencyContact;

        Profile newProfile = new Profile();

        volunteer = database.select(" * FROM volunteers WHERE id = " + id + ";");
        contactInformation = database.select(" * FROM contact_information WHERE volunteer_id = " + id + ";");
        emergencyContact = database.select(" * FROM emergency_contact WHERE volunteer_id = " + id + ";");

        try {
            volunteer.next();
            contactInformation.next();
            emergencyContact.next();

            newProfile.setAllBaseInformation(volunteer.getString("first_name"),
                    volunteer.getString("middle_name"),
                    volunteer.getString("last_name"),
                    contactInformation.getString("address"),
                    contactInformation.getString("phone_number"),
                    contactInformation.getString("postal_code"),
                    emergencyContact.getString("phone_number"),
                    emergencyContact.getString("first_name"),
                    emergencyContact.getString("middle_name"),
                    emergencyContact.getString("last_name"),
                    emergencyContact.getInt("id"),
                    emergencyContact.getString("postal_code"),
                    emergencyContact.getString("address"),
                    volunteer.getString("email"),
                    contactInformation.getBoolean("prefer_phone"),
                    contactInformation.getBoolean("prefer_email"),
                    volunteer.getInt("id"),
                    volunteer.getBoolean("criminal_check"),
                    volunteer.getString("medical_info"),
                    volunteer.getInt("hours_worked"),
                    volunteer.getString("photo_path"),
                    null
            );
        } catch(SQLException exception) {
            exception.printStackTrace();
        }

        return newProfile;
    }

    /**
     * Creates a query which takes the attributes from the given event and inserts them
     * into the appropriate tables within the database.
     * @param newEvent - Event with insert information.
     */
    public void addEvent(Event newEvent) {
        // TODO - Figure out how we're storing locations application-side.

        // Converts int values to string, and if necessary adds a zero so that is will be
        // properly formatted in the SQL query
        String startTime = "0" + Integer.toString(newEvent.getStartTime());
        if (newEvent.getStartTime() < 1000)
            startTime = "0" + startTime;

        String endTime = Integer.toString(newEvent.getEndTime());
        if (newEvent.getEndTime() < 1000)
            endTime = "0" + endTime;

        database.insert("events (name, start_time, end_time, description, location_id)\n " +
                "VALUES (" +
                wrap(newEvent.getEventName()) + ", " +
                 "to_timestamp('" + newEvent.getStartDate() +" " + startTime + "', 'DD/MM/YYYY HH24MI'), " +
                "to_timestamp('" + newEvent.getEndDate() +" " + endTime + "', 'DD/MM/YYYY HH24MI'), " +
                wrap(newEvent.getDescription()) + ", " +
                0 +
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
    public String getProfileDataType (String choice) {
        String dataType;

        if (choice.equals("Id"))
            dataType = "v.id  ";
        else if (choice.equals("First Name"))
            dataType = "v.first_name  ";
        else if (choice.equals("Last Name"))
            dataType = "v.last_name ";
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
            dataType = "e.start_time ";
        else if (choice.equals("End Time"))
            dataType = "e.end_time ";  // What else can be searched by?
        else
            dataType = "fail"; // meaning you can't search by this data type
        return dataType;
    }

    /**
     * Finds the requested profile from the database and returns it.
     * @param query - String with the data that is being looked for.
     * @param dataType - String with data type of query.
     */
    public ResultSet getVolunteerSet(String query, String dataType ) {

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
                    "c.prefer_email, " +
                    "c.phone_number, " +
                    "c.address, " +
                    "c.postal_code, " +
                    "e.first_name as emergency_contact_first_name, " +
                    "e.middle_name as emergency_contact_middle_name, " +
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
        return rs;
    }

    public Profile[] searchProfiles(String query, String dataType ) {
        String dbDataType = getProfileDataType(dataType);
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
        ResultSet profilesSought = getVolunteerSet(query,dbDataType);

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
     * Finds the requested event and returns a set with all instances of it.
     * @param query - String with the data that is being looked for.
     * @param dataType - String with data type of query.
     */
    public ResultSet getEventSet(String query, String dataType ) {
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

    /**
     * returns an array of events containing all matching instances
     * @param query - String with the data that is being looked for.
     * @param dataType - String with data type of query.
     */
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
        ResultSet eventsSought = getEventSet(query,dbDataType);

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
        Users newUser = new Users();

        newUser.setProfileID(1);
        newUser.setUsername("Jimmy");
        newUser.setPassword("jam");
        newUser.setIsStaff(true);

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

        model.addUser(newUser);
        model.login("Matt", "beans");

        model.deleteProfile(newProfile);
    }
}
