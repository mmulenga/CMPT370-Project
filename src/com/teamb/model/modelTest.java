package com.teamb.model;

import java.util.ArrayList;
import org.junit.*;

public class modelTest(){

    public void profileTest(){
    	System.out.println("starting profile Test\n");
    	Profile pro = new Profile();
    	Availability avail = new Availability();
    	pro.setAllBaseInformation("bill","bob","johnson","seventh.ave", "234-3433", 
    		"e3e3e3", "num", "jim", "jack", "jill", 1234, "fudge", "foobar.st", 
    		"foo@bar.com", false, true, 321, false, "med", 543, 10, "path", avail);


    	assert("bill",pro.getFirstName());
    	System.out.println("first name");
    	assert("bob",pro.getMiddleName());
    	System.out.println("middle name");
    	assert("johnson",pro.getLastName());
    	System.out.println("last name");
    	assert("seventh.ave",pro.getAddress());
    	System.out.println("address");
		assert("234-3433",pro.getPhoneNumber());
    	System.out.println("phone number");
    	assert("e3e3e3",pro.getPostalCode());
    	System.out.println("postal code");
    	assert("num",pro.getEmergencyContactPhoneNumber());
    	System.out.println("emerg contact phone number");
    	assert("jim",pro.getEmergencyContactFirst());
    	System.out.println("emerg contact first");
    	assert("jack",pro.getEmergencyContactMiddle());
    	System.out.println("emerg contact middle");
    	assert("jill",pro.getEmergencyContactLast());
    	System.out.println("emerg contact last");
    	assert("1234",pro.getEmergencyContactID());
    	System.out.println("emerg contact ID");
    	assert("fudge",pro.getEmergencyContactPostalCode());
    	System.out.println("emerg postal code");
    	assert("foobar.st",pro.getEmergencyContactAddress());
    	System.out.println("emerg contact address");
    	assert("foo@bar.com",pro.getEmail());
    	System.out.println("email");
    	assert(false,pro.getContactByPhone());
    	System.out.println("contact by phone");
    	assert(true,pro.getContactByEmail());
    	System.out.println("contact by email");
    	assert(321,pro.getMemberNumber());
    	System.out.println("member number");
    	assert(false,pro.getCriminalRecordCheck());
    	System.out.println("criminal rec check");
    	assert("med",pro.getMedicalInformation());
    	System.out.println("med info");
    	assert(534,pro.getMemberID());
    	System.out.println("member id");
    	assert(10,pro.getHoursWorked());
    	System.out.println("hours worked");
    	assert("path",pro.getPhotoPath());
    	System.out.println("photoPath");


    	System.out.println("Done profile check");
    }

    public void eventTest(){
    	Event ev = new Event();

    	ev.setEventID(123);
    	assert(123,ev.getEventID());
    	System.out.println("event id");
    	ev.setEventName("nope");
    	assert("nope",pro.getEventName());
    	System.out.println("event name");
    	ev.setEventStartTime(200);
    	assert(200,pro.getEventStartTime());
    	System.out.println("event start time");
    	ev.setEventEndTime(1200);
    	assert(1200,pro.getEventEndTime());
    	System.out.println("event end time");
    	ev.setEventStartDate("time");
    	assert("time",pro.getEventStartDate());
    	System.out.println("event start date");
    	ev.setEventEndDate("over");
    	assert("over",pro.getEventEndDate());
    	System.out.println("event end date");
    	ev.setEventLocation("here");
    	assert("here",pro.getEventLocation());
    	System.out.println("event location");

    }









    static public int main(String[]){
        System.out.println("Starting model testing.\n");

        profileTest();


        return 1;
    }

}