package com.teamb.view;

import com.teamb.controller.StaffLandingController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * Created by Sarah on 2017-11-19.
 */
public class StaffLandingView extends BasicView {

    public StaffLandingController controller;

    public StaffLandingView(StaffLandingController c){
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

    @Override
    protected void CreateChildren() {
        Label welcome = new Label("Welcome!");
        Label prompt = new Label("What would you like to do?");
        Button mvButton = new Button("Manage Volunteers");
        mvButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controller.ChangeToManageVolunteersView();
            }
        });
        Button meButton = new Button("Manage Events");
        meButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controller.ChangeToManageEventsView();
            }
        });
        Button cpassButton = new Button("Change Password");
        cpassButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controller.ChangeToChangePasswordView();
            }
        });
        Button helpButton = new Button ("Help");
        helpButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controller.HelpPopUp();
            }
        });

        VBox mainContainer = new VBox();

        mainContainer.getChildren().addAll(welcome, prompt, mvButton, meButton, cpassButton, helpButton);
        root.getChildren().add(mainContainer);

    }
}
