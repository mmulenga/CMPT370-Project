package com.teamb.model;

import java.util.ArrayList;

/**
 * Created by Sarah on 2017-10-10.
 */
public class VolunteerGroup {

    ArrayList<String> groupList;


//    VolunteerGroup(){
//    	groupList = new List<String>();
//    }

    public void addGroup(String groupName){

        groupList.add(groupName);
    }

    public void removeGroup(String groupName){
    	groupList.remove(groupName);
    }

    public String[] getAllGroups(){
    	//TODO: implement
    	if(this.isEmpty()){
    		return null;
    	}
    	String[] var = new String[this.size];
    	for(int i = 0; this.size() > i; i++){
    		var.add(this.get(i));

    	}
    }

    public int getGroupSize(){
    	return this.size;
    }

}

