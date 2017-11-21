package com.teamb.controller;

import com.teamb.view.BasicView;
import com.teamb.view.ManageEventView;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class ManageEventController extends BasicController {
    ManageEventView view;
    public ManageEventController(Stage s) {
        super(s);
        view = new ManageEventView(this);
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
