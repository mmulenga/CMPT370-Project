package com.teamb.view;

import com.teamb.controller.BasicController;
import com.teamb.controller.MainLandingController;
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
        CreateChildren();
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

        TableView<ProfileCheck> table = new TableView<>();

        ObservableList<ProfileCheck> dummylist = ((ManageVolunteersController) controller).GetObservableProfiles();//TODO this will be the actual list

        table.setItems(dummylist);

        TableColumn<ProfileCheck,String> firstNameCol = new TableColumn<ProfileCheck,String>("First Name");
        firstNameCol.setCellValueFactory(new PropertyValueFactory("firstName"));

        for (ProfileCheck p : dummylist) {
            p.isActive().addListener((obs, old, now) -> {
                System.out.print(obs);

            });
        }

//        TableColumn<ProfileCheck, String> nameCol = new TableColumn<>("Name");
//        TableColumn<ProfileCheck, Boolean> phoneCol = new TableColumn<>("Phone?");
//        TableColumn<ProfileCheck, Boolean> emailCol = new TableColumn<>("Email?");
//        TableColumn<ProfileCheck, Boolean> activeCol = new TableColumn<>("Select");

        //Create observable list



            //System.out.println(controller.toString());

            //table.getColumns().addAll(nameCol, phoneCol, emailCol, activeCol);

            table.setEditable(true);

//            phoneCol.setCellValueFactory(new PropertyValueFactory<>("wantsPhoneCall"));
//            phoneCol.setVisible(true);
//
//            emailCol.setCellValueFactory(new PropertyValueFactory<>("wantsEmails"));
//            emailCol.setVisible(true);
//
//            activeCol.setCellFactory(CheckBoxTableCell.forTableColumn(activeCol));
//            activeCol.setVisible(true);
//            activeCol.setEditable(true);
            root.getChildren().add(table);
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
    //}
}
