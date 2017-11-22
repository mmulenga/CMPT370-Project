package com.teamb.controller;

import com.teamb.view.BasicView;
import com.teamb.view.MainLandingView;
import com.teamb.view.StaffEventProfileView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.teamb.model.Event;

/**
 * Created by David on 2017-11-20
 */
public class StaffEventProfileController extends BasicController{
    StaffEventProfileView staffView;
    Stage stage;

    public StaffEventProfileController(Stage s){
        super(s);
        staffView = new StaffEventProfileView(this);
        staffView.addButton.setOnAction(new addButtonEventHandler());
        staffView.editButton.setOnAction(new editButtonEventHandler());

    }

    class editButtonEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event){
            ChangeToEditEventView(/*editEventView*/);
        }

    }

    class addButtonEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event){ ChangeToSearchReturnView(/*searchResultView*/);
        }
    }

    @Override
    public StaffEventProfileView GetView() {
        return staffView;
    }

    public void ChangeToSearchReturnView(){
        //TODO
    }

    public void ChangeToEditEventView(){
        //TODO
    }





}
