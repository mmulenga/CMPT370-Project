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
    private VolunteerGroup volunteerGroups;
    private boolean criminalRecordCheck;
    private String medicalInformation;
    private int hoursWorked;
    private String photoPath;
    private Availability availability;
    private ArrayList<String> registeredEventIDs;






}
