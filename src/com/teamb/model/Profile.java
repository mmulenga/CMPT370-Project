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
    private String photoPath;
    private String medicalInformation;
    
    private int memberNumber; // set by WDM
    private int memberID; // set by dataBase
    private int hoursWorked;
    
    private boolean contactByEmail;
    private boolean contactByPhone;
    private boolean criminalRecordCheck;
    
    private VolunteerGroup volunteerGroups;//Irene: maybe we don't need VolunteerGroup, if there is new group, we can add to the enum option in the table
    
    private Availability availability;
    
    private ArrayList<Integer> registeredEventIDs;



    Profile(){
        this.volunteerGroups = new VolunteerGroup();
        this.availability = new Availability();
        this.registeredEventIDs = new ArrayList<Integer>(); //defaults to size 10
    }

//////////////////////////////Sean Start
    /**
     * sets values for a new volunteer profile object with the given information.
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
    public void setAllBaseInformation(String firstName, String lastName, String address, String phoneNumber, String emergancyContactNumber, String emergancyContactName, String email,
            boolean contactByPhone, boolean contactByEmail, int memberID, boolean criminalRecordCheck, String medicalInformation, int hoursWorked, String photoPath,
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
        //this.availability = new Availability();
        //this.availability = availability;
    }

    //////////////////////////////////////////////////////////
    // set specific fields of info 

    /**
    * setFirstName(name)
    * @param name - first name
    */
    public void setFirstName(String name){
        this.firstName = name;
    }
    /**
     * 
     * @param last - last name
     */
    public void setLastName(String last){
        this.lastName = last;
    }
    /**
     * 
     * @param streetAddress (eg. 1234 Albert.Ave)
     */
    public void setAddress(String streetAddress){
        this.address = streetAddress;
    }
    /**
     * 
     * @param number - phone number
     */
    public void setPhoneNumber(String number){
        this.phoneNumber = number;
    }
    /**
     * 
     * @param name - full name of emergency contact
     */
    public void setEmergencyContactName(String name){
        this.emergancyContactName = name;
    }
    /**
     * 
     * @param number - phone number of emergency contact
     */
    public void setEmergencyContactNumber(String number){
        this.emergancyContactNumber = number;
    }
    /**
     * 
     * @param emailAddress (eg. foo@bar.com)
     */
    public void setEmail(String emailAddress){
        this.email = emailAddress;
    }
    /**
     * 
     * @param value if the prefer to be contacted by email
     */
    public void setcontactByEmail(boolean value){
        this.contactByEmail = value;
    }
    /**
     * 
     * @param value - if they have a criminal record check
     */
    public void setCriminalReccordCheck(boolean value){
        this.criminalRecordCheck = value;
    }
    /**
     * 
     * @param info - applicable medical information 
     */
    public void setMedicalInformation(String info){
        this.medicalInformation = info;
    }
    /**
     * 
     * @param value - current hours worked 
     */
    public void setHoursWorked(int value){
        this.hoursWorked = value;
    }
    /**
     * 
     * @param time - Availability matrix 7x2
     */
    public void setAvailability(Availability time){
        this.availability = time;
    }
    /**
     * 
     * @param path - location of image
     */
    public void setPhotoPath(String path){
        this.photoPath = path;
    }

    //////////////////////////////////////////////////////
    // add to specific fields of info

    /**
     * 
     * @param ID - int, event ID
     */
    public void addEventID(int ID){
        this.registeredEventIDs.add(ID);
    }
    /**
     * 
     * @param value - int, additional hours worked 
     */
    public void addHoursWorked(int value){
        this.hoursWorked += value;
    }
    /**
     * 
     * @param groupName 
     */
    public void addToGroup(String groupName){
        volunteerGroups.addGroup(groupName);
    }


    //////////////////////////////////////////////////////
    //get info in the specified field


    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public boolean getContactByMail(){
        return this.contactByEmail;
    }
    public String getAddress(){
        return this.address;
    }
    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    public String getEmergencyContactName(){
        return this.emergancyContactName;
    }
    public String getEmergencyContactNumber(){
        return this.emergancyContactNumber;
    }
    public String getEmail(){
        return this.email;
    }
    public boolean getContactByEmail(){
        return this.contactByEmail;
    }
    public int getMemberID(){
        return this.memberID;
    }
    public boolean getCriminalReccordCheck(){
        return this.criminalRecordCheck;
    }
    public String getMedicalInformation(){
        return this.medicalInformation;
    }
    public int getHoursWorked(){
        return this.hoursWorked;
    }
    public Availability getAvailability(){
        return this.availability;
    }
    public String getPhotoPath(){
        return this.photoPath;
    }

    //////////////////////////////////////////////
    // remove items
    
    public void removeFromGroup(String groupName){
        volunteerGroups.removeGroup(groupName);
    }
}
