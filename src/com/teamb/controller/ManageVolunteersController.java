package com.teamb.controller;


import com.teamb.view.BasicView;
import com.teamb.view.ManageVolunteersView;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * Created by Sarah on 2017-11-19.
 */
public class ManageVolunteersController extends BasicController{



    ManageVolunteersView view;

    public ManageVolunteersController(Stage s) {
        super(s);
        view = new ManageVolunteersView(this);
    }

    @Override
    public BasicView GetView() {
        return view;
    }


    public void ChangeToSignUpView(){
        SignUpController c = new SignUpController(stage);
        Scene scene = new Scene(c.GetView().GetRootPane(),600,600);
        stage.setScene(scene);
        stage.show();

    }

    public void SendEmails(/*TODO*/){
        //TODO will send Emails to given Volunteers (use volunteer id)
    }

    public void PrintPhoneList(/*TODO*/){
        //TODO will get phone numbers of given Volunteers (use volunteer id)
    }

    public void DeleteProfiles(/*TODO*/){
        //TODO will delete given profiles
    }
}
