package edu.gatech.cs2340.spacetrader.model;

import android.content.res.Resources;

import edu.gatech.cs2340.spacetrader.entity.Resource;
import edu.gatech.cs2340.spacetrader.entity.TechLevel;

public class SolarSystem {

    private Planet[] planets;
    private String name;
    private int x;
    private int y;
    private TechLevel techLevel;
    private Resource resources;

    public SolarSystem(String name, int x, int y, int techRank, int resourceRank){

        this.x = x;
        this.y = y;
        this.techLevel = TechLevel.get(techRank);
        this.resources = Resource.get(resourceRank);

        this.planets = new Planet[1];
        this.planets[0] = new Planet(name);

        this.name = name + " System";

    }

    public Planet[] getPlanets() {
        return planets;
    }

    public void setPlanets(Planet[] planets) {
        this.planets = planets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public TechLevel getTechLevel() {
        return techLevel;
    }

    public void setTechLevel(TechLevel techLevel) {
        this.techLevel = techLevel;
    }

    public Resource getResources() {
        return resources;
    }

    public void setResources(Resource resources) {
        this.resources = resources;
    }
}
