package com.teamb.controller;

import com.teamb.model.Availability;
import com.teamb.model.Profile;
import com.teamb.model.Shift;
import com.teamb.view.BasicView;
import com.teamb.view.SignUpView;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.util.Objects;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import sun.security.x509.AVA;

import java.util.Objects;
import com.teamb.model.VolunteerizeModel;

import javax.swing.*;

public class SignUpController extends BasicController{

    SignUpView view;
    Profile profile;
    VolunteerizeModel model;

    public SignUpController(Stage s){
        super(s);
        view = new SignUpView();
        view.submit.setOnAction(new submitEventHandler());
        view.clear.setOnAction(new clearEventHandler());
    }
    @Override
    public BasicView GetView() {
        return view;
    }

    class submitEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            createNewProfile();
            // ((SignUpController) controller).actionPerformed();
            completePopUP();
        }
    }

    class clearEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            view.firstNameField.clear();
            view.lastNameField.clear();
            view.passwordField.clear();
            view.addressField.clear();
            view.phoneNumberField.clear();
            view.emergencyNumberField.clear();
            view.emergencyNameField.clear();
            view.emailField.clear();
            view.memberIDField.clear();
            view.medicalInformationField.clear();
            view.phoneYes.setSelected(true);
            view.emailYes.setSelected(true);
            view.checked.setSelected(true);
//                for (Shift shift: availabilityTable.getItems()
//                     ) {
//                    shift.reset();
//                }
        }

    }






    /*public void actionPerformed() {
        for (Shift shift: view.availabilityTable.getItems()) {
            for(int i=0;i<7;i++){
                if(shift.getWeekdayAvailability(i)){
                    if(Objects.equals(shift.getShift(), "Morning")){
                        view.a.ChangeAvailability(i, 0, true);
                        System.out.println("Day " + i + " morning is available");
                    } else if (Objects.equals(shift.getShift(), "Afternoon")) {
                        view.a.ChangeAvailability(i, 1, true);
                        System.out.println("Day " + i + " afternoon is available");
                    } else {
                        view.a.ChangeAvailability(i, 2, true);
                        System.out.println("Day " + i + " evening is available");
                    }
                }
            }
        }
        System.out.print(view.a);
        System.out.println(profile.getFirstName());
        System.out.println(profile.getLastName());
        System.out.println(profile.getAddress());
        System.out.println(((RadioButton)(view.emailYes.getToggleGroup().getSelectedToggle())).getText());
        System.out.println(((RadioButton)(view.phoneYes.getToggleGroup().getSelectedToggle())).getText());


    }*/

    /**
     * method that converts radio buttons string value
     * to a boolean value
     * @param value
     * @return
     */
    public boolean convertStringToBoolean(String value){
        if(value.equals("Yes")){ return true;}
        else
            return false;
    }


    /**
     * Method that takes information from View and creates a new profile
     * with the information gotten from textfields and radio
     * buttons.
     */
    public void createNewProfile(){
        profile = new Profile();
        model = new VolunteerizeModel();
        profile.setFirstName(view.firstNameField.getText());
        profile.setLastName(view.lastNameField.getText());
        profile.setMiddleName("Strawberry"); //Temporary
        profile.setAddress(view.addressField.getText());
        profile.setPhoneNumber(view.phoneNumberField.getText());
        profile.setEmail(view.emailField.getText());
        profile.setcontactByEmail (convertStringToBoolean(
        (((RadioButton)(view.emailYes.getToggleGroup().getSelectedToggle())).getText())));
       profile.setCriminalReccordCheck(convertStringToBoolean(
               (((RadioButton)(view.checked.getToggleGroup().getSelectedToggle())).getText())));
        profile.setEmergencyContactFirstName(view.emergencyNameField.getText());
       profile.setEmergencyContactMiddleName("Jack"); //Temporary
        profile.setEmergencyContactLastName("Jonees"); // Temporary
        profile.setEmergencyContactPhoneNumber(view.emergencyNumberField.getText());
      // profile.setEmergencyContactID();
       profile.setEmergencyContactPostalCode("S4S 4R5");//Temporary
        profile.setEmergencyContactAddress("167 SUNDRIVRE AVENUE");//Temporary
        profile.setMedicalInformation("ASTHMA");//Temporary
        profile.setHoursWorked(92);//Temporary
        //profile.setAvailability();
        //profile.setPhotoPath();
         model.addProfile(profile);
    }


    /**
     * Pop up box to alert user of newly created Profile
     * and a button that goes to the new user's profile
     * landing page.
     */
    public void completePopUP(){
        Stage popupwindow=new Stage();

        popupwindow.initModality(Modality.APPLICATION_MODAL);
        popupwindow.setTitle("Volunteerize");


        Label completeInformationLabel= new Label(profile.getFirstName() + "'s Profile Information Now Complete");
        Button profileButton= new Button("Go to " + profile.getFirstName() + "'s profile");
        profileButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                popupwindow.close();
                ChangeToProfileView(stage);

            }
        });

        VBox layout= new VBox(10);
        layout.getChildren().addAll(completeInformationLabel, profileButton);
        layout.setAlignment(Pos.CENTER);
        Scene scene1= new Scene(layout, 300, 250);
        popupwindow.setScene(scene1);
        popupwindow.showAndWait();

    }


    public void ChangeToProfileView(Stage s){
        VolunteerLandingController vlc = new VolunteerLandingController(s);

        Scene scene = new Scene(vlc.GetView().GetRootPane(), 720, 540);
        s.setScene(scene);
        s.show();

    }





}
