package com.teamb.controller;

import com.teamb.view.BasicView;
import com.teamb.view.MainLandingView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
        mainView.vButton.setOnAction(new vButtonEventHandler());
        mainView.sButton.setOnAction(new sButtonEventHandler());
    }

    class vButtonEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {ChangeToLoginView(event);}
    }

    class sButtonEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {ChangeToLoginView(event);}
    }

    @Override
    public BasicView GetView() {
        return mainView;
    }

    public void ChangeToLoginView(ActionEvent event){

       LoginViewController lvc = new LoginViewController(stage);

        Scene scene = new Scene(lvc.GetView().GetRootPane(), 600, 600);
//        scene.getStylesheets().add
//                (Volunteerize.class.getResource("LoginStyle.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }



}
