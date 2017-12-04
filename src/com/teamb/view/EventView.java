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
    public ArrayList<Button> buttons;

    //Pane root;
    //EventController controller;
    ArrayList<Event> eventList; //TODO:LIST OF EVENTS FROM DATABASE

    public EventView(){

        super();
        //eventList = c.GetEventModel();


    }

    public void PopulateEventList(ArrayList<Event> events){
        for(int i = 0; i < events.size(); i++){
            gp = new GridPane();
            ColumnConstraints column1 = new ColumnConstraints();
            column1.setPercentWidth(33);
            gp.getColumnConstraints().addAll(column1, column1, column1);
            Label title = new Label();

            title.setText(events.get(i).getEventName());
            Label description = new Label();
            description.setWrapText(true);
            description.setText(events.get(i).getDescription());
            readMore = new Button("Read More");
            buttons.add(readMore);
            readMore.setId(Integer.toString(i));
            //tempEvent = eventModel.get(i);

            gp.add(title, 1, 0 );
            gp.add(description, 1, 1, 2, 1);
            gp.add(readMore, 2, 2 );
            eventListBox.getChildren().add(gp);
            //System.out.println(i + " " +title.getText());
            System.out.println(readMore.getId());
        }
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
