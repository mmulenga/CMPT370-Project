package com.teamb.model;

/**
 * Created by Sarah on 2017-10-10.
 */
public class User {

    private String userName;
    private String password;

    private boolean isStaff;
    //Irene: Or we can use Enum type to do the case switch for the access
    public enum access{Volunteer, Staff};

    public void example(){
        switch (access){
            case Volunteer:
                System.out.println("I'm volunteer");
                break;
            case Staff:
                System.out.println("I'm staff");
                break;
        }
    }

}
