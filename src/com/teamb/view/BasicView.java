package com.teamb.view;

import javafx.scene.layout.Pane;

/**
 * Created by Sarah on 2017-11-07.
 * Abstract view class.
 */
public abstract class BasicView {


    protected Pane root;

    /**
     * Constructor.
     * Creates the root pane, and adds the children with the CreateChildren() method.
     * May have parameters based on what information is needed from the controller
     */
    public BasicView(){
        root = new Pane();
        this.CreateChildren();
    }

    /**
     * Returns the root pane.
     * @return
     */
    public abstract Pane GetRootPane();

    /**
     * Creates the interface containers and elements, and adds them to the root pane.
     */
    protected abstract void CreateChildren();
}
