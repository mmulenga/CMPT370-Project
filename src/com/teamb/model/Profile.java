package com.teamb.model;

import java.util.ArrayList;

/**
 * Represents all the information and functions of the volunteer profile. 
 */
public class Profile {



    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String emergancyContactNumber;
    private String emergancyContactName;
    private String email;
    private boolean contactByPhone;
    private boolean contactByEmail;
    private String memberID;
    private VolunteerGroup volunteerGroups;//Irene: maybe we don't need VolunteerGroup, if there is new group, we can add to the enum option in the table
    private boolean criminalRecordCheck;
    private String medicalInformation;
    private int hoursWorked;
    private String photoPath;
    private Availability availability;
    private ArrayList<String> registeredEventIDs;

    /**
     * Creates a new volunteer profile object with the given information.
     *
     * @param firstName
     * @param lastName
     * @param address
     * @param phoneNumber
     * @param emergancyContactNumber
     * @param emergancyContactName
     * @param email
     * @param contactByPhone true if the volunteer wants to be contacted by phone
     * @param contactByEmail true if the volunteer wants to be contacted by email
     * @param memberID
     * @param criminalRecordCheck
     * @param medicalInformation short paragraph outlining any relevant medical information
     * @param hoursWorked
     * @param photoPath file path to the volunteer photo
     * @param availability availability in the morning and afternoon of each weekday
     */
    public Profile(String firstName, String lastName, String address, String phoneNumber, String emergancyContactNumber, String emergancyContactName, String email,
            boolean contactByPhone, boolean contactByEmail, String memberID, boolean criminalRecordCheck, String medicalInformation, int hoursWorked, String photoPath,
            Availability availability){

        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emergancyContactName = emergancyContactName;
        this.emergancyContactNumber = emergancyContactNumber;
        this.email = email;
        this.contactByEmail = contactByEmail;
        this.contactByPhone = contactByPhone;
        this.memberID = memberID;
        this.criminalRecordCheck = criminalRecordCheck;
        this.medicalInformation = medicalInformation;
        this.hoursWorked = hoursWorked;
        this.photoPath = photoPath;
        this.availability = new Availability();
        this.availability = availability;
    }


    public String GetName(){
        return firstName + " " + lastName;
    }

    public boolean ContactByPhone(){
        return contactByPhone;
    }

    public boolean ContactByEmail(){
        return contactByEmail;
    }



}
