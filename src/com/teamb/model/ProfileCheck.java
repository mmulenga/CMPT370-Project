package com.teamb.model;

import javafx.beans.property.BooleanProperty;

/**
 * Created by Sarah on 2017-11-20.
 */


//Class for using profiles with checkboxes.
public class ProfileCheck{
    Profile profile;
    private BooleanProperty active;
    BooleanProperty wantsEmails;
    BooleanProperty wantsPhoneCalls;


    public ProfileCheck(Profile p){
        profile = p;

        wantsEmails.setValue(p.ContactByEmail());
        wantsPhoneCalls.setValue(p.ContactByPhone());
    }

    public BooleanProperty isActive(){
        return active;
    }

    public void SetActive(boolean b){
        active.setValue(b); ;
    }

    public void SetProfile(Profile p){
        profile = p;
    }

    public String GetName(){
        //TODO: This may change when the guys are done
        return profile.GetName();
    }

    public Profile GetProfile(){
        return profile;
    }

    public BooleanProperty WantsEmails(){

        return wantsEmails;
    }

    public BooleanProperty WantsPhoneCalls(){
        return  wantsPhoneCalls;
    }

    //TODO Change bools to boolean property

}
