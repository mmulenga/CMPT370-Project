package com.teamb.controller;

import com.teamb.Volunteerize;
import com.teamb.model.VolunteerizeModel;
import com.teamb.view.BasicView;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/* CODE SMELLS
    All controllers are very similar - have similar functions
    Tried to reduce code smell using this abstract class
    Could be used to do more controller functions
    Much more could be done to reduce this code duplication
 */

/**
 * Created by Sarah on 2017-11-07.
 * Abstract class all controllers extend
 */
public abstract class BasicController {

    Stage stage;
    VolunteerizeModel model;


    public BasicController(Stage s, VolunteerizeModel model){
        stage = s;
        this.model = model;
    }



    //public abstract void HelpPopUp(); //not sure if this will go here

    protected abstract BasicView GetView();

    public void changeToHomePageView(Stage s){
        VolunteerLandingController slc = new VolunteerLandingController(s, model);

        Scene scene = new Scene(slc.GetView().GetRootPane(), 720, 540);
        s.setScene(scene);
        s.show();

    }


    /*TODO these two methods seem to be the same*/
    public void ChangeToMainLandingView(Stage s){
        StaffLandingController vlc = new StaffLandingController(s, model);

        Scene scene = new Scene(vlc.GetView().GetRootPane(), 720, 540);
        s.setScene(scene);
        s.show();

    }

    public void ChangeToMainLandingView(){
        MainLandingController mlc = new MainLandingController(stage, model);
        Scene scene = new Scene(mlc.GetView().GetRootPane(), 600, 600);
        stage.setScene(scene);
        stage.show();
    }









    public void ChangeToLandingView(Stage s){

        if(model.getUser().getIsStaff()){

            StaffLandingController slc = new StaffLandingController(s, model);

            Scene scene = new Scene(slc.GetView().GetRootPane(), 720, 540);
            //scene.getStylesheets().add("LoginStyle.css");
            s.setScene(scene);
            s.show();
        }
        else{
            VolunteerLandingController vlc = new VolunteerLandingController(s, model);

            Scene scene = new Scene(vlc.GetView().GetRootPane(), 720, 540);
//        scene.getStylesheets().add
//                (Volunteerize.class.getResource("LoginStyle.css").toExternalForm());
            s.setScene(scene);
            s.show();
        }

    }





    public void ChangeToSignUpView(){
        SignUpController c = new SignUpController(stage, model);
        Scene scene = new Scene(c.GetView().GetRootPane(),600,600);
        stage.setScene(scene);
        stage.show();

    }



    public void ChangeToProfileView(Stage s){
        VolunteerLandingController vlc = new VolunteerLandingController(s, model);

        Scene scene = new Scene(vlc.GetView().GetRootPane(), 720, 540);
        s.setScene(scene);
        s.show();

    }

    public void ChangeToSearchReturnView(){
        //TODO
    }

    public void ChangeToEditEventView(){
        //TODO
    }



    public void ChangeToManageVolunteersView(){
        ManageVolunteersController mvc = new ManageVolunteersController(stage, model);

        Scene scene = new Scene(mvc.GetView().GetRootPane(), 800, 600);
//        scene.getStylesheets().add
//                (Volunteerize.class.getResource("LoginStyle.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public void ChangeToManageEventsView(){
        ManageEventController mvc = new ManageEventController(stage, model);

        Scene scene = new Scene(mvc.GetView().GetRootPane(), 800, 600);
        //scene.getStylesheets().add(Volunteerize.class.getResource("LoginStyle.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }


    public void ChangeToChangePasswordView(){
        //TODO
    }

    public void ChangeToEditProfileView(){
        SignUpController editlc = new SignUpController(stage, model, model.getProfile());
        Scene scene = new Scene(editlc.GetView().GetRootPane(), 720, 540);
        stage.setScene(scene);
        stage.show();
    }

    public void ChangeToBrowseEventsView(){
        EventController ec = new EventController(stage, model);
        Scene scene = new Scene(ec.GetView().GetRootPane(), 600, 600);
        stage.setScene(scene);
        stage.show();
    }

    public void ChangeToProfileView(){
        VolunteerProfileController vlc = new VolunteerProfileController(stage, model);
        Scene scene = new Scene(vlc.GetView().GetRootPane(), 600, 600);
        stage.setScene(scene);
        stage.show();
    }



}
