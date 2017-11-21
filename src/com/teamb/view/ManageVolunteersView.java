package com.teamb.view;

import com.teamb.controller.ManageVolunteersController;

import javafx.scene.layout.Pane;


import java.util.ArrayList;

/**
 * Created by Sarah on 2017-11-19.
 */
public class ManageVolunteersView extends BasicView {

    //ManageVolunteersController controller;

    /**
     * Constructor.
     * Creates the root pane, and adds the children with the CreateChildren() method.
     * May have parameters based on what information is needed from the controller
     *
     * @param c
     */
    public ManageVolunteersView(ManageVolunteersController c) {
        super(c);
        controller = c;
    }


    /**
     * Returns the root pane.
     *
     * @return
     */
    @Override
    public Pane GetRootPane() {
        return root;
    }

    /**
     * Creates the interface containers and elements, and adds them to the root pane.
     */
    @Override
    protected void CreateChildren() {


    }
}
