package com.teamb.view;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.teamb.controller.MainLandingController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Sarah on 2017-11-03.
 * This class creates the main landing page that is seen first when the program is started.
 *
 */
public class MainLandingView extends BasicView{

    private MainLandingController controller;

    /**
     * Constructs the MainLanding page.
     */
    public MainLandingView(MainLandingController c){
        super(c);
        controller = c;
    }

    @Override
    protected void CreateChildren() {
        VBox v = new VBox();
        HBox buttonBox = new HBox();

        Button vButton = new Button("Volunteer Login");
        vButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controller.ChangeToLoginView(event);
            }
        });
        //when this button is pressed view changes to volunteer login page
        //controller.ChangeView(/*volunteer*/);
        Button sButton = new Button("Staff Login");
        sButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controller.ChangeToLoginView(event);
            }
        });
        //when this button is pressed view changes to staff login page
        //controller.ChangeView(/*staff*/);
        Button help = new Button("Help");
        //when this button is pressed a help document pop up appears.
        Label label = new Label("Welcome to Volunteerize");


        buttonBox.getChildren().addAll(vButton, sButton);
        v.getChildren().addAll(label, buttonBox, help);

        root.getChildren().add(v);
    }

    @Override
    public Pane GetRootPane() {
        return root;
    }
}
