package com.teamb.controller;

import com.teamb.view.BasicView;
import com.teamb.view.MainLandingView;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Sarah on 2017-11-07.
 *
 */
public class MainLandingController extends BasicController{

    MainLandingView mainView;

    public MainLandingController(Stage s){
        super(s);
        mainView = new MainLandingView(this);

    }


    @Override
    public BasicView GetView() {
        return mainView;
    }

    public void ChangeToLoginView(ActionEvent event){

       LoginViewController lvc = new LoginViewController(stage);

        Scene scene = new Scene(lvc.GetView().GetRootPane(), 720, 540);
//        scene.getStylesheets().add
//                (Volunteerize.class.getResource("LoginStyle.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }



}
