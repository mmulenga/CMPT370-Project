package com.teamb.controller;

import com.teamb.view.LoginView;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginViewController extends BasicController {
    private String username;
    private String password;
    //public Stage currentStage;
    LoginView loginView;

    private boolean isStaff;

    public LoginViewController(Stage s){
        super(s);
        loginView = new LoginView(this);
        isStaff = false; //TODO: Actually check this

    }

    @Override
    protected void ChangeView() {

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
//        try {
            //For View and Controller test
            this.ChangeToLandingView(stage);
            return true;
            /**
             * Cheating here. Shouldn't create a new connnection on a per-function basis.
             * Only need to create it once in the Startup class.
             */
//            Startup database = new Startup();
//            database.establishConnection();
//
//
//            ResultSet result = database.createQuery("SELECT * FROM Users");
//            setUsername(username);
//            setPassword(password);

            /**
             * Check entered username and password against each entry in the Users table.
             */
//            while(result.next()) {
//                if(getUsername().compareTo(result.getString("username")) == 0 &&
//                        getPassword().compareTo(result.getString("password")) == 0) {
//                    System.out.println("Credentials OK!");
//                    this.ChangeToLandingView(stage);
//                    return true;
//
//                }
//            }
//            return false;
//            //TODO: Notice the view to show error message;
//        } catch(Exception e) {
//            System.out.println("Event view failed.");
//        }
//        return false;
//        //TODO: Notice the view to show error message;
    }


    private void ChangeToLandingView(Stage s ){
        //System.out.println(isStaff);
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

    public LoginView GetView(){
        return loginView;
    }
}
