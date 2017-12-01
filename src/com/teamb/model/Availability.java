package com.teamb.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

/**
 * Created by Sarah on 2017-10-10.
 */
public class Availability {
    public boolean[][] availablilityArray;
    public Availability()
    {
        availablilityArray = new boolean[7][3];
        for(int i=0;i<7;i++){
            for(int j=0;j<3;j++){
                availablilityArray[i][j] = false;
            }
        }
    }

    //0 = monday, 1 = tuesday etc
    //0 = morning, 1 = afternoon
    public void ChangeAvailability(int day, int shift, boolean isAvailable){
        availablilityArray[day][shift] = isAvailable;
    }

    public boolean  GetAvailablity(int day, int  shift){
        return availablilityArray[day-1][shift];
   }

   public ArrayList<Shift> fetchAvailabiliity(){
        ArrayList<Shift> sList = new ArrayList<Shift>();
       Shift morningShift = new Shift("Morning", availablilityArray[0][0], availablilityArray[1][0], availablilityArray[2][0],
               availablilityArray[3][0], availablilityArray[4][0], availablilityArray[5][0],
               availablilityArray[6][0]);
       Shift afternoonShift = new Shift("Afternoon", availablilityArray[0][1], availablilityArray[1][1], availablilityArray[2][1],
               availablilityArray[3][1], availablilityArray[4][1], availablilityArray[5][1],
               availablilityArray[6][1]);
       Shift eveningShift = new Shift("Evening", availablilityArray[0][2], availablilityArray[1][2], availablilityArray[2][2],
               availablilityArray[3][2], availablilityArray[4][2], availablilityArray[5][2],
               availablilityArray[6][2]);
       sList.add(morningShift);
       sList.add(afternoonShift);
       sList.add(eveningShift);
       return sList;
    }

    public String toString(){
       String temp = "";
       System.out.println("Day  |  Morning  |  Afternon  |  Evening");
       for(int i=0; i<7;i++){
           temp += (i+1) + "          ";
           if(availablilityArray[i][0]){
               temp += "true       ";
           }else{
               temp += "false       ";
           }
           if(availablilityArray[i][1]){
               temp += "true       ";
           }else{
               temp += "false       ";
           }
           if(availablilityArray[i][2]){
               temp += "true       ";
           }else{
               temp += "false       ";
           }
           System.out.println(temp);
           temp = "";
       }
       return temp;
    }

    public TableView<Shift> getAvailabilityTable(boolean ifEditable){
        TableView<Shift> availabilityTable = new TableView<>();
        availabilityTable.setEditable(ifEditable);

        availabilityTable.getColumns().add(createColumn("Shift","shift"));

        TableColumn<Shift, Boolean> monCol = createColumn("Monday","mon");
        availabilityTable.getColumns().add(monCol);
        TableColumn<Shift, Boolean>tueCol = createColumn("Tuesday","tue");
        availabilityTable.getColumns().add(tueCol);
        TableColumn<Shift, Boolean>wedCol = createColumn("Wednesday","wed");
        availabilityTable.getColumns().add(wedCol);
        TableColumn<Shift, Boolean>thurCol = createColumn("Thursday","thur");
        availabilityTable.getColumns().add(thurCol);
        TableColumn<Shift, Boolean>friCol = createColumn("Friday","fri");
        availabilityTable.getColumns().add(friCol);
        TableColumn<Shift, Boolean>satCol = createColumn("Saturday","sat");
        availabilityTable.getColumns().add(satCol);
        TableColumn<Shift, Boolean>sunCol = createColumn("Sunday","sun");
        availabilityTable.getColumns().add(sunCol);
        monCol.setCellFactory(col ->{
            CheckBoxTableCell<Shift, Boolean> cell = new CheckBoxTableCell<>(index->{
                BooleanProperty mon = new SimpleBooleanProperty(availabilityTable.getItems().get(index).isMonAvailable());
                mon.addListener((obs, wasActive, isnowactive)->{
                    Shift a = availabilityTable.getItems().get(index);
                    a.mon = isnowactive;
                });
                return mon;
            });
            return cell;
        });

        tueCol.setCellFactory(col ->{
            CheckBoxTableCell<Shift, Boolean> cell = new CheckBoxTableCell<>(index->{
                BooleanProperty tue = new SimpleBooleanProperty(availabilityTable.getItems().get(index).isTueAvailable());
                tue.addListener((obs, wasActive, isnowactive)->{
                    Shift a = availabilityTable.getItems().get(index);
                    a.tue = isnowactive;
                });
                return tue;
            });
            return cell;
        });
        wedCol.setCellFactory(col ->{
            CheckBoxTableCell<Shift, Boolean> cell = new CheckBoxTableCell<>(index->{
                BooleanProperty wed = new SimpleBooleanProperty(availabilityTable.getItems().get(index).isWedAvailable());
                wed.addListener((obs, wasActive, isnowactive)->{
                    Shift a = availabilityTable.getItems().get(index);
                    a.wed = isnowactive;
                });
                return wed;
            });
            return cell;
        });

        thurCol.setCellFactory(col ->{
            CheckBoxTableCell<Shift, Boolean> cell = new CheckBoxTableCell<>(index->{
                BooleanProperty thur = new SimpleBooleanProperty(availabilityTable.getItems().get(index).isThurAvailable());
                thur.addListener((obs, wasActive, isnowactive)->{
                    Shift a = availabilityTable.getItems().get(index);
                    a.thur = isnowactive;
                });
                return thur;
            });
            return cell;
        });
        friCol.setCellFactory(col ->{
            CheckBoxTableCell<Shift, Boolean> cell = new CheckBoxTableCell<>(index->{
                BooleanProperty fri = new SimpleBooleanProperty(availabilityTable.getItems().get(index).isFriAvailable());
                fri.addListener((obs, wasActive, isnowactive)->{
                    Shift a = availabilityTable.getItems().get(index);
                    a.fri = isnowactive;
                });
                return fri;
            });
            return cell;
        });
        satCol.setCellFactory(col ->{
            CheckBoxTableCell<Shift, Boolean> cell = new CheckBoxTableCell<>(index->{
                BooleanProperty sat = new SimpleBooleanProperty(availabilityTable.getItems().get(index).isSatAvailable());
                sat.addListener((obs, wasActive, isnowactive)->{
                    Shift a = availabilityTable.getItems().get(index);
                    a.sat = isnowactive;
                });
                return sat;
            });
            return cell;
        });
        sunCol.setCellFactory(col ->{
            CheckBoxTableCell<Shift, Boolean> cell = new CheckBoxTableCell<>(index->{
                BooleanProperty sun = new SimpleBooleanProperty(availabilityTable.getItems().get(index).isSunAvailable());
                sun.addListener((obs, wasActive, isnowactive)->{
                    Shift a = availabilityTable.getItems().get(index);
                    a.sun = isnowactive;
                });
                return sun;
            });
            return cell;
        });

        for (Shift shift: this.fetchAvailabiliity()
             ) {
            availabilityTable.getItems().add(shift);
        }
//        availabilityTable.getItems().addAll(a1,a2,a3);
        availabilityTable.setPrefHeight(130);


        return availabilityTable;
    }
    private <S,T> TableColumn<S,T> createColumn(String title, String propertyName) {
        TableColumn<S,T> col = new TableColumn<>(title);
        col.setCellValueFactory(new PropertyValueFactory<>(propertyName));
        return col;
    }
}
