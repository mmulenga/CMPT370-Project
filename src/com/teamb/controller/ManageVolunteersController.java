package com.teamb.controller;


import com.teamb.view.BasicView;
import com.teamb.view.ManageVolunteersView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;


/**
 * Created by Sarah on 2017-11-19.
 */
public class ManageVolunteersController extends BasicController{



    ManageVolunteersView view;

    public ManageVolunteersController(Stage s) {
        super(s);
        view = new ManageVolunteersView();
        view.createNewVolButton.setOnAction(new createNewVolButtonEventHandler());
        view.sendEmailButton.setOnAction(new sendEmailButtonEventHandler());
        view.printPhoneListButton.setOnAction(new printPhoneListButtonEventHandler());
        view.deleteProfilesButton.setOnAction(new deleteProfilesButtonEventHandler());
        view.searchBtn.setOnAction(new searchBtnEventHandler());
    }

    class createNewVolButtonEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            ChangeToSignUpView();
        }
    }

    class sendEmailButtonEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            SendEmails(/* TODO selected vol id's*/);
        }
    }

    class printPhoneListButtonEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            PrintPhoneList();
        }
    }

    class deleteProfilesButtonEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            DeleteProfiles();
        }

    }

    class searchBtnEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            Search(view.searchKeyField.getText());
        }

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

    public void Search(String s){
        //TODO Given a string, search for volunteers
        //TODO Display new list of volunteers in view (create new view?)
        //Get input from input field
    }
}
