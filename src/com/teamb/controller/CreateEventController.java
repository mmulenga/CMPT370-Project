package com.teamb.controller;

import com.teamb.model.Event;
import com.teamb.model.Profile;
import com.teamb.model.VolunteerizeModel;
import com.teamb.view.BasicView;
import com.teamb.view.CreateEventView;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.Date;

public class CreateEventController extends BasicController {

    CreateEventView view;
    Event event;
    VolunteerizeModel model;

    public CreateEventController(Stage s) {
        super(s);
        view = new CreateEventView(this);
        view.submit.setOnAction(new submitEventHandler());
        view.clear.setOnAction(new clearEventHandler());
        view.home.setOnAction(new homeEventHandler());
    }

    class submitEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            createNewEvent();
            completePopUP();
        }
    }

    class clearEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            view.eventTitleField.clear();
            view.locationField.clear();
            view.descriptionArea.clear();
            view.startTimeBox.getSelectionModel().select(0);
            view.endTimeBox.getSelectionModel().select(0);
            view.startDatePicker.setValue(LocalDate.now());
            view.endDatePicker.setValue(view.startDatePicker.getValue().plusDays(1));
        }

    }

    class homeEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            changeToHomePageView(stage);

        }
    }

    @Override
    public BasicView GetView() {
        return view;
    }


    public void createNewEvent() {
        /**
         * Converting string values from
         * ComboBox to integer values.
         */
        String[] hourMin = (view.startTimeBox.getValue().toString()).split(":");
        int endHour = Integer.parseInt(hourMin[0]);
        endHour = endHour*100;
        int endMin = Integer.valueOf(hourMin[1]);
        int endTime = endHour + endMin;

        String[] hourMin1 = (view.endTimeBox.getValue().toString()).split(":");
        int startHour = Integer.parseInt(hourMin1[0]);
        startHour = startHour*100;
        int startMin = Integer.valueOf(hourMin1[1]);
        int startTime = startHour + startMin;


        System.out.println(startTime);
        System.out.println(endTime);
       // System.out.println (CreateDate((view.startDatePicker.getEditor().getText())));

        event = new Event();
        model = new VolunteerizeModel();
       // event.setEventID();
        event.setEventName(view.eventTitleField.getText());
        event.setStartTime(startTime);
        event.setEndTime(endTime);
        event.setStartDate( view.startDatePicker.getEditor().getText());
        event.setEndDate( view.endDatePicker.getEditor().getText());
        event.setLocation(view.locationField.getText());
        view.endTimeBox.getValue().toString();
        event.setDescription(view.descriptionArea.getText());
        model.addEvent(event);
    }

    /**
     * Pop up box to alert user of newly created Profile
     * and a button that goes to the new user's profile
     * landing page.
     */
    public void completePopUP(){
        Stage popupwindow=new Stage();

        popupwindow.initModality(Modality.APPLICATION_MODAL);
        popupwindow.setTitle("Volunteerize");


        Label completeInformationLabel= new Label(event.getEventName() + " has now been created");
        Button profileButton= new Button("Go to Upcoming Events");
        profileButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                popupwindow.close();
                changeToHomePageView(stage);

            }
        });

        VBox layout= new VBox(10);
        layout.getChildren().addAll(completeInformationLabel, profileButton);
        layout.setAlignment(Pos.CENTER);
        Scene scene1= new Scene(layout, 300, 250);
        popupwindow.setScene(scene1);
        popupwindow.showAndWait();

    }


    public void changeToHomePageView(Stage s){
        StaffLandingController slc = new StaffLandingController(s);

        Scene scene = new Scene(slc.GetView().GetRootPane(), 720, 540);
        s.setScene(scene);
        s.show();

    }


    /*public String CreateDate(String date){
        String day = date.substring(0, 2);
        String month = date.substring(3, 4);
        String year= date.substring(4, 5);

        //Date tempDate = new Date();
        String tempDate = ("" + day + "" + month + "" + year);
        return tempDate;
    }*/

    /*public void ChangeToUpcomingEventView(Stage s){
        VolunteerLandingController vlc = new VolunteerLandingController(s);

        Scene scene = new Scene(vlc.GetView().GetRootPane(), 720, 540);
        s.setScene(scene);
        s.show();

    }*/

}