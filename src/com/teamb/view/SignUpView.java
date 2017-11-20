package com.teamb.view;

import com.teamb.controller.SignUpController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class SignUpView extends BasicView {
    SignUpController controller;
    public SignUpView(SignUpController c){
        super(c);
        controller = c;
    }

    @Override
    public Pane GetRootPane() {
        return root;
    }

    @Override
    protected void CreateChildren() {
        GridPane gp = new GridPane();
        gp.setAlignment(Pos.CENTER);
        gp.setPadding(new Insets(40,40,40,40));
        gp.setHgap(10);
        gp.setVgap(10);

        // columnOneConstraints will be applied to all the nodes placed in column one.
        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 200, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.LEFT);

        // columnTwoConstraints will be applied to all the nodes placed in column two.
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(100,150, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        ColumnConstraints columnThreeConstrains = new ColumnConstraints(100,150, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gp.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains, columnThreeConstrains);

        //Add Header
        Label header = new Label("Sign Up Form");
        header.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gp.add(header, 0,0,3,1);
        gp.setHalignment(header, HPos.CENTER);
        gp.setMargin(header, new Insets(20,0,20,0));

        //Create Labels
        Label firstNameLabel = new Label("First Name : ");
        Label lastNameLabel = new Label("Last Name : ");
        Label passwordLabel = new Label("Password : ");
        Label addressLabel = new Label("Home Address : ");
        Label phoneNumberLabel = new Label("Phone Number : ");
        Label emergencyContact = new Label("Emergency Contact Information : ");
        Label emergencyNumberLabel = new Label("Emergency Contact Number : ");
        Label emergencyNameLabel = new Label("Emergency Contact Name : ");
        Label emailLabel = new Label("Email : ");
        Label memberIDLabel = new Label("Membership Number : ");
        Label medicalInformationLabel = new Label("Medical Information : ");
        Label contactPreference = new Label("Contact Preference　：　");
        Label volunteerGroup = new Label("Volunteer Group　：　");
        Label criminalRecordCheck = new Label("Criminal Record Checked?　");
        Label AvailabilityLabel = new Label("Availability : ");
        Label registeredEventsLabel = new Label("Registered Events : ");
        Label phonePref = new Label("Prefer phone contact?");
        Label emailPref = new Label("Prefer email contact?");


        //Create textFields
        TextField firstNameField = new TextField();
        TextField lastNameField  = new TextField();
        TextField passwordField = new TextField();
        TextField addressField  = new TextField();
        TextField phoneNumberField = new TextField();
        TextField emergencyNumberField  = new TextField();
        TextField emergencyNameField  = new TextField();
        TextField emailField  = new TextField();
        TextField memberIDField  = new TextField();
        TextField medicalInformationField = new TextField();

        //Create Radio Buttons
        final ToggleGroup phonePrefer = new ToggleGroup();
        RadioButton phoneYes = new RadioButton("Yes");
        RadioButton phoneNo = new RadioButton("No");
        phoneYes.setToggleGroup(phonePrefer);
        phoneNo.setToggleGroup(phonePrefer);

        final ToggleGroup emailPrefer = new ToggleGroup();
        RadioButton emailYes = new RadioButton("Yes");
        RadioButton emailNo = new RadioButton("No");
        emailYes.setToggleGroup(emailPrefer);
        emailNo.setToggleGroup(emailPrefer);

        final ToggleGroup crimialCheckGroup = new ToggleGroup();
        RadioButton checked = new RadioButton("Yes");
        RadioButton uncheck = new RadioButton("No");
        checked.setToggleGroup(crimialCheckGroup);
        uncheck.setToggleGroup(crimialCheckGroup);

        //set select default
        phoneYes.setSelected(true);
        emailYes.setSelected(true);
        checked.setSelected(true);

        //Create Dorpdown box
        ObservableList<String> volGrouplist =
                FXCollections.observableArrayList(
                        "Group1",
                        "Group2",
                        "Group3",
                        "Group4"
                );
        final ComboBox volGroupBox = new ComboBox(volGrouplist);


        //Create Buttons
        Button submit = new Button("Submit");
        Button clear = new Button("Clear");

        //Add widgets onto gridPane
        gp.add(memberIDLabel,0,1);
        gp.add(memberIDField,1,1,2,1);


        gp.add(passwordLabel, 0,2);
        gp.add(passwordField,1,2,2,1);

        gp.add(firstNameLabel, 0,3);
        gp.add(firstNameField, 1,3,2,1);

        gp.add(lastNameLabel, 0,4);
        gp.add(lastNameField, 1,4,2,1);

        gp.add(addressLabel,0,5);
        gp.add(addressField,1,5,2,1);

        gp.add(phoneNumberLabel,0,6);
        gp.add(phoneNumberField,1,6,2,1);

        gp.add(emailLabel,0,7);
        gp.add(emailField,1,7,2,1);

        gp.add(contactPreference,0,8);

        gp.add(phonePref,0,9);
        gp.add(phoneYes, 1,9);
        gp.add(phoneNo,2,9);

        gp.add(emailPref,0,10);
        gp.add(emailYes, 1,10);
        gp.add(emailNo,2,10);

        gp.add(criminalRecordCheck,0,11);
        gp.add(checked, 1,11);
        gp.add(uncheck,2,11);

        gp.add(volunteerGroup,0,12);
        gp.add(volGroupBox,1,12);

        gp.add(medicalInformationLabel,0,13);
        medicalInformationField.setMinHeight(50);
        gp.add(medicalInformationField,1,13,2,1);

        gp.add(emergencyContact,0,14);

        gp.add(emergencyNameLabel,0,15);
        gp.add(emergencyNameField,1,15,2,1);

        gp.add(emergencyNumberLabel,0,16);
        gp.add(emergencyNumberField,1,16,2,1);


        gp.add(submit,1,18);
        gp.add(clear,2,18);

        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                firstNameField.clear();
                lastNameField.clear();
                passwordField.clear();
                addressField.clear();
                phoneNumberField.clear();
                emergencyNumberField.clear();
                emergencyNameField.clear();
                emailField.clear();
                memberIDField.clear();
                medicalInformationField.clear();
                phoneYes.setSelected(true);
                emailYes.setSelected(true);
                checked.setSelected(true);
            }
        });

        //Add Scroll Bar
//        ScrollBar scb = new ScrollBar();
//        scb.setLayoutX(600-scb.getWidth());
//        scb.setMin(0);
//        scb.setOrientation(Orientation.VERTICAL);
//        scb.setPrefHeight(700);
//        scb.setMax(1500);
//
//        gp.add(scb,3,0);

        root.getChildren().add(gp);
    }


}
