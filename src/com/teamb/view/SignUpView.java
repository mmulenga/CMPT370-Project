package com.teamb.view;

import com.teamb.controller.BasicController;
import com.teamb.controller.SignUpController;
import com.teamb.model.Availability;
import com.teamb.model.Profile;
import com.teamb.model.Shift;
import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class SignUpView extends BasicView {

    public Button submit;
    public Button clear;
    public Availability a;
    public TableView<Shift> availabilityTable;
    public TextField firstNameField;
    public TextField lastNameField;
    public TextField passwordField;
    public TextField addressField;
    public TextField phoneNumberField;
    public TextField emergencyNumberField;
    public TextField emergencyNameField;
    public TextField emailField;
    public TextField memberIDField;
    public TextArea medicalInformationField;
    public RadioButton phoneYes;
    public RadioButton emailYes;
    public RadioButton checked;




    public SignUpView(BasicController c){
        super(c);

    }

    @Override
    public Pane GetRootPane() {
        return root;
    }

    @Override
    protected void CreateChildren() {
        GridPane gp = new GridPane();
        gp.setAlignment(Pos.CENTER);
        gp.setPadding(new Insets(30,30,30,30));
        gp.setHgap(10);
        gp.setVgap(10);

        // columnOneConstraints will be applied to all the nodes placed in column one.
        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 180, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.LEFT);

        // columnTwoConstraints will be applied to all the nodes placed in column two.
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(100,170, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        ColumnConstraints columnThreeConstrains = new ColumnConstraints(100,170, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gp.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains, columnThreeConstrains);

        //Add Header
        Label header = new Label("Sign Up Form");
        header.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gp.add(header, 0,0,3,1);
        gp.setHalignment(header, HPos.CENTER);
        gp.setMargin(header, new Insets(20,0,20,0));

        //Create Labels
        Label firstNameLabel = new Label("First Name:");
        Label lastNameLabel = new Label("Last Name:");
        Label passwordLabel = new Label("Password:");
        Label addressLabel = new Label("Home Address:");
        Label phoneNumberLabel = new Label("Phone Number:");
        Label emergencyContact = new Label("Emergency Contact Information:");
        Label emergencyNumberLabel = new Label("Emergency Contact Number:");
        Label emergencyNameLabel = new Label("Emergency Contact Name:");
        Label emailLabel = new Label("Email:");
        Label memberIDLabel = new Label("Membership Number:");
        Label medicalInformationLabel = new Label("Medical Information:");
        Label contactPreference = new Label("Contact Preference:");
        Label volunteerGroup = new Label("Volunteer Group:");
        Label criminalRecordCheck = new Label("Criminal Record Checked?");
        Label availabilityLabel = new Label("Availability:");
        Label registeredEventsLabel = new Label("Registered Events:");
        Label phonePref = new Label("Prefer phone contact?");
        Label emailPref = new Label("Prefer email contact?");


        //Create textFields
        firstNameField = new TextField();
        lastNameField  = new TextField();
        passwordField = new TextField();
        addressField  = new TextField();
        phoneNumberField = new TextField();
        emergencyNumberField  = new TextField();
        emergencyNameField  = new TextField();
        emailField  = new TextField();
        memberIDField  = new TextField();
        medicalInformationField = new TextArea();

        //Create Radio Buttons
        final ToggleGroup phonePrefer = new ToggleGroup();
        phoneYes = new RadioButton("Yes");
        RadioButton phoneNo = new RadioButton("No");
        phoneYes.setToggleGroup(phonePrefer);
        phoneNo.setToggleGroup(phonePrefer);

        final ToggleGroup emailPrefer = new ToggleGroup();
        emailYes = new RadioButton("Yes");
        RadioButton emailNo = new RadioButton("No");
        emailYes.setToggleGroup(emailPrefer);
        emailNo.setToggleGroup(emailPrefer);

        final ToggleGroup criminalCheckGroup = new ToggleGroup();
        checked = new RadioButton("Yes");
        RadioButton uncheck = new RadioButton("No");
        checked.setToggleGroup(criminalCheckGroup);
        uncheck.setToggleGroup(criminalCheckGroup);

        //set select default
        phoneYes.setSelected(true);
        emailNo.setSelected(true);
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


        /************Create Availability Table************/
        TableView<Shift> availabilityTable = new TableView<>();
        Availability a = new Availability();
        availabilityTable = a.getAvailabilityTable(true);


        //Create Buttons
         submit = new Button("Submit");
         clear = new Button("Clear");



        TableView<Shift> finalAvailabilityTable = availabilityTable;




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

        gp.add(availabilityLabel,0,17);
        gp.add(availabilityTable,0,18,3,1);

        gp.add(submit,1,20);
        gp.add(clear,2,20);

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
//                for (Shift shift: availabilityTable.getItems()
//                     ) {
//                    shift.reset();
//                }
            }
        });

        //Add Scroll Bar

        ScrollPane sp = new ScrollPane();
        sp.setContent(gp);

        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sp.setPrefSize(600,600);


        root.getChildren().add(sp);
    }
    private <S,T> TableColumn<S,T> createColumn(String title, String propertyName) {
        TableColumn<S,T> col = new TableColumn<>(title);
        col.setCellValueFactory(new PropertyValueFactory<>(propertyName));
        return col;
    }


}

