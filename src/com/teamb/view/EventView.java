package com.teamb.view;

import com.teamb.controller.BasicController;
import com.teamb.controller.EventController;
import com.teamb.controller.VolunteerEventProfileController;
import com.teamb.model.Event;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class EventView extends BasicView {

    int eventCount;
    public VBox outside;
    public VBox eventListBox;
    public Button backButton;
    public Button readMore;
    public GridPane gp;

    //Pane root;
    //EventController controller;
    ArrayList<Event> eventList; //TODO:LIST OF EVENTS FROM DATABASE

    public EventView(){

        super();
        //eventList = c.GetEventModel();


    }


    @Override
    protected void CreateChildren() {
        backButton = new Button("<-Back");
        outside = new VBox(5);

        eventListBox = new VBox(5);
        //PopulateEventList(eventList);
        Label title = new Label("Upcoming Events");
        title.setId("scenetitle");
        outside.getChildren().add(backButton);
        outside.getChildren().add(title);
        
        outside.getChildren().add(eventListBox);


        root.getChildren().add(outside);
    }


    @Override
    public Pane GetRootPane() {
        return root;
    }
}
