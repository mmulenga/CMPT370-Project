package com.teamb.controller;

import com.teamb.view.LoginView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class LoginViewController extends BasicController {

    private String username;
    private String password;
    LoginView loginView;

    private boolean isStaff;

    public LoginViewController(Stage s){
        super(s);
        loginView = new LoginView();
        isStaff = false; //TODO: Actually check this
        loginView.login.setOnAction(new loginEventHandler());
        loginView.Signup.setOnAction(new SignupEventHandler());
    }

    class loginEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            if (checkCredentials(loginView.userNameField.getText(), loginView.pwField.getText())) {
                loginView.loginOK = true;
            } else {
                Label loginError = new Label("username or password is wrong. Please try again.");
                loginView.gp.add(loginError, 0, 5, 3, 1);
            }
        }
    }

    class SignupEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            //TODO: check if staff
            ChangeToSignUpView();
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {

        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public boolean checkCredentials(String username, String password) {

            this.ChangeToLandingView(stage);
            return true;
            //TODO: Currently, this always returns true, actually implement
    }


    private void ChangeToLandingView(Stage s ){

        if(isStaff){

            StaffLandingController slc = new StaffLandingController(s);

            Scene scene = new Scene(slc.GetView().GetRootPane(), 720, 540);
//        scene.getStylesheets().add
//                (Volunteerize.class.getResource("LoginStyle.css").toExternalForm());
            s.setScene(scene);
            s.show();
        }
        else{
            VolunteerLandingController vlc = new VolunteerLandingController(s);

            Scene scene = new Scene(vlc.GetView().GetRootPane(), 720, 540);
//        scene.getStylesheets().add
//                (Volunteerize.class.getResource("LoginStyle.css").toExternalForm());
            s.setScene(scene);
            s.show();
        }

    }

    public void ChangeToSignUpView(){
        SignUpController suc = new SignUpController(stage);
        Scene scene = new Scene(suc.GetView().GetRootPane(), 600, 600);
        stage.setScene(scene);
        stage.show();
    }

    public LoginView GetView(){
        return loginView;
    }
}
