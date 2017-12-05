package com.teamb.model;

import java.util.ArrayList;
import org.junit.*;

public class modelTest{

	public modelTest(){}

	public Profile setProfile(){
		Profile pro = Profile();
		Availability avail = new Availability();
		pro.setAllBaseInformation("bill","bob","johnson","seventh.ave", "234-3433", 
    		"e3e3e3", "num", "jim", "jack", "jill", 1234, "fudge", "foobar.st", 
    		"foo@bar.com", false, true, 321, false, "med", 543, 10, "path", avail);

		return pro;
	}

	public void setInvalidStaffUsers(Users u){
    	u.setUsername("jim");
    	u.setPassword("pass");
    	u.setIsStaff(true);
    	u.setProfileID(12345);
    	return u;
	}
	public void setValidStaffUsers(Users u){
    	u.setUsername("staff");
    	u.setPassword("staff");
    	u.setIsStaff(true);
    	u.setProfileID(12345);
    	return u;
	}

	public Users setInvalidVolunteerUsers(Users u){
    	u.setUsername("jim");
    	u.setPassword("pass");
    	u.setIsStaff(false);
    	u.setProfileID(12345);
    	return u;
	}
	public void setValidVolunteerUsers(Users u){
    	u.setUsername("volunteer");
    	u.setPassword("volunteer");
    	u.setIsStaff(false);
    	u.setProfileID(12345);
    	return u;
	}





    public void profileTest(){
    	System.out.println("starting profile Test\n");
    	Profile pro = new Profile();
    	Availability avail = new Availability();
    	pro.setAllBaseInformation("bill","bob","johnson","seventh.ave", "234-3433", 
    		"e3e3e3", "num", "jim", "jack", "jill", 1234, "fudge", "foobar.st", 
    		"foo@bar.com", false, true, 321, false, "med", 543, 10, "path", avail);


    	assertEquals("bill",pro.getFirstName());
    	System.out.println("first name");
    	assertEquals("bob",pro.getMiddleName());
    	System.out.println("middle name");
    	assertEquals("johnson",pro.getLastName());
    	System.out.println("last name");
    	assertEquals("seventh.ave",pro.getAddress());
    	System.out.println("address");
		assertEquals("234-3433",pro.getPhoneNumber());
    	System.out.println("phone number");
    	assertEquals("e3e3e3",pro.getPostalCode());
    	System.out.println("postal code");
    	assertEquals("num",pro.getEmergencyContactPhoneNumber());
    	System.out.println("emerg contact phone number");
    	assertEquals("jim",pro.getEmergencyContactFirst());
    	System.out.println("emerg contact first");
    	assertEquals("jack",pro.getEmergencyContactMiddle());
    	System.out.println("emerg contact middle");
    	assertEquals("jill",pro.getEmergencyContactLast());
    	System.out.println("emerg contact last");
    	assertEquals("1234",pro.getEmergencyContactID());
    	System.out.println("emerg contact ID");
    	assertEquals("fudge",pro.getEmergencyContactPostalCode());
    	System.out.println("emerg postal code");
    	assertEquals("foobar.st",pro.getEmergencyContactAddress());
    	System.out.println("emerg contact address");
    	assertEquals("foo@bar.com",pro.getEmail());
    	System.out.println("email");
    	assertEquals(false,pro.getContactByPhone());
    	System.out.println("contact by phone");
    	assertEquals(true,pro.getContactByEmail());
    	System.out.println("contact by email");
    	assertEquals(321,pro.getMemberNumber());
    	System.out.println("member number");
    	assertEquals(false,pro.getCriminalRecordCheck());
    	System.out.println("criminal rec check");
    	assertEquals("med",pro.getMedicalInformation());
    	System.out.println("med info");
    	assertEquals(534,pro.getMemberID());
    	System.out.println("member id");
    	assertEquals(10,pro.getHoursWorked());
    	System.out.println("hours worked");
    	assertEquals("path",pro.getPhotoPath());
    	System.out.println("photoPath");


    	System.out.println("Done profile check\n");
    }

    public void eventTest(){
    	System.out.println("starting event Test.\n");
    	Event ev = new Event();

    	ev.setEventID(123);
    	assertEquals(123,ev.getEventID());
    	System.out.println("event id");
    	ev.setEventName("nope");
    	assertEquals("nope",pro.getEventName());
    	System.out.println("event name");
    	ev.setEventStartTime(200);
    	assertEquals(200,pro.getEventStartTime());
    	System.out.println("event start time");
    	ev.setEventEndTime(1200);
    	assertEquals(1200,pro.getEventEndTime());
    	System.out.println("event end time");
    	ev.setEventStartDate("time");
    	assertEquals("time",pro.getEventStartDate());
    	System.out.println("event start date");
    	ev.setEventEndDate("over");
    	assertEquals("over",pro.getEventEndDate());
    	System.out.println("event end date");
    	ev.setEventLocation("here");
    	assertEquals("here",pro.getEventLocation());
    	System.out.println("event location");

    	System.out.println("done event test.\n");
    }


    public void usersTest(){
    	System.out.println("starting users Test.\n");
    	Users u;
    	u.setUsername("jim");
    	u.setPassword("pass");
    	u.setIsStaff(true);
    	u.setprofileID(12345);

    	assertEquals("jim",u.getUsername());
    	assertEquals("pass",u.getPassword());
    	assertEquals(true,u.getIsStaff());
    	assertEquals(12345,u.getProfileID());

    	System.out.println("done users Test.\n");
    }

    public void volunteerizeModelTest(){
    	System.out.println("starting volunteerize model Test.\n");
    	 
    	VolunteerizeModel vol = new VolunteerizeModel();
    	Users user;
    	Users temp;
    	setUsers(user);
    	Profile pro = setProfile();

    	vol.setProfile(pro);
    	vol.setUser(user);
    	pro = new Profile();

    	vol.login("staff","staff"); // should login
    	temp = vol.getUser();
    	assertEquals("staff",temp.getUsername());

    	vol.login("volunteer","volunteer"); // should login
    	temp = vol.getUser();
    	assertEquals(temp.getUsername(),"volunteer");

    	vol.login("bill", "turd"); // should not login
    	temp = vol.getUser();
    	assertEquals(temp.getUsername(),"volunteer");

    	vol.login("staff", "Staff"); // should not login
    	temp = vol.getUser();
    	assertEquals(temp.getUsername(),"volunteer");

    	vol.login("Staff", "staff"); // should not login
    	temp = vol.getUser();
    	assertEquals(temp.getUsername(),"volunteer"); 

    	System.out.println("login is correct");


    	


    	System.out.println("done volunteerize model Test.\n");
    }





	public static void main(String[] args){
        System.out.println("Starting model testing.\n");

        profileTest();
        eventTest();
        usersTest();

        return 1;
    }

}