package com.teamb.controller;

import com.teamb.model.Availability;
import com.teamb.model.Profile;
import com.teamb.model.VolunteerGroup;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Observable;

/**
 * Created by Sarah on 2017-11-19.
 */
public class ManageVolunteersController {


    ArrayList<Profile> allProfiles;
    ArrayList<Profile> filteredProfiles;
    ObservableList<Profile> observableProfiles;

    ArrayList<Profile> CreateDummyList(){
        ArrayList<Profile> dummyList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
           Profile profile = new Profile("Firstname", "LastName", "Address", "phone", "" +
                   "Emergancy Contact #", "Emergancy Contact Name", "Email", true, true,
                   "MemberID", true, "Medical Info", i, "PhotoPath",
                   new Availability());
           dummyList.add(profile);
        }
        return dummyList;
    }




}
