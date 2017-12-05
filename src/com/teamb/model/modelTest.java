package com.teamb.model;

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


    	assertEquals("it broke!!!!!", "bill",pro.getFirstName());
    	System.out.println("first name");
    	assertEquals("it broke!!!!!", "bob",pro.getMiddleName());
    	System.out.println("middle name");
    	assertEquals("it broke!!!!!", "johnson",pro.getLastName());
    	System.out.println("last name");
    	assertEquals("it broke!!!!!", "seventh.ave",pro.getAddress());
    	System.out.println("address");
		assertEquals("it broke!!!!!", "234-3433",pro.getPhoneNumber());
    	System.out.println("phone number");
    	assertEquals("it broke!!!!!", "e3e3e3",pro.getPostalCode());
    	System.out.println("postal code");
    	assertEquals("it broke!!!!!", "num",pro.getEmergencyContactPhoneNumber());
    	System.out.println("emerg contact phone number");
    	assertEquals("it broke!!!!!", "jim",pro.getEmergencyContactFirst());
    	System.out.println("emerg contact first");
    	assertEquals("it broke!!!!!", "jack",pro.getEmergencyContactMiddle());
    	System.out.println("emerg contact middle");
    	assertEquals("it broke!!!!!", "jill",pro.getEmergencyContactLast());
    	System.out.println("emerg contact last");
    	assertEquals("it broke!!!!!", "1234",pro.getEmergencyContactID());
    	System.out.println("emerg contact ID");
    	assertEquals("it broke!!!!!", "fudge",pro.getEmergencyContactPostalCode());
    	System.out.println("emerg postal code");
    	assertEquals("it broke!!!!!", "foobar.st",pro.getEmergencyContactAddress());
    	System.out.println("emerg contact address");
    	assertEquals("it broke!!!!!", "foo@bar.com",pro.getEmail());
    	System.out.println("email");
    	assertEquals("it broke!!!!!", false,pro.getContactByPhone());
    	System.out.println("contact by phone");
    	assertEquals("it broke!!!!!", true,pro.getContactByEmail());
    	System.out.println("contact by email");
    	assertEquals("it broke!!!!!", 321,pro.getMemberNumber());
    	System.out.println("member number");
    	assertEquals("it broke!!!!!", false,pro.getCriminalRecordCheck());
    	System.out.println("criminal rec check");
    	assertEquals("it broke!!!!!", "med",pro.getMedicalInformation());
    	System.out.println("med info");
    	assertEquals("it broke!!!!!", 534,pro.getMemberID());
    	System.out.println("member id");
    	assertEquals("it broke!!!!!", 10,pro.getHoursWorked());
    	System.out.println("hours worked");
    	assertEquals("it broke!!!!!", "path",pro.getPhotoPath());
    	System.out.println("photoPath");


    	System.out.println("Done profile check\n");
    }

    public void eventTest(){
    	System.out.println("starting event Test.\n");
    	Event ev = new Event();

    	ev.setEventID(123);
    	assertEquals("it broke!!!!!", 123,ev.getEventID());
    	System.out.println("event id");
    	ev.setEventName("nope");
    	assertEquals("it broke!!!!!", "nope",pro.getEventName());
    	System.out.println("event name");
    	ev.setEventStartTime(200);
    	assertEquals("it broke!!!!!", 200,pro.getEventStartTime());
    	System.out.println("event start time");
    	ev.setEventEndTime(1200);
    	assertEquals("it broke!!!!!", 1200,pro.getEventEndTime());
    	System.out.println("event end time");
    	ev.setEventStartDate("time");
    	assertEquals("it broke!!!!!", "time",pro.getEventStartDate());
    	System.out.println("event start date");
    	ev.setEventEndDate("over");
    	assertEquals("it broke!!!!!", "over",pro.getEventEndDate());
    	System.out.println("event end date");
    	ev.setEventLocation("here");
    	assertEquals("it broke!!!!!", "here",pro.getEventLocation());
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

    	assertEquals("it broke!!!!!", "jim",u.getUsername());
    	assertEquals("it broke!!!!!", "pass",u.getPassword());
    	assertEquals("it broke!!!!!", true,u.getIsStaff());
    	assertEquals("it broke!!!!!", 12345,u.getProfileID());

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
    	assertEquals("it broke!!!!!", "staff",temp.getUsername());

    	vol.login("volunteer","volunteer"); // should login
    	temp = vol.getUser();
    	assertEquals("it broke!!!!!", temp.getUsername(),"volunteer");

    	vol.login("bill", "turd"); // should not login
    	temp = vol.getUser();
    	assertEquals("it broke!!!!!", temp.getUsername(),"volunteer");

    	vol.login("staff", "Staff"); // should not login
    	temp = vol.getUser();
    	assertEquals("it broke!!!!!", temp.getUsername(),"volunteer");

    	vol.login("Staff", "staff"); // should not login
    	temp = vol.getUser();
    	assertEquals("it broke!!!!!", temp.getUsername(),"volunteer"); 

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