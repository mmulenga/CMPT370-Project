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

    public SignUpController(Stage s, VolunteerizeModel m, Profile profile){
        super(s, m);
        view = new SignUpView();
        view.submit.setOnAction(new submitEventHandler());
        view.clear.setOnAction(new clearEventHandler());
        view.backButton.setOnAction(new backButtonEventHandler());
        editProfile(profile);
    }


    @Override
    public SignUpView GetView() {
        return view;
    }

    class submitEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {

            /*editing a profile*/
            if (view.header.getText().equals("Edit Profile")) {
                if(null == getProfileFromView()) return;
                model.editProfile(getProfileFromView());
            }
            /*creating a new profile*/
            else{
                createNewProfile();
            }
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
            for(int day = 0; day < 7; day++) {
                for(int shift = 0; shift < 3; shift++) {
                    view.shiftCheckbox[day][shift].setSelected(false);
                }
            }
        }

    }

    class backButtonEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            if(model.getProfile().getLastName()!=null) {
                ChangeToProfileView();
            }else if(!model.getUser().getIsStaff()){
                ChangeToLoginView();
            }else{
                ChangeToManageVolunteersView();
            }
        }
    }


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
     * @param editProfile
     *
     */
    public void editProfile(Profile editProfile) {
        view.header.setText("Edit Profile");
        view.memberIDField.setEditable(false);
        view.memberIDField.setText(Integer.toString(editProfile.getMemberID()));
        view.firstNameField.setText(editProfile.getFirstName());
        view.middleNameField.setText(editProfile.getMiddleName());
        view.lastNameField.setText(editProfile.getLastName());
        view.addressField.setText(editProfile.getAddress());
        view.phoneNumberField.setText(editProfile.getPhoneNumber());
        view.emailField.setText(editProfile.getEmail());
        view.emailYes.setSelected(editProfile.getContactByEmail());
        view.phoneYes.setSelected(editProfile.getContactByPhone());
        view.checked.setSelected(editProfile.getCriminalRecordCheck());
        view.emergencyFirstNameField.setText(editProfile.getEmergencyContactFirst());
        view.emergencyMiddleNameField.setText(editProfile.getEmergencyContactMiddle()); // TODO: Add field to signup page
        view.emergencyLastNameField.setText(editProfile.getEmergencyContactLast()); // TODO: Add field to signup page
        view.emergencyNumberField.setText(editProfile.getEmergencyContactPhoneNumber());
        view.emergencyPostalCodeField.setText(editProfile.getEmergencyContactPostalCode()); // TODO: Add field to signup page
        view.emergencyAddressField.setText(editProfile.getEmergencyContactAddress()); // TODO: Add field to signup page
        view.medicalInformationField.setText(editProfile.getMedicalInformation()); // TODO: Add field to signup page
        view.workingHours.getValueFactory().setValue(editProfile.getHoursWorked()); // TODO: Add field to signup page
        System.out.print(view.workingHours.getValue());

        for(int day = 0; day < 7; day++) {
            for(int shift = 0; shift < 3; shift++) {
                view.shiftCheckbox[day][shift].setSelected( editProfile.getAvailability().GetAvailablity(day,shift));
            }
        }


        //  view.availability.; // TODO: Add field to signup page
        //newProfile.setPhotoPath(); // TODO: Add field to signup page
        //createNewProfile1(editProfile);
    }


    /**
     * Method returns a profile with fields set to values of components in
     * the view input by the user
     * @return profile with values from view, or null if required fields not filled
     *
     */
    public Profile getProfileFromView() {
        Profile profile = new Profile();


        /*check if required fields are not empty*/
        if(view.firstNameField.getText().isEmpty()) return null;
        if(view.middleNameField.getText().isEmpty()) return null;
        if(view.lastNameField.getText().isEmpty()) return null;
        if(view.addressField.getText().isEmpty()) return null;
        if(view.phoneNumberField.getText().isEmpty()) return null;
        if(view.emailField.getText().isEmpty()) return null;
        if(view.emergencyFirstNameField.getText().isEmpty()) return null;
        if(view.emergencyMiddleNameField.getText().isEmpty()) return null;
        if(view.emergencyLastNameField.getText().isEmpty()) return null;
        if(view.emergencyNumberField.getText().isEmpty()) return null;
        if(view.emergencyPostalCodeField.getText().isEmpty()) return null;
        if(view.emergencyAddressField.getText().isEmpty()) return null;
        if(view.medicalInformationField.getText().isEmpty()) return null;







        for(int day = 0; day < 7; day++) {
            for(int shift = 0; shift < 3; shift++) {
                view.availability.ChangeAvailability(day,shift,view.shiftCheckbox[day][shift].isSelected());
            }
        }
        profile.setFirstName(view.firstNameField.getText());
        profile.setMiddleName(view.middleNameField.getText()); // TODO: Add field to signup page
        profile.setLastName(view.lastNameField.getText());
        profile.setAddress(view.addressField.getText());
        profile.setPhoneNumber(view.phoneNumberField.getText());
        profile.setEmail(view.emailField.getText());
        profile.setcontactByEmail (convertStringToBoolean(
                (((RadioButton)(view.emailYes.getToggleGroup().getSelectedToggle())).getText())));
        profile.setCriminalReccordCheck(convertStringToBoolean(
                (((RadioButton)(view.checked.getToggleGroup().getSelectedToggle())).getText())));
        profile.setEmergencyContactFirstName(view.emergencyFirstNameField.getText());
        profile.setEmergencyContactMiddleName(view.emergencyMiddleNameField.getText()); // TODO: Add field to signup page
        profile.setEmergencyContactLastName(view.emergencyLastNameField.getText()); // TODO: Add field to signup page
        profile.setEmergencyContactPhoneNumber(view.emergencyNumberField.getText());
        profile.setEmergencyContactPostalCode(view.emergencyPostalCodeField.getText()); // TODO: Add field to signup page
        profile.setEmergencyContactAddress(view.emergencyAddressField.getText()); // TODO: Add field to signup page
        profile.setMedicalInformation(view.medicalInformationField.getText()); // TODO: Add field to signup page
        profile.setHoursWorked(view.workingHours.getValue()); // TODO: Add field to signup page
        System.out.print(view.workingHours.getValue());
        profile.setAvailability(view.availability); // TODO: Add field to signup page
        //profile.setPhotoPath(); // TODO: Add field to signup page
        return profile;
    }


    public void createNewProfile() {
        System.out.print(view.availability);
        // If the profile stored within the model doesn't exist we know that
        // the volunteer is signing up on their own, so we update the model
        // profile to the newly created one.
        if(model.getProfile().getFirstName() == null) {
            if(null == getProfileFromView()) return;
            model.setProfile(getProfileFromView());
        }

        // Add the profile to the database
        if(null == getProfileFromView()) return;
        model.addProfile(getProfileFromView());
        completePopUP();
    }


    /**
     * Pop up box to alert user of newly created Profile
     * and a button that goes to the new user's profile
     * landing page.
     */
    public void completePopUP(){
        Stage popupwindow = new Stage();

        popupwindow.initModality(Modality.APPLICATION_MODAL);
        popupwindow.setTitle("Volunteerize");


        Label completeInformationLabel = new Label(getProfileFromView().getFirstName() + "'s Profile Information Now Complete");
        Button profileButton = new Button("Go to " + getProfileFromView().getFirstName() + "'s profile");
        profileButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                popupwindow.close();

                ChangeToProfileView();
            }
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(completeInformationLabel, profileButton);
        layout.setAlignment(Pos.CENTER);
        Scene scene1 = new Scene(layout, 300, 250);
        popupwindow.setScene(scene1);
        popupwindow.showAndWait();

    }


}
