package com.example.kristian.dtu.dk.dtuopgaveloesninger.model;

/**
 * Created by kristianschjonning on 17/10/2016.
 */

public class User {

    //private variables
    int _id;
    String _name;

    // constructor
    public User(int id, String name){
        this._id = id;
        this._name = name;
    }

    // constructor
    public User(String name){
        this._name = name;
    }


    // setting id
    public void setID(int id){
        this._id = id;
    }

    // getting name
    public String getName(){
        return this._name;
    }

    // setting name
    public void setName(String name){
        this._name = name;
    }
}
