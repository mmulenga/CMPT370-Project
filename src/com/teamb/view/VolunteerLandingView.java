package com.teamb.view;

import com.teamb.controller.VolunteerLandingController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


/* CODE SMELLS
    Very similar to StaffLandingView
    Copied due to time constraints
 */

/**
 * Created by Sarah on 2017-11-19.
 */
public class VolunteerLandingView extends BasicView {

    VolunteerLandingController controller;

    public Button epButton;
    public Button ueButton;
    public Button cpassButton;
    public Button helpButton;
    public Button pButton;

    public VolunteerLandingView(VolunteerLandingController c){
        super(c);
        controller = c;
    }

    /**
     * Returns the root pane.
     *
     * @return
     */
    @Override
    public Pane GetRootPane() {
        return root;
    }

    /**
     * Creates the interface containers and elements, and adds them to the root pane.
     */
    @Override
    protected void CreateChildren() {

        Label welcome = new Label("Welcome!" /* TODO get name only */);
        Label prompt = new Label("What would you like to do?");
        epButton = new Button("Edit Profile");

        ueButton = new Button("See upcoming events");

        cpassButton = new Button("Change Password");

        helpButton = new Button ("Help");

        pButton = new Button("Look at my profile");


        VBox mainContainer = new VBox();
        mainContainer.setAlignment(Pos.CENTER);


        mainContainer.getChildren().addAll(welcome, prompt, pButton, epButton, ueButton, cpassButton, helpButton);
        root.getChildren().add(mainContainer);

    }
}
