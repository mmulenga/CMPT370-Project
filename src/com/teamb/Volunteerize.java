/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamb;

import com.teamb.controller.EventController;
import com.teamb.controller.Startup;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author irene
 */
public class Volunteerize extends Application{
    Stage newStage;

    @Override
    public void start(Stage primaryStage) {
        LoginView lginView = new LoginView();
        EventView eventView = new EventView();
        EventController ec = new EventController(eventView);
        newStage = primaryStage;



        Scene scene = new Scene(lginView.root, 400, 350);
        
        primaryStage.setTitle("Volunteerize");
        primaryStage.setScene(scene);
        primaryStage.show();

        if (lginView.loginOK) {
            System.out.println("Scene.");
            Scene scene2 = new Scene(eventView.outside, 400, 350);

            newStage.setScene(scene2);
            newStage.show();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
