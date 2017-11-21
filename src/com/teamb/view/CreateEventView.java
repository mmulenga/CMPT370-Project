package com.teamb.view;

import com.teamb.controller.BasicController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Locale;

public class CreateEventView extends BasicView {

    /**
     * Constructor.
     * Creates the root pane, and adds the children with the CreateChildren() method.
     * May have parameters based on what information is needed from the controller
     *
     * @param c
     */
    public CreateEventView(BasicController c) {
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
        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 200, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.LEFT);

        // columnTwoConstraints will be applied to all the nodes placed in column two.
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(100,150, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        ColumnConstraints columnThreeConstrains = new ColumnConstraints(100,150, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gp.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains, columnThreeConstrains);

        //Date
        DatePicker startDatePicker, endDatePicker;
        startDatePicker = new DatePicker();
        endDatePicker = new DatePicker();
        Locale.setDefault(Locale.CANADA);
        startDatePicker.setValue(LocalDate.now());
        endDatePicker.setValue(startDatePicker.getValue().plusDays(1));

        //Time


        //Add Header
        Label header = new Label("Create New Event");
        header.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gp.add(header, 0,0,3,1);
        gp.setHalignment(header, HPos.CENTER);
        gp.setMargin(header, new Insets(20,0,20,0));

        //Create Labels
        Label startDateLabel = new Label("Start Date : ");
        Label endDateLabel = new Label("End Date : ");
        Label startTimeLabel = new Label("Password : ");
        Label endTimeLabel = new Label("Password : ");
        Label eventTitleLabel = new Label("Event Title : ");
        Label locationLabel = new Label("Location : ");
        Label description = new Label("Description : ");

        //Create textFields
        TextField eventTitleField = new TextField();
        TextField locationField = new TextField();
        TextArea descriptionArea = new TextArea();

        //Create Dorpdown box
        ObservableList<String> startTimeList =
                FXCollections.observableArrayList(
                        "00:00","01:00","02:00","03:00","04:00","05:00","06:00","07:00","08:00","09:00",
                        "10:00","11:00","12:00","13:00", "14:00","15:00","16:00","17:00","18:00","19:00",
                        "20:00","21:00","22:00","23:00");
        final ComboBox startTimeBox = new ComboBox(startTimeList);
        ObservableList<String> endTimeList =
                FXCollections.observableArrayList(
                        "00:00","01:00","02:00","03:00","04:00","05:00","06:00","07:00","08:00","09:00",
                        "10:00","11:00","12:00","13:00", "14:00","15:00","16:00","17:00","18:00","19:00",
                        "20:00","21:00","22:00","23:00");
        final ComboBox endTimeBox = new ComboBox(endTimeList);

        gp.add(eventTitleLabel,0,1);
        gp.add(eventTitleField,1,1,2,1);

        gp.add(locationLabel,0,2);
        gp.add(locationField,1,2,2,1);

        gp.add(startDateLabel,0,3);
        gp.add(endDateLabel,1,3);

        gp.add(startDatePicker,0,4);
        gp.add(endDatePicker,1,4);


        gp.add(description,0,5);
        gp.add(descriptionArea,1,5,2,1);

        //How to convert localDate into Timestamp here.
        //System.out.println(Timestamp.valueOf(startDatePicker.getValue().atStartOfDay()));
        root.getChildren().add(gp);
    }
}
