package com.teamb.view;

import com.teamb.model.Event;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.sql.Timestamp;


public class EventProfileView extends BasicView {
    public Button backButton;
    public Button signUp;
    protected GridPane gp;

    @Override
    public Pane GetRootPane() {
        return root;
    }

    @Override
    protected void CreateChildren() {
        gp = new GridPane();
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
        columnThreeConstrains.setHalignment(HPos.RIGHT);

        gp.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains, columnThreeConstrains);

        //initialize Button
        signUp = new Button("Sign Up For This Event!");
        backButton = new Button("Back");



        //Create Labels
        Label startDateLabel = new Label("Start Date : ");
        Label endDateLabel = new Label("End Date : ");
        Label startTimeLabel = new Label("Start Time : ");
        Label endTimeLabel = new Label("End Time : ");
       // Label eventTitleLabel = new Label("Event Title : ");
        Label locationLabel = new Label("Location : ");
        Label description = new Label("Description : ");

       // gp.add(eventTitleLabel,0,1);

        gp.add(locationLabel,0,2);

        gp.add(startTimeLabel,0,3);

        gp.add(endTimeLabel,0,4);

        gp.add(startDateLabel,0,5);

        gp.add(endDateLabel,0,6);

        gp.add(description,0,7);

        gp.add(backButton,0,9);
        gp.add(signUp,2,9,2,1);


//
//        //Add Scroll Bar
//
//        ScrollPane sp = new ScrollPane();
//        sp.setContent(gp);
//
//        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
//        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
//        sp.setPrefSize(600,600);

        root.getChildren().add(gp);
    }

    public void loadEventProfile(Event e){
        Label eventTitle = new Label(e.getEventName());
        Label location = new Label(e.getLocation());
        Label start = new Label(e.getStartDate());
        Label starttime = new Label(String.valueOf(e.getStartTime()));
        Label end = new Label(e.getEndDate());
        Label endtime = new Label(String.valueOf(e.getEndTime()));
        Text description = new Text(e.getDescription());
        description.setWrappingWidth(250);
        //Add Header

        eventTitle.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gp.add(eventTitle, 0,0,3,1);
        gp.setHalignment(eventTitle, HPos.CENTER);
        gp.setMargin(eventTitle, new Insets(20,0,20,0));

        gp.add(location,1,2,2,1);
        gp.add(start,1,5);
        gp.add(starttime,1, 3);
        gp.add(end,1,6);
        gp.add(endtime,1,4);

        gp.add(description,1,7,2,1);
    }
}
