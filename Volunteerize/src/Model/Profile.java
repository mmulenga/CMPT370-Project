package Model;

import java.util.ArrayList;

/**
 * Created by Sarah on 2017-10-10.
 */
public class Profile {


    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String emergancyContactNumber;
    private String emergancyContactName;
    private String email;
    private enum contactPreference { PHONE, EMAIL};
    private String memberID;
    private VolunteerGroup volunteerGroups;//Irene: maybe we don't need VolunteerGroup, if there is new group, we can add to the enum option in the table
    private boolean criminalRecordCheck;
    private String medicalInformation;
    private int hoursWorked;
    private String photoPath;
    private Availability availability;
    private ArrayList<String> registeredEventIDs;


    Profile(String firstName, String lastName, String address, String phoneNumber, String emergancyContactNumber, String emergancyContactName, String email,
            String contactPreference, String memberID, boolean criminalRecordCheck, String medicalInformation, int hoursWorked, String photoPath,
            Availability availability){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emergancyContactName = emergancyContactName;
        this.emergancyContactNumber = emergancyContactNumber;
        this.email = email;
        this.contactPreference = contactPreference;
        this.memberID = memberID;
        this.criminalRecordCheck = criminalRecordCheck;
        this.medicalInformation = medicalInformation;
        this.hoursWorked = hoursWorked;
        this.photoPath = photoPath;
        this.availability = new Availability();
        this.availability = availability;
    }






}
