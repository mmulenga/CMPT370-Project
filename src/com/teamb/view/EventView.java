package com.teamb.view;

import com.teamb.model.Event;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.control.Button;

import java.util.ArrayList;

public class EventView extends Pane {

//    int eventCount;
//    public VBox outside;
//    VBox eventList;
//
//    public EventView(){
//        outside = new VBox(5);
//        eventList = new VBox(5);
//
//        Label title = new Label("Upcoming Events");
//        title.setId("scenetitle");
//        outside.getChildren().add(title);
//        outside.getChildren().add(eventList);
//
//    }
//    public void displayEventList(ArrayList<Event> listFromDatabase){
//        for(int i = 0; i < listFromDatabase.size(); i++){
//            GridPane gp = new GridPane();
//
//            ColumnConstraints column1 = new ColumnConstraints();
//            column1.setPercentWidth(33);
//            gp.getColumnConstraints().addAll(column1, column1, column1);
//            Label title = new Label();
//            title.setText(listFromDatabase.get(i).name);
//            Label description = new Label();
//            description.setWrapText(true);
//            description.setText(listFromDatabase.get(i).description);
//            Button readMore = new Button("Read More");
//          //  Image image = new Image(listFromDatabase.get(i).imagePath);
//          //  ImageView iv = new ImageView(image);
//
//          //  gp.add(iv, 0, 0, 1, 3);
//            gp.add(title, 1, 0 );
//            gp.add(description, 1, 1, 2, 1);
//            gp.add(readMore, 2, 2 );
//            eventList.getChildren().add(gp);
//        }
//    }




}
