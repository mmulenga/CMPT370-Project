package com.teamb.controller;

import com.teamb.view.BasicView;
import com.teamb.view.VolunteerProfileView;
import javafx.stage.Stage;

public class VolunteerProfileController extends BasicController {

    VolunteerProfileView view;
    public VolunteerProfileController(Stage s) {
        super(s);
        view = new VolunteerProfileView(this);
    }

    @Override
    protected BasicView GetView() {
        return view;
    }
}
