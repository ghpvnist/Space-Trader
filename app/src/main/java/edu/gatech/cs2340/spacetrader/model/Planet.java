package edu.gatech.cs2340.spacetrader.model;

import java.io.Serializable;

public class Planet implements Serializable {

    String name;

    public Planet() {
        this.name = "";
    }

    public Planet(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
