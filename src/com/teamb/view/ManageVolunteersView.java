package com.teamb.view;

import com.teamb.controller.BasicController;
import com.teamb.controller.ManageVolunteersController;
import com.teamb.model.Event;
import com.teamb.model.Profile;
import com.teamb.model.ProfileCheck;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


import java.util.ArrayList;

/**
 * Created by Sarah on 2017-11-19.
 */
public class ManageVolunteersView extends BasicView {

    ManageVolunteersController controller;

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

    private <S,T> TableColumn<S,T> createColumn(String title, String propertyName) {
        TableColumn<S,T> column = new TableColumn<>(title);
        column.setCellValueFactory(new PropertyValueFactory<S, T>(propertyName));
        return column;
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
        //Create the table
        ObservableList<ProfileCheck> dummylist = controller.CreateDummyList();//TODO this will be the actual list
        for(ProfileCheck p:dummylist){


        }



//        TableView<ProfileCheck> table = new TableView<>();
//        table.setEditable(true);
//        table.getColumns().add(createColumn("Name", "name"));
//
//        TableColumn<ProfileCheck, Boolean> activeCol = createColumn("Active", "active");
//        table.getColumns().add(activeCol);
//
//        activeCol.setCellFactory(col -> {
//            CheckBoxTableCell<ProfileCheck, Boolean> cell = new CheckBoxTableCell<>(index -> {
//                BooleanProperty active = new SimpleBooleanProperty(table.getItems().get(index).isActive());
//                active.addListener((obs, wasActive, isNowActive) -> {
//                    ProfileCheck profileCheck = table.getItems().get(index);
//                    profileCheck.SetActive(isNowActive);
//                });
//                return active ;
//            });
//            return cell ;
//        });
//        //Create the button
//        //TODO for testing - delete this after
//        Button listActiveButton = new Button("List active");
//        listActiveButton.setOnAction(e ->
//                table.getItems().stream()
//                        .filter(ProfileCheck::isActive)
//                        .map(ProfileCheck::GetName)
//                        .forEach(System.out::println));
//
//        BorderPane mainContainer = new BorderPane(table, null, null, listActiveButton, null) ;
//        BorderPane.setAlignment(listActiveButton, Pos.CENTER);
//        BorderPane.setMargin(listActiveButton, new Insets(10));

        //root.getChildren().add(mainContainer);
    }
}
