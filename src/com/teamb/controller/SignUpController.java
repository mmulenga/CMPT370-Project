package com.teamb.controller;

import com.teamb.model.Profile;
import com.teamb.model.Shift;
import com.teamb.model.Users;
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

    private Profile newProfile;
    private Profile editProfile;
    private Users newUser;
    private Users editUser;

    public SignUpController(Stage s, VolunteerizeModel m){
        super(s, m);
        view = new SignUpView();
        view.submit.setOnAction(new submitEventHandler());
        view.clear.setOnAction(new clearEventHandler());
        view.backButton.setOnAction(new backButtonEventHandler());
    }

    public SignUpController(Stage s, VolunteerizeModel m, Profile profile, Users user){
        super(s, m);
        view = new SignUpView();
        editProfile = profile;
        editUser = user;
        view.submit.setOnAction(new submitEventHandler());
        view.clear.setOnAction(new clearEventHandler());
        view.backButton.setOnAction(new backButtonEventHandler());
        editProfile();
    }


    @Override
    public SignUpView GetView() {
        return view;
    }

    class submitEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            for (Shift shift: view.availabilityTable.getItems()) {
                for (int i = 0; i < 7; i++) {
                    if (shift.getWeekdayAvailability(i)) {
                        if (Objects.equals(shift.getShift(), "Morning")) {
                            view.availability.ChangeAvailability(i, 0, true);
                            System.out.println("Day " + i + " morning is available");
                        } else if (Objects.equals(shift.getShift(), "Afternoon")) {
                            view.availability.ChangeAvailability(i, 1, true);
                            System.out.println("Day " + i + " afternoon is available");
                        } else {
                            view.availability.ChangeAvailability(i, 2, true);
                            System.out.println("Day " + i + " evening is available");
                        }
                    }
                }
            }
            if (view.header.getText().equals("Edit Profile")) {
                setProfileValues(editProfile, editUser);
                model.editProfile(editProfile);
            }
            else{
            createNewProfile();
            // ((SignUpController) controller).actionPerformed();
            completePopUP();
            }
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
            view.emergencyFirstNameField.clear();
            view.emailField.clear();
            view.memberIDField.clear();
            view.medicalInformationField.clear();
            view.phoneYes.setSelected(true);
            view.emailYes.setSelected(true);
            view.checked.setSelected(true);
//            for (Shift shift: availabilityTable.getItems()) {
//                shift.reset();
//            }
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
    public void editProfile() {
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
        view.emergencyMiddleNameField.setText(editProfile.getEmergencyContactMiddle());
        view.emergencyLastNameField.setText(editProfile.getEmergencyContactLast());
        view.emergencyNumberField.setText(editProfile.getEmergencyContactPhoneNumber());
        view.emergencyPostalCodeField.setText(editProfile.getEmergencyContactPostalCode());
        view.emergencyAddressField.setText(editProfile.getEmergencyContactAddress());
        view.medicalInformationField.setText(editProfile.getMedicalInformation());
        view.workingHours.getValueFactory().setValue(editProfile.getHoursWorked());
        System.out.print(view.workingHours.getValue());
      //  view.availability.;
        //newProfile.setPhotoPath();
        //createNewProfile1(editProfile);
    }


    public void setProfileValues(Profile profile, Users user) {
        user.setUsername(view.memberIDField.getText());
        user.setPassword(view.passwordField.getText());
        user.setIsStaff(false);
        user.setProfileID(Integer.parseInt(user.getUsername()));

        profile.setMemberID(Integer.parseInt(view.memberIDField.getText()));
        profile.setFirstName(view.firstNameField.getText());
        profile.setMiddleName(view.middleNameField.getText());
        profile.setLastName(view.lastNameField.getText());
        profile.setAddress(view.addressField.getText());
        profile.setPhoneNumber(view.phoneNumberField.getText());
        profile.setEmail(view.emailField.getText());
        profile.setcontactByEmail (convertStringToBoolean(
                (((RadioButton)(view.emailYes.getToggleGroup().getSelectedToggle())).getText())));
        profile.setCriminalReccordCheck(convertStringToBoolean(
                (((RadioButton)(view.checked.getToggleGroup().getSelectedToggle())).getText())));
        profile.setEmergencyContactFirstName(view.emergencyFirstNameField.getText());
        profile.setEmergencyContactMiddleName(view.emergencyMiddleNameField.getText());
        profile.setEmergencyContactLastName(view.emergencyLastNameField.getText());
        profile.setEmergencyContactPhoneNumber(view.emergencyNumberField.getText());
        profile.setEmergencyContactPostalCode(view.emergencyPostalCodeField.getText());
        profile.setEmergencyContactAddress(view.emergencyAddressField.getText());
        profile.setMedicalInformation(view.medicalInformationField.getText());
        profile.setHoursWorked(view.workingHours.getValue());
        System.out.print(view.workingHours.getValue());
        profile.setAvailability(view.availability);
        //profile.setPhotoPath();
    }
    public void createNewProfile() {

        newProfile = new Profile();
        newUser = new Users();
        setProfileValues(newProfile, newUser);

        //System.out.print(view.availability);
        // If the profile stored within the model doesn't exist we know that
        // the volunteer is signing up on their own, so we update the model
        // profile to the newly created one.
        if(model.getProfile().getFirstName() == null) {
            model.setProfile(newProfile);
            model.setUser(newUser);
        }

        // Add the profile to the database
        model.addProfile(newProfile);
        model.addUser(newUser);
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


        Label completeInformationLabel = new Label(newProfile.getFirstName() + "'s Profile Information Now Complete");
        Button profileButton = new Button("Go to " + newProfile.getFirstName() + "'s profile");
        profileButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                popupwindow.close();

                ChangeToProfileView(stage);
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
