package com.teamb.view;

import com.teamb.controller.VolunteerEventProfileController;
import com.teamb.model.Event;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * Created by David on 2017-11-20
 */

public class VolunteerEventProfileView extends BasicView{
    private VolunteerEventProfileController controller;
    private Event event;

    /**
     * Constructs the StaffEventProfile page.
     */
    public VolunteerEventProfileView(VolunteerEventProfileController c, Event e){
        super(c);
        controller = c;
        root = new Pane();
        CreateChildren();
        event = e;
    }

    @Override
    protected void CreateChildren() {
        VBox v = new VBox(20);
        HBox buttonBox = new HBox();

        //when this button is pressed view changes to event sign up page
        Button addButton = new Button("Sign Up For Event");
        controller.AddToEvent(/*searchResultView*/);



        /**
         * Labels for Staff Event Profile view
         */
        Label eventName = new Label(event.name);
        Label date = new Label(event.date);
        Label location = new Label(event.endTime); /**Change to Location */
        Label detail = new Label("Details");
        Label description = new Label (event.description);
        Label messageBoard = new Label("Message Board");


        buttonBox.getChildren().add(addButton);
        v.getChildren().addAll(eventName,date, location, detail, description, messageBoard,
                buttonBox);

        root.getChildren().add(v);
    }

   // Scene scene = new Scene (root, 600, 600);

    @Override
    public Pane GetRootPane() {
        return root;
    }
}
