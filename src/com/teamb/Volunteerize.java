/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamb;

import com.teamb.controller.LoginViewController;
import com.teamb.controller.MainLandingController;
import com.teamb.controller.SignUpController;
import com.teamb.view.SignUpView;
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
public class Volunteerize extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        //LoginView loginView = new LoginView();
        SignUpController suc = new SignUpController(primaryStage);
        SignUpView suv = new SignUpView(suc);
        Scene scene = new Scene(suv.GetRootPane(), 600, 700);
        
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
