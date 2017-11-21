package com.teamb.controller;


import com.teamb.view.BasicView;
import com.teamb.view.ManageVolunteersView;
import javafx.stage.Stage;


/**
 * Created by Sarah on 2017-11-19.
 */
public class ManageVolunteersController extends BasicController{



    ManageVolunteersView view;

    public ManageVolunteersController(Stage s) {
        super(s);
        view = new ManageVolunteersView(this);
    }

    @Override
    protected BasicView GetView() {
        return view;
    }

}
