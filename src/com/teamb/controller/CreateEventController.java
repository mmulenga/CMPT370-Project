package com.teamb.controller;

import com.teamb.view.BasicView;
import com.teamb.view.CreateEventView;
import javafx.stage.Stage;

public class CreateEventController extends BasicController {

    CreateEventView view;

    public CreateEventController(Stage s) {
        super(s);
        view = new CreateEventView(this);
    }

    @Override
    public BasicView GetView() {
        return view;
    }
}
