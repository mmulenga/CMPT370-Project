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
     * Wraps the given string in single quotes (needed for database queries).
     * @param value - Attribute that from either Profile or Event.
     * @return - Returns the wrapped string.
     */
    private String wrap(String value) {
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
                ", " + wrap(volunteer.getFirstName()) +
                ", " + wrap(volunteer.getLastName()) +
                ", " + wrap(volunteer.getEmail()) +
                ", " + volunteer.getHoursWorked() +
                ", " + "'YES'" +
                ");");

        // Insert all contact information.
        database.update("contact_information (prefer_phone, prefer_email, phone_number, address, postal_code, " +
                "volunteer_id, emergency_contact_id)\n " +
                "VALUES(" +
                volunteer.getContactByPhone() +
                ", " + volunteer.getContactByEmail() +
                ", " + volunteer.getPhoneNumber() +
                ", " + wrap(volunteer.getAddress()) +
                ", " + wrap(volunteer.getPostalCode()) +
                ", " + volunteer.getMemberID() +
                ", " + volunteer.getEmergencyContactID() +
                ");");

        // Insert all emergency contact information.
        database.update("emergency_contact (id, first_name, middle_name, last_name, phone_number, address, postal_code)\n " +
                "VAlUES(" + volunteer.getEmergencyContactID() +
                ". " + wrap(volunteer.getEmergencyFirst()) +
                ", " + wrap(volunteer.getEmergencyMiddle()) +
                ", " + wrap(volunteer.getEmergencyLast()) +
                ", " + wrap(volunteer.getEmergencyContactPhoneNumber()) +
                ", " + wrap(volunteer.getEmergencyContactAddress()) +
                ", " + wrap(volunteer.getEmergencyContactPostalCode()) +
                ");");
    }

    /**
     * Updates the database entry for the given profile.
     * PROFILE ID MUST MATCH
     * @param volunteer - Profile with update volunteer information.
     */
    public void editProfile(Profile volunteer) {
        // Insert all relevant volunteer table information.
        database.update("volunteers SET \n" +
                "first_name = " + wrap(volunteer.getFirstName()) +
                ", \n" + "last_name = " + wrap(volunteer.getLastName()) +
                ", \n" + "email = " + wrap(volunteer.getEmail()) +
                ", \n" + "hours_worked = " + volunteer.getHoursWorked() +
                ", \n" + "criminal_check = " + "'YES'" +
                "\n WHERE id = " + volunteer.getMemberID());

        // Insert all contact information.
        database.insert("contact_information SET \n " +
                "prefer_phone = " + volunteer.getContactByPhone() +
                ", \n" + "prefer_email = " + volunteer.getContactByEmail() +
                ", \n" + "phone_number = " + volunteer.getPhoneNumber() +
                ", \n" + "address = " + wrap(volunteer.getAddress()) +
                ", \n" + "postal_code = " + wrap(volunteer.getPostalCode()) +
                ", \n" + "volunteer_id = " + volunteer.getMemberID() +
                ", \n" + "emergency_contact_id = " + volunteer.getEmergencyContactID());

        // Insert all emergency contact information.
        database.insert("emergency_contact SET \n " +
                "id = " + volunteer.getEmergencyContactID() +
                ", \n" + "first_name = " + wrap(volunteer.getEmergencyFirst()) +
                ", \n" + "middle_name = " + wrap(volunteer.getEmergencyMiddle()) +
                ", \n" + "last_name = " + wrap(volunteer.getEmergencyLast()) +
                ", \n" + "phone_number = " + wrap(volunteer.getEmergencyContactPhoneNumber()) +
                ", \n" + "address = " + wrap(volunteer.getEmergencyContactAddress()) +
                ", \n" + "postal_code = " + wrap(volunteer.getEmergencyContactPostalCode()) + " ]\n WHERE ");
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
