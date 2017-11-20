package com.teamb.view;


import com.sun.org.apache.bcel.internal.generic.NEW;
import com.teamb.controller.MainLandingController;
import com.teamb.controller.StaffEventProfileController;
import com.teamb.model.Event;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by David on 2017-11-20
 */

public class StaffEventProfileView {
    private StaffEventProfileController controller;
    protected Event event;
    protected Pane root;

    /**
     * Constructs the StaffEventProfile page.
     */
    public StaffEventProfileView(StaffEventProfileController c, Event e){
        //super(c);
        controller = c;
        root = new Pane();
        this.CreateChildren();
        event = e;
    }

    //@Override
    protected void CreateChildren() {
        VBox v = new VBox(20);
        HBox buttonBox = new HBox();

        //when this button is pressed view changes to search result page
        Button addButton = new Button("Add Volunteers");
        addButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                controller.ChangeToSearchReturnView(/*searchResultView*/);
            }
        });

        //when this button is pressed view changes to search result page
        Button editButton = new Button("Edit Event");
        editButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                controller.ChangeToEditEventView(/*editEventView*/);
            }
        });


        // Labels for Staff Event Profile view

        Label eventName = new Label(event.name);
        Label date = new Label(event.date);
        Label location = new Label(event.endTime); /**Change to Location */
        Label detail = new Label("Details");
        Label description = new Label (event.description);
        Label messageBoard = new Label("Message Board");


        buttonBox.getChildren().addAll(addButton, editButton);
        v.getChildren().addAll(eventName,date, location, detail, description, messageBoard,
                buttonBox);

        root.getChildren().add(v);
    }

   // Scene scene = new Scene (root, 600, 600);

    //@Override
    public Pane GetRootPane() {
        return root;
    }
}
