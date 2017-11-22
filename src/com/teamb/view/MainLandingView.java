package com.teamb.view;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.teamb.controller.BasicController;
import com.teamb.controller.MainLandingController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import javax.swing.*;

/**
 * Created by Sarah on 2017-11-03.
 * This class creates the main landing page that is seen first when the program is started.
 *
 */
public class MainLandingView extends BasicView{

    //private MainLandingController controller;

    /**
     * Constructs the MainLanding page.
     */
    public MainLandingView(BasicController c){
        super(c);

    }

    @Override
    protected void CreateChildren() {
        BorderPane bp = new BorderPane();


        HBox buttonBox = new HBox();

        Button vButton = new Button("Volunteer Login");

        vButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {((MainLandingController)controller).ChangeToLoginView(event);
            }
        });
        //when this button is pressed view changes to volunteer login page
        //controller.ChangeView(/*volunteer*/);
        Button sButton = new Button("Staff Login");
        sButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ((MainLandingController)controller).ChangeToLoginView(event);
            }
        });
        //when this button is pressed view changes to staff login page
        //controller.ChangeView(/*staff*/);
        vButton.setPrefSize(200,100);
        sButton.setPrefSize(200,100);

        Button help = new Button("Help");
        //when this button is pressed a help document pop up appears.
        Label label = new Label("Welcome to Volunteerize");
        label.setFont(Font.font("Arial", FontWeight.BOLD, 40));

<<<<<<< HEAD

        //v.setPadding(new Insets(100));
=======
>>>>>>> 7c7f08fb22cae1bf3fc17961f0b355e400623ec7
        buttonBox.getChildren().addAll(vButton, sButton);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setMargin(vButton,new Insets(30));
        buttonBox.setMargin(sButton,new Insets(30));

        bp.setTop(label);
        bp.setCenter(buttonBox);
        bp.setBottom(help);
        bp.setAlignment(bp.getTop(),Pos.CENTER);
        bp.setAlignment(bp.getCenter(),Pos.CENTER);
        bp.setAlignment(bp.getBottom(),Pos.CENTER);
        bp.setMargin(bp.getTop(),new Insets(100,60,100,60));
        bp.setMargin(bp.getCenter(),new Insets(20));



        root.getChildren().add(bp);
    }

    @Override
    public Pane GetRootPane() {
        return root;
    }
}
