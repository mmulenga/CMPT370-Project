package com.teamb.model;
import java.sql.*;

public class VolunteerizeModel {
    private DatabaseInterface database;

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
     *
     * @param username
     * @param password
     * @return
     */
    public Profile login(String username, String password) {
        int profileID;

        ResultSet result = database.select("* FROM users u WHERE u.username = " +
                wrap(username) + " AND password = " + wrap(password) + ";");

        try {
            result.next();
            profileID = result.getInt("volunteer_id");
        } catch(SQLException exception) {
            exception.printStackTrace();

            return null;
        }

        return getProfile(profileID);
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
                "VALUES (" +
                volunteer.getMemberID() + ", " +
                wrap(volunteer.getFirstName()) + ", " +
                wrap(volunteer.getLastName()) + ", " +
                wrap(volunteer.getEmail()) + ", " +
                volunteer.getHoursWorked() + ", " +
                "'YES'" +
                ");");

        // Insert all emergency contact information.
        database.insert("emergency_contact (id, first_name, middle_name, last_name," +
                " phone_number, address, postal_code, volunteer_id)\n " +
                "VALUES (" + volunteer.getEmergencyContactID() + ", " +
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
                "volunteer_id, emergency_contact_id)\n " +
                "VALUES (" +
                volunteer.getContactByPhone() + ", " +
                volunteer.getContactByEmail() + ", " +
                volunteer.getPhoneNumber() + ", " +
                wrap(volunteer.getAddress()) + ", " +
                wrap(volunteer.getPostalCode()) + ", " +
                volunteer.getMemberID() + ", " +
                volunteer.getEmergencyContactID() +
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
        database.insert("events (name, start_time, end_time, description, location_id)\n " +
                "VALUES (" +
                wrap(newEvent.getEventName()) + ", " +
                newEvent.getStartTime() + ", " +
                newEvent.getEndTime() + ", " +
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
     *
     * @param query
     * @param dataType
     * @return
     */
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
            e.setStartDate( rs.getDate("start_date"));   // in database is a timestamp, so date and time are together
            e.setEndDate( rs.getDate("end_date"));
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
        Users newUser = new Users();

        newUser.setProfileID(1);
        newUser.setUsername("Jimmy");
        newUser.setPassword("jam");
        newUser.setIsStaff(false);

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
