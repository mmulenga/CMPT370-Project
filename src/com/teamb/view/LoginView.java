/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamb.view;


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
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import com.teamb.controller.LoginViewController;


/**
 *
 * @author irene
 */

//view created by controller view has instance of controller?
public class LoginView extends BasicView{

    public boolean loginOK = false; //what does this do?
    LoginViewController controller;



    public LoginView(LoginViewController c){
        super(c);
        controller = c;
    }

    @Override
    public Pane GetRootPane() {
        return root;
    }

    @Override
    protected void CreateChildren() {
        GridPane gp = new GridPane();
        Text scenetitle = new Text("Welcome to Volunteerize!");
        scenetitle.setId("scenetitle");
        // why does this create it's controller? Why does it need the stage s?
        Button login = new Button("Login");
        Button Signup = new Button("Sign Up");
        String username;
        String password;
        TextField userNameField = new TextField();
        PasswordField pwField = new PasswordField();
        Label userName = new Label("Username:");
        Label pw = new Label("Password:");

        login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (controller.checkCredentials(userNameField.getText(), pwField.getText())) {
                    loginOK = true;
                } else {
                    Label loginError = new Label("username or password is wrong. Please try again.");
                    gp.add(loginError, 0, 5, 3, 1);
                }
            }
        });

        gp.setAlignment(Pos.CENTER);
        gp.setHgap(10);
        gp.setVgap(10);
        gp.setPadding(new Insets(25, 25, 25, 25));

        gp.add(scenetitle, 0, 0, 2, 1);
        gp.add(userName, 0, 1);
        gp.add(pw, 0, 2);
        gp.add(userNameField, 1, 1);
        gp.add(pwField, 1, 2);
        gp.add(login, 1, 3);
        gp.add(Signup, 1, 4);
        root.getChildren().add(gp);
    }




}