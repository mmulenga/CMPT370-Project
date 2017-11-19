package com.teamb.view;

import com.teamb.controller.VolProfileController;
import javafx.scene.layout.Pane;

public class VolProfileView extends BasicView {

    VolProfileController controller;
    public VolProfileView(VolProfileController c)
    {
        super(c);
        controller = c;
    }

    @Override
    public Pane GetRootPane() {
        return root;
    }

    @Override
    protected void CreateChildren() {

    }
}
