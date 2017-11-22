package com.teamb.view;


import com.teamb.model.Event;
import com.teamb.model.EventSelection;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
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

public class ManageEventView extends BasicView {

    public Button deleteEventsBtn;
    public TableView<EventSelection> table;
    public Button createNewEventBtn;

    /**
     * Constructor.
     * Creates the root pane, and adds the children with the CreateChildren() method.
     * May have parameters based on what information is needed from the controller
     *
     * @param c
     */
    public ManageEventView() {
        super();
    }

    @Override
    public Pane GetRootPane() {
        return root;
    }

    @Override
    public void CreateChildren() {
        TableView<EventSelection> table = new TableView<>();
        table.setEditable(true);

        TableColumn<EventSelection, Boolean> activeCol = createColumn("Selection","active");
        table.getColumns().add(activeCol);

        table.getColumns().add(createColumn("Event Title","eventTitle"));
        table.getColumns().add(createColumn("Event ID","eventID"));

        activeCol.setCellFactory(col -> {
            CheckBoxTableCell<EventSelection, Boolean> cell = new CheckBoxTableCell<>(index -> {
                BooleanProperty active = new SimpleBooleanProperty(table.getItems().get(index).isActive());
                active.addListener((obs, wasActive, isNowActive) -> {
                    EventSelection item = table.getItems().get(index);
                    item.setActive(isNowActive);
                });
                return active ;
            });
            return cell ;
        });

        TextField searchKeyField = new TextField();
        searchKeyField.setPromptText("Enter keyword here");

        Button createNewEventBtn = new Button("Create New Event");
        Button deleteEventsBtn = new Button("Delete Events");
        Button searchBtn = new Button("Search");

        //fake event data TODO get real data instead
        for(int i = 0; i<5;i++){
            Event e = new Event();
            e.setEventName("Event "+i);
            EventSelection es = new EventSelection(e,false);
            table.getItems().add(es);
        }

        Label label = new Label("Manage Events");
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
        gp.add(label, 0, 0,3,1);
        gp.add(table,0,1,2,1);
        gp.add(searchKeyField,0,2);
        gp.add(searchBtn,0,3);
        gp.add(createNewEventBtn, 0,4);
        gp.add(deleteEventsBtn,0,5);

        root.getChildren().add(gp);

    }



    private <S,T> TableColumn<S,T> createColumn(String title, String propertyName) {
        TableColumn<S,T> col = new TableColumn<>(title);
        col.setCellValueFactory(new PropertyValueFactory<>(propertyName));
        return col;
    }
}
