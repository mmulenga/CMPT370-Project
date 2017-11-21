package com.teamb.model;

import com.sun.xml.internal.ws.api.ha.StickyFeature;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

///**
// * Created by Sarah on 2017-11-20.
// */
//
//
////Class for using profiles with checkboxes.
//public class ProfileCheck{
//    Profile profile;
//    private BooleanProperty active;
//    BooleanProperty wantsEmails;
//    BooleanProperty wantsPhoneCalls;
//    public StringProperty firstName;
//    public StringProperty lastName;
//    public String fn;
//
//
//    public ProfileCheck(Profile p){
//        profile = p;
//        active = new SimpleBooleanProperty();
//        wantsEmails = new SimpleBooleanProperty();
//        wantsPhoneCalls = new SimpleBooleanProperty();
//        firstName = new SimpleStringProperty();
//        lastName = new SimpleStringProperty();
//        wantsEmails.setValue(p.getContactByEmail());
//        wantsPhoneCalls.setValue(p.getContactByPhone());
//        firstName.setValue(p.getFirstName());
//        lastName.setValue(p.getLastName());
//        fn = p.getFirstName();
//
//    }
//
//    public BooleanProperty isActive(){
//        return active;
//    }
//
//    public void SetActive(boolean b){
//        active.setValue(b);
//    }
//
//    public void SetProfile(Profile p){
//        profile = p;
//    }
//
//    public StringProperty GetFirstName(){
//        //TODO: This may change when the guys are done
//        return firstName;
//    }
//
//    public StringProperty GetLastName(){
//        return lastName;
//    }
//
//    public Profile GetProfile(){
//        return profile;
//    }
//
//    public BooleanProperty WantsEmails(){
//
//        return wantsEmails;
//    }
//
//    public BooleanProperty WantsPhoneCalls(){
//        return  wantsPhoneCalls;
//    }
//
//
//    public String toString(){
//        return profile.getFirstName();
//    }
//    //TODO Change bools to boolean property
//
//}
