package com.teamb.controller;

import com.teamb.model.Profile;
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

    public SignUpController(Stage s, VolunteerizeModel m){
        super(s, m);
        view = new SignUpView();
        view.submit.setOnAction(new submitEventHandler());
        view.clear.setOnAction(new clearEventHandler());
        view.backButton.setOnAction(new backButtonEventHandler());
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
            //view.passwordField.clear();
            view.addressField.clear();
            view.phoneNumberField.clear();
            view.emergencyNumberField.clear();
            view.emergencyFirstNameField.clear();
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

    class backButtonEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            ChangeToProfileView(stage);
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
    public void createNewProfile() {
        Profile newProfile = new Profile();

        newProfile.setFirstName(view.firstNameField.getText());
        newProfile.setMiddleName(view.middleNameField.getText()); // TODO: Add field to signup page
        newProfile.setLastName(view.lastNameField.getText());
        newProfile.setAddress(view.addressField.getText());
        newProfile.setPhoneNumber(view.phoneNumberField.getText());
        newProfile.setEmail(view.emailField.getText());
        newProfile.setcontactByEmail (convertStringToBoolean(
        (((RadioButton)(view.emailYes.getToggleGroup().getSelectedToggle())).getText())));
        newProfile.setCriminalReccordCheck(convertStringToBoolean(
               (((RadioButton)(view.checked.getToggleGroup().getSelectedToggle())).getText())));
        newProfile.setEmergencyContactFirstName(view.emergencyFirstNameField.getText());
        newProfile.setEmergencyContactMiddleName(view.emergencyMiddleNameField.getText()); // TODO: Add field to signup page
        newProfile.setEmergencyContactLastName(view.emergencyLastNameField.getText()); // TODO: Add field to signup page
        newProfile.setEmergencyContactPhoneNumber(view.emergencyNumberField.getText());
        newProfile.setEmergencyContactPostalCode(view.emergencyPostalCodeField.getText()); // TODO: Add field to signup page
        newProfile.setEmergencyContactAddress(view.emergencyAddressField.getText()); // TODO: Add field to signup page
        newProfile.setMedicalInformation(view.medicalInformationField.getText()); // TODO: Add field to signup page
        newProfile.setHoursWorked(view.workingHours.getValue()); // TODO: Add field to signup page
        System.out.print(view.workingHours.getValue());
        newProfile.setAvailability(view.availability); // TODO: Add field to signup page
        //newProfile.setPhotoPath(); // TODO: Add field to signup page

        model.addProfile(newProfile);
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


        Label completeInformationLabel= new Label(model.getProfile().getFirstName() + "'s Profile Information Now Complete");
        Button profileButton= new Button("Go to " + model.getProfile().getFirstName() + "'s profile");
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
        VolunteerLandingController vlc = new VolunteerLandingController(s, model);

        Scene scene = new Scene(vlc.GetView().GetRootPane(), 720, 540);
        s.setScene(scene);
        s.show();

    }





}
