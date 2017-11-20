package com.teamb.model;

import javafx.beans.property.BooleanProperty;

/**
 * Created by Sarah on 2017-11-20.
 */


//Class for using profiles with checkboxes.
public class ProfileCheck{
    Profile profile;
    private boolean active;
    BooleanProperty wantsEmails;
    BooleanProperty wantsPhoneCalls;

    public ProfileCheck(Profile p){
        profile = p;
        wantsEmails.setValue(p.getContactByEmail());
        wantsPhoneCalls.setValue(p.getContactByPhone());
    }

    public boolean isActive(){
        return active;
    }

    public void SetActive(boolean b){
        active = b;
    }

    public void SetProfile(Profile p){
        profile = p;
    }

    public String GetName(){
        //TODO: This may change when the guys are done
        return profile.getFirstName() + " " + profile.getLastName();
    }

    public Profile GetProfile(){
        return profile;
    }

    public boolean WantsEmails(){
        return profile.getContactByEmail();
    }

    public boolean WantsPhoneCalls(){
        return profile.getContactByPhone();
    }

    //TODO Change bools to boolean property

}
