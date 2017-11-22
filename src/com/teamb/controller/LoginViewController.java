package com.teamb.controller;

import com.teamb.view.LoginView;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginViewController extends BasicController {

    private String username;
    private String password;
    LoginView loginView;

    private boolean isStaff;

    public LoginViewController(Stage s){
        super(s);
        loginView = new LoginView(this);
        isStaff = true; //TODO: Actually check this
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
