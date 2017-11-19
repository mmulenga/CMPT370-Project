package com.teamb.view;

import com.teamb.controller.StaffLandingController;
import javafx.scene.layout.Pane;

/**
 * Created by Sarah on 2017-11-19.
 */
public class StaffLandingView extends BasicView {

    public StaffLandingController controller;

    public StaffLandingView(StaffLandingController c){
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

    @Override
    protected void CreateChildren() {

    }
}
