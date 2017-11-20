package com.teamb.view;

import com.teamb.controller.BasicController;
import com.teamb.controller.EventController;
import com.teamb.model.Event;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.List;

public class EventView extends BasicView {

    int eventCount;
    public VBox outside;
    VBox eventListBox;

    //Pane root;
    //EventController controller;
    ArrayList<Event> eventList; //TODO:LIST OF EVENTS FROM DATABASE

    public EventView(EventController c){

        super(c);
        //eventList = c.GetEventModel();


    }

    public void setEventList(ArrayList<Event> e){
        //TODO: DELETE BELOW
        ArrayList<Event> dummyList = new ArrayList<Event>();
        for (int i = 0; i<10; i++){
            Event newEvent = new Event();
            dummyList.add(newEvent);
        }
        eventList = dummyList;
        //TODO: DELETE ABOVE
        //eventList = e;
        //TODO Actually get the List of events from database. Currently using a Dummy list for testing
    }
    //gets list from database and formats it
    public void PopulateEventList(){
        setEventList(eventList);

       for(int i = 0; i < eventList.size(); i++){
           GridPane gp = new GridPane();
           ColumnConstraints column1 = new ColumnConstraints();
           column1.setPercentWidth(33);
           gp.getColumnConstraints().addAll(column1, column1, column1);
           Label title = new Label();

           title.setText(eventList.get(i).getEventName());
            Label description = new Label();
            description.setWrapText(true);
            description.setText(eventList.get(i).getDescription());
            Button readMore = new Button("Read More");
            //TODO: Set on action for this button. It will redirect to the event page
            //TODO: Learn how to get images
//            Image image = new Image(listFromDatabase.get(i).imagePath);
//            ImageView iv = new ImageView(image);
//            gp.add(iv, 0, 0, 1, 3);
            gp.add(title, 1, 0 );
            gp.add(description, 1, 1, 2, 1);
            gp.add(readMore, 2, 2 );
            eventListBox.getChildren().add(gp);
       }
    }

    @Override
    protected void CreateChildren() {
        outside = new VBox(5);

        eventListBox = new VBox(5);
        PopulateEventList();
        Label title = new Label("Upcoming Events");
        title.setId("scenetitle");
        outside.getChildren().add(title);
        outside.getChildren().add(eventListBox);

        root.getChildren().add(outside);
    }

    @Override
    public Pane GetRootPane() {
        return root;
    }
}
