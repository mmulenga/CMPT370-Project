///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.teamb;
//
//import com.teamb.view.LoginView;
//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//import java.sql.*;
//
///**
// *
// * @author irene
// */
//public class Volunteerize extends Application{
//    protected Connection dbConnection;
//    protected Statement dbStatement;
//
//    Stage newStage;
//
//    /**
//     * Pre: None
//     * Post: Establishes a connection with the database on success.
//     */
//    public void establishConnection() {
//        /**
//         * Attempt to establish a connection to the database.
//         */
//        try {
//            String url = "jdbc:postgresql://db.cs.usask.ca/cmpt370_team_b";
//            String username = "cmpt370_team_b";
//            String password = "DC0ptDpfwvcYI2RGif9F";
//            // TODO Make sure to remove password before commiting.
//            // I'm still figuring out a way to store this in a separate file
//            // so for now just leave empty brackets.
//
//            dbConnection = DriverManager.getConnection(url, username, password);
//
//            System.out.println("Connected to database.");
//        } catch(SQLException e) {
//            System.out.println("Failed to connect to database.");
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * Pre: query - String containing your SQL query.
//     * @param query
//     * @return Returns the query results.
//     */
//    public ResultSet createQuery(String query) {
//        try {
//            dbStatement = dbConnection.createStatement();
//            ResultSet result = dbStatement.executeQuery(query);
//
//            return result;
//        } catch(SQLException e) {
//            System.out.println("Query Failed.");
//
//            return null;
//        }
//    }
//
//    @Override
//    public void start(Stage primaryStage) {
//        newStage = primaryStage;
//        LoginView lginView = new LoginView(newStage);
//        Volunteerize loader = new Volunteerize();
//        Scene scene = new Scene(lginView.root, 720, 540);
//
//        loader.establishConnection();
//
//        scene.getStylesheets().add
//                (Volunteerize.class.getResource("LoginStyle.css").toExternalForm());
//
//        primaryStage.setTitle("Volunteerize");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//
//        // Close out the database connection.
//        try {
//            loader.dbConnection.close();
//        } catch(SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//}
