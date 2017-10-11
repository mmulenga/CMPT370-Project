package Model;

import java.util.List;

/**
 * Created by Sarah on 2017-10-10.
 */
public class VolunteerGroup {

    List<String> groupList;


    VolunteerGroup(){

    }

    void addGroup(String groupName){
        groupList.add(groupName);
    }

}

