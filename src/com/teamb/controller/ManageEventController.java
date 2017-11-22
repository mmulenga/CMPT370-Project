package com.teamb.controller;

import com.teamb.model.EventSelection;
import com.teamb.view.BasicView;
import com.teamb.view.ManageEventView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class ManageEventController extends BasicController {
    ManageEventView view;
    public ManageEventController(Stage s) {
        super(s);
        view = new ManageEventView();
        view.deleteEventsBtn.setOnAction(new deleteEventsBtnEventHandler());
        view.createNewEventBtn.setOnAction(new createNewEventBtnEventHandler());
    }

    class deleteEventsBtnEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            for (EventSelection es:view.table.getItems()) {
                if(es.isActive()){
                    System.out.println(es.getEventTitle()+" is deleted.");
                }
            }
        }
    }

    class createNewEventBtnEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            handleCreateNewEventButtonClick();
        }
    }


    @Override
    public BasicView GetView() {
        return view;
    }

    public void handleCreateNewEventButtonClick(){
        CreateEventController createEventController = new CreateEventController(stage);
        Scene scene = new Scene(createEventController.GetView().GetRootPane(),600,600);
        stage.setScene(scene);
        stage.show();
    }

}
