package com.teamb.controller;

import com.teamb.model.Availability;
import com.teamb.model.Profile;
import com.teamb.view.BasicView;
import com.teamb.view.VolunteerProfileView;
import javafx.stage.Stage;

public class VolunteerProfileController extends BasicController {

    VolunteerProfileView view;
    public VolunteerProfileController(Stage s) {
        super(s);
        view = new VolunteerProfileView(this);
        Profile profile=new Profile();
        profile.setAllBaseInformation("Wang","","Mengjia","35 Agar pl","306","S7H"
                ,"306","cici","",""
                ,234,"S","s","sda",true,true,
                324,true,"sda",2,"asd",new Availability());
        view.displayProfile(profile);
    }


    @Override
    public BasicView GetView() {
        return view;
    }
}
