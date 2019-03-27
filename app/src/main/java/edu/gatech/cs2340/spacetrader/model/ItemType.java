package edu.gatech.cs2340.spacetrader.model;

import java.util.Map;

import edu.gatech.cs2340.spacetrader.entity.Resource;
import edu.gatech.cs2340.spacetrader.entity.TechLevel;

public class ItemType {

    private String name;
    private double basePrice;
    private Map<Resource, Double> resourceValueModifiers;
    private Map<TechLevel, Double> techLevelValueModifiers;

    public ItemType(String name, double basePrice, Map<Resource, Double> resourceValueModifiers, Map<TechLevel, Double> techLevelValueModifiers) {
        this.name = name;
        this.basePrice = basePrice;
        this.resourceValueModifiers = resourceValueModifiers;
        this.techLevelValueModifiers = techLevelValueModifiers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public Map<Resource, Double> getResourceValueModifiers() {
        return resourceValueModifiers;
    }

    public void setResourceValueModifiers(Map<Resource, Double> resourceValueModifiers) {
        this.resourceValueModifiers = resourceValueModifiers;
    }

    public Map<TechLevel, Double> getTechLevelValueModifiers() {
        return techLevelValueModifiers;
    }

    public void setTechLevelValueModifiers(Map<TechLevel, Double> techLevelValueModifiers) {
        this.techLevelValueModifiers = techLevelValueModifiers;
    }

    public double getAdjustedQuantity(Planet planet){
        double techLevelModifier = this.techLevelValueModifiers.get(planet.getPlanetTechLevel());
        double resourceModifier = this.resourceValueModifiers.get(planet.getPlanetResource());

        if(techLevelModifier == 0 || resourceModifier == 0){
            return 0;
        }

        return  100/(techLevelModifier * resourceModifier);
    }

    public double getAdjustedPrice(Planet planet){
        TechLevel techLevel = planet.getPlanetTechLevel();
        Resource resource = planet.getPlanetResource();
        return basePrice * this.techLevelValueModifiers.get(techLevel) * this.resourceValueModifiers.get(resource);
    }

}
