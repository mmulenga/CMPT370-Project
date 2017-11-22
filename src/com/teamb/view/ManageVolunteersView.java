package com.teamb.view;

import com.teamb.controller.ManageVolunteersController;

import com.teamb.model.Profile;
import com.teamb.model.ProfileSelection;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


import java.util.ArrayList;

/**
 * Created by Sarah on 2017-11-19.
 */
public class ManageVolunteersView extends BasicView {


    /**
     * Constructor.
     * Creates the root pane, and adds the children with the CreateChildren() method.
     * May have parameters based on what information is needed from the controller
     *
     * @param c
     */
    public ManageVolunteersView(ManageVolunteersController c) {
        super(c);
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
        TableView<ProfileSelection> table = new TableView<>();
        table.setEditable(true);

        TableColumn<ProfileSelection, Boolean> activeCol = createColumn("Selection", "active");
        table.getColumns().add(activeCol);

        table.getColumns().add(createColumn("First Name", "firstName"));
        table.getColumns().add(createColumn("Last Name", "lastName"));

        activeCol.setCellFactory(col -> {
            CheckBoxTableCell<ProfileSelection, Boolean> cell = new CheckBoxTableCell<>(index -> {
                BooleanProperty active = new SimpleBooleanProperty(table.getItems().get(index).isActive());
                active.addListener((obs, wasActive, isNowActive) -> {
                    ProfileSelection item = table.getItems().get(index);
                    item.setActive(isNowActive);
                });
                return active;
            });
            return cell;
        });

        TextField searchKeyField = new TextField();
        searchKeyField.setPromptText("Search Volunteers. Enter name or number");

        Button createNewVolButton = new Button("Add new volunteer");
        Button sendEmailButton = new Button("Send Email to selected");
        Button printPhoneListButton = new Button("Print phone list for selected");
        Button deleteProfilesButton = new Button("Delete selected profiles");
        Button searchBtn = new Button("Search");

        createNewVolButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ((ManageVolunteersController)controller).ChangeToSignUpView();
            }
        });

        sendEmailButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ((ManageVolunteersController)controller).SendEmails(/* TODO selected vol id's*/);
            }
        });

        printPhoneListButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ((ManageVolunteersController)controller).PrintPhoneList();
            }
        });

        deleteProfilesButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ((ManageVolunteersController)controller).DeleteProfiles();
            }
        });

        searchBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ((ManageVolunteersController)controller).Search(searchKeyField.getText());
            }
        });

        //TODO GET REAL DATA
        for(int i = 0; i < 5; i++){
            Profile p = new Profile();
            p.setFirstName("first name" + i);
            p.setLastName("last name" + i);
            ProfileSelection ps = new ProfileSelection(p, false);
            table.getItems().add(ps);
        }

        Label label = new Label("Manage Volunteers");
        label.setFont(Font.font("Arial", FontWeight.BOLD, 24));

        GridPane gp = new GridPane();
        gp.setAlignment(Pos.CENTER);
        gp.setPadding(new Insets(30,30,30,30));
        gp.setHgap(10);
        gp.setVgap(10);

        // columnOneConstraints will be applied to all the nodes placed in column one.
        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 200, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.LEFT);

        // columnTwoConstraints will be applied to all the nodes placed in column two.
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(100,150, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        ColumnConstraints columnThreeConstrains = new ColumnConstraints(100,150, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gp.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains, columnThreeConstrains);

        gp.add(label, 0,0, 3, 1);
        gp.add(table, 0, 1, 2,1);
        gp.add(searchKeyField, 0, 2);
        gp.add(searchBtn, 0, 3);
        gp.add(createNewVolButton, 0, 4);
        gp.add(deleteProfilesButton, 0, 5);

        root.getChildren().add(gp);

    }

    private <S,T> TableColumn<S,T> createColumn(String title, String propertyName){
        TableColumn<S,T> col = new TableColumn<>(title);
        col.setCellValueFactory(new PropertyValueFactory<>(propertyName));
        return col;
    }
}
