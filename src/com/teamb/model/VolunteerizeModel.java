package com.teamb.model;
import java.sql.*;

import com.teamb.Volunteerize;

public class VolunteerizeModel {
    private DatabaseInterface database;
    private ResultSet result;

    public VolunteerizeModel() {
        database = new DatabaseInterface();
    }

    public void getVolunteerList() {
        Profile volunteerArray[] = new Profile[result.];
        result = database.select(" * FROM volunteers");

        while(result.next()) {

        }
    }
}
