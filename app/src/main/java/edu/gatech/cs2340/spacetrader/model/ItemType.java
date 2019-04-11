package edu.gatech.cs2340.spacetrader.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Class that contains the data for every possible item in the universe
 */
public class ItemType {

    private String itemId;
    private String name;
    private double basePrice;
    private Map<Resource, Double> resourceValueModifiers;
    private Map<TechLevel, Double> techLevelValueModifiers;

    /**
     * Constructor for the class
     * @param name the name of the item
     * @param itemId the id value for the item
     * @param basePrice the base price of the item
     * @param resourceValueModifiers the modifier value to calculate what Resource level the item can appear at
     * @param techLevelValueModifiers the modifier value to calculate what TechLevel level the item can appear at
     */
    public ItemType(String name, String itemId, double basePrice, Map<Resource, Double> resourceValueModifiers, Map<TechLevel, Double> techLevelValueModifiers) {
        this.name = name;
        this.itemId = itemId;
        this.basePrice = basePrice;
        this.resourceValueModifiers = resourceValueModifiers;
        this.techLevelValueModifiers = techLevelValueModifiers;
    }

    /**
     * Constructor for the class
     * @param name the name for the item
     * @param itemId the id value for the item
     * @param basePrice the base price for the item
     */
    public ItemType(String name, String itemId, double basePrice) {
        this(name, itemId, basePrice, new HashMap<Resource, Double>(), new HashMap<TechLevel, Double>());
    }

    /**
     * Getter for the item id field
     * @return id the id field for the object
     */
    public String getItemId() { return itemId; }

    /**
     * Getter for the name field
     * @return name the name field for the object
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the name field
     * @param name the name field to set to
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the base price field
     * @return basePrice the base price of the item
     */
    public double getBasePrice() {
        return basePrice;
    }

    /**
     * Setter for the base price field
     * @param basePrice the base price to set to
     */
    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    /**
     * Getter for the resource value modifiers field
     * @return the resourceValueModifiers field
     */
    public Map<Resource, Double> getResourceValueModifiers() {
        return resourceValueModifiers;
    }

    /**
     * Setter for the resource value modifiers field
     * @param resourceValueModifiers the resource value modifiers to set to
     */
    public void setResourceValueModifiers(Map<Resource, Double> resourceValueModifiers) {
        this.resourceValueModifiers = resourceValueModifiers;
    }

    /**
     * Getter for the tech level value modifiers field
     * @return the techLevelValueModifiers field
     */
    public Map<TechLevel, Double> getTechLevelValueModifiers() {
        return techLevelValueModifiers;
    }

    /**
     * Setter for the tech level value modifiers field
     * @param techLevelValueModifiers the tech level value modifiers to set to
     */
    public void setTechLevelValueModifiers(Map<TechLevel, Double> techLevelValueModifiers) {
        this.techLevelValueModifiers = techLevelValueModifiers;
    }

    /**
     * Contains the logic to calculate the quantity of the item at the given planet
     * @param planet the planet the item will appear at
     * @return the adjusted quantity of the item
     */
    public double getAdjustedQuantity(Planet planet) {
        double techLevelModifier = this.getTechLevelValueModifier(planet.getPlanetTechLevel());
        double resourceModifier = this.getResourceValueModifier(planet.getPlanetResource());

        if (techLevelModifier == 0 || resourceModifier == 0) {
            return 0;
        }

        return 100 / (techLevelModifier * resourceModifier);
    }

    private double getResourceValueModifier(Resource planetResource) {
        if (this.resourceValueModifiers == null) {
            return 1.0;
        } else if (!this.resourceValueModifiers.containsKey(planetResource)) {
            return 1.0;
        } else {
            return this.resourceValueModifiers.get(planetResource);
        }
    }

    private double getTechLevelValueModifier(TechLevel planetTechLevel) {
        if (this.techLevelValueModifiers == null) {
            return 1.0;
        } else if (!this.techLevelValueModifiers.containsKey(planetTechLevel)) {
            return 1.0;
        } else {
            return this.techLevelValueModifiers.get(planetTechLevel);
        }
    }

    /**
     * Contains the logic to calculate the price of the item at the given planet
     * @param planet the planet the item will appear at
     * @return the adjusted price of the item
     */
    public double getAdjustedPrice(Planet planet) {
        TechLevel techLevel = planet.getPlanetTechLevel();
        Resource resource = planet.getPlanetResource();
        return basePrice * this.getTechLevelValueModifier(techLevel) * this.getResourceValueModifier(resource);
    }

}
