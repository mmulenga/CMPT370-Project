package com.teamb.controller;

import com.teamb.EventView;
import java.sql.ResultSet;

public class LoginViewController {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean checkCredentials(String username, String password) {
        try {
            /**
             * Cheating here. Shouldn't create a new connnection on a per-function basis.
             * Only need to create it once in the Startup class.
             */
            Startup database = new Startup();
            database.establishConnection();
            EventView eventView = new EventView();

            ResultSet result = database.createQuery("SELECT * FROM Users");
            setUsername(username);
            setPassword(password);

            /**
             * Check entered username and password against each entry in the Users table.
             */
            while(result.next()) {
                if(getUsername().compareTo(result.getString("username")) == 0 &&
                        getPassword().compareTo(result.getString("password")) == 0) {
                    System.out.println("Credentials OK!");
                    return true;
                }
            }
            return false;
        } catch(Exception e) {
            System.out.println("Event view failed.");
        }

        return false;
    }
}
