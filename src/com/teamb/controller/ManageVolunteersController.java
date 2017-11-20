package com.teamb.controller;

import com.teamb.model.Availability;
import com.teamb.model.Profile;
import com.teamb.model.ProfileCheck;
import com.teamb.model.VolunteerGroup;
import com.teamb.view.BasicView;
import com.teamb.view.ManageVolunteersView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Observable;

/**
 * Created by Sarah on 2017-11-19.
 */
public class ManageVolunteersController extends BasicController{


    ArrayList<Profile> allProfiles;
    ArrayList<Profile> filteredProfiles;
    ObservableList<Profile> observableProfiles;

    ManageVolunteersView view;

    public ManageVolunteersController(Stage s) {
        super(s);
        view = new ManageVolunteersView(this);
    }

    public ObservableList<ProfileCheck> CreateDummyList(){
        //TODO: Create observable list of ProfileChecks from a list of Profiles instead
        ObservableList<ProfileCheck> dummyList = FXCollections.observableArrayList();

        for (int i = 0; i < 10; i++) {
           Profile profile = new Profile();
           ProfileCheck pc = new ProfileCheck(profile);
           pc.SetActive(false);
           dummyList.add(pc);
        }
        return dummyList;
    }


    @Override
    protected BasicView GetView() {
        return view;
    }
}
