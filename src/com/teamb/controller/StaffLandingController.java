package com.teamb.controller;

import com.teamb.view.BasicView;
import com.teamb.view.StaffLandingView;
import javafx.stage.Stage;

/**
 * Created by Sarah on 2017-11-19.
 */
public class StaffLandingController extends BasicController {

    StaffLandingView view;

    public StaffLandingController(Stage s){
        super(s);
        view = new StaffLandingView(this);

    }

    @Override
    protected void ChangeView() {

    }

    @Override
    protected BasicView GetView() {
        return view;
    }
}
