/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamb;

import com.teamb.controller.EventController;
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
