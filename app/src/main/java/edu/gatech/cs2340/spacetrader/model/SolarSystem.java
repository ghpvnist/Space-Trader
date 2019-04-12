package edu.gatech.cs2340.spacetrader.model;

import java.io.Serializable;

/**
 * Class that represents a solar system
 */
public class SolarSystem implements Serializable {

    private Planet[] planets;
    private String name;
    private int x;
    private int y;
    private TechLevel techLevel;
    private Resource resources;

    /**
     * Constructor for the class
     * @param name the name of the solar system
     * @param x the x location of the solar system
     * @param y the y location of the solar system
     * @param techRank the tech rank of the solar system
     * @param resourceRank the resource rank of the solar system
     */
    public SolarSystem(String name, int x, int y, int techRank, int resourceRank) {

        this.x = x;
        this.y = y;
        this.techLevel = TechLevel.get(techRank);
        this.resources = Resource.get(resourceRank);

        this.planets = new Planet[1];
        this.planets[0] = new Planet(name, x, y, this.resources, this.techLevel);

        this.name = name + " System";

    }

    /**
     * Converts the fields of the solar system to a string
     * @return the string representation of the solar system
     */
    public String toString() {
        return "name = " + name + ", " +
                "x = " + x + ", " +
                "y = " + y + ", " +
                "tech_level = " + techLevel.toString() + ", " +
                "resources = " + resources.toString();
    }

    /**
     * Gets techLevel.
     *
     * @return Value of techLevel.
     */
    public TechLevel getTechLevel() {
        return techLevel;
    }

    /**
     * Sets new x.
     *
     * @param x New value of x.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Sets new resources.
     *
     * @param resources New value of resources.
     */
    public void setResources(Resource resources) {
        this.resources = resources;
    }

    /**
     * Sets new name.
     *
     * @param name New value of name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets x.
     *
     * @return Value of x.
     */
    public int getX() {
        return x;
    }

    /**
     * Sets new y.
     *
     * @param y New value of y.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Gets resources.
     *
     * @return Value of resources.
     */
    public Resource getResources() {
        return resources;
    }

    /**
     * Gets planets.
     *
     * @return Value of planets.
     */
    public Planet[] getPlanets() {
        return planets.clone();
    }

    /**
     * Sets new planets.
     *
     * @param planets New value of planets.
     */
    public void setPlanets(Planet[] planets) {
        this.planets = planets.clone();
    }

    /**
     * Gets name.
     *
     * @return Value of name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets y.
     *
     * @return Value of y.
     */
    public int getY() {
        return y;
    }

    /**
     * Sets new techLevel.
     *
     * @param techLevel New value of techLevel.
     */
    public void setTechLevel(TechLevel techLevel) {
        this.techLevel = techLevel;
    }
}
