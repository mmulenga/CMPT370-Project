package com.teamb.model;

import java.sql.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class DBInterface {
    protected Connection dbConnection;
    protected Statement dbStatement;

    /**
     * Pre: None
     * Post: Establishes a connection with the database on success.
     */

    public void establishConnection() {
        Properties dbProperties = new Properties();
        InputStream input = null;

        // Read the dbconfig file for database credentials.
        try {
            input = new FileInputStream("dbconfig.properties");

            dbProperties.load(input);

        } catch(IOException exception) {
            exception.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }

        // Attempt to establish a connection to the database.
        try {
            dbConnection = DriverManager.getConnection(
                    dbProperties.getProperty("database"),
                    dbProperties.getProperty("username"),
                    dbProperties.getProperty("password"));

            System.out.println("Connected to database.");

        } catch(SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void select(String query) {
        try {
            Connection con = establishConnection();
        }
    }

    public void insert(String query) {
        try {

        }
    }

    public void delete(String query) {

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
        } catch(SQLException exception) {
            System.out.println("Query Failed.");

            exception.printStackTrace();

            return null;
        }
    }



    public static void main(String[] args) {
        DBInterface database = new DBInterface();

        database.establishConnection();
    }
}
