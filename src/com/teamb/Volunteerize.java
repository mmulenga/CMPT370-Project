/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamb;

import com.teamb.controller.EventController;
import com.teamb.controller.LoginViewController;
import com.teamb.view.EventView;
import com.teamb.view.LoginView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author irene
 */
public class Volunteerize extends Application{
    Stage newStage;

    @Override
    public void start(Stage primaryStage) {

        newStage = primaryStage;
        LoginView lginView = new LoginView(newStage);

        Scene scene = new Scene(lginView.root, 720, 540);
        scene.getStylesheets().add
                (Volunteerize.class.getResource("LoginStyle.css").toExternalForm());

        primaryStage.setTitle("Volunteerize");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
