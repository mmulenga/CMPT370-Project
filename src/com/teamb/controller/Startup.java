package com.teamb.controller;

import com.teamb.model.Event;

import java.sql.*;


public class Startup {
    protected Connection dbConnection;
    protected Statement dbStatement;

    /**
     * Pre: None
     * Post: Establishes a connection with the database on success.
     */
    public void establishConnection() {
        /**
         * Attempt to establish a connection to the database.
         */
        try {
            String url = "jdbc:postgresql://db.cs.usask.ca/cmpt370_team_b";
            String username = "cmpt370_team_b";
            String password = "DC0ptDpfwvcYI2RGif9F";
            // TODO Make sure to remove password before commiting.
            // I'm still figuring out a way to store this in a separate file
            // so for now just leave empty brackets.

            dbConnection = DriverManager.getConnection(url, username, password);

            System.out.println("Connected to database.");
        } catch(SQLException e) {
            System.out.println("Failed to connect to database.");
        }
    }

    /**
     * Pre: query - String containing your SQL query.
     * @param query
     * @return Returns the query results.
     */
    public ResultSet createQuery(String query) {
        try {
            dbStatement = dbConnection.createStatement();
            ResultSet result = dbStatement.executeQuery(query);

            return result;
        } catch(SQLException e) {
            System.out.println("Query Failed.");

            return null;
        }
    }

    public static void main(String[] args) {
        Startup start = new Startup();

        //EventController newEvent = new EventController();

        //start.establishConnection();
        //newEvent.viewEvent(start, "2");
        //newEvent.viewAllEvents(start);
    }
}
