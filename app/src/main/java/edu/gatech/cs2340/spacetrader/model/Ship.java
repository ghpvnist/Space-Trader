package edu.gatech.cs2340.spacetrader.model;

import android.util.Log;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Class that represents the player's ship
 */
public class Ship implements Serializable {
    private ShipType shipType;
    private Map<String, Integer> cargo;
    private int currentFuel;
    private int currentHealth;
    private int currentCargo;


    /**
     * Contructor for the ship
     */
    public Ship() {
        this.shipType = shipType.GNAT;
        this.currentFuel = shipType.getMaxFuel();
        this.currentHealth = shipType.getMaxHealth();
        this.cargo = new HashMap<String, Integer>();
        this.currentCargo = 0;

        this.addCargo("Wood Log", 10);
        this.addCargo("Apple", 10);
        this.addCargo("Machine Parts", 10);
//        Log.d("SHIP", "Ship constructor called!");
//        Log.d("SHIP", "Current cargo amount is " + this.getCurrentCargo());
    }

    /**
     * Calculates the remaining cargo space in the ship
     * @return the remaining cargo space
     */
    public int getAvailableCargoSpace() {
        return shipType.getCargoSize() - getCurrentCargo();
    }

    /**
     * Gets the item within the cargo with the given name
     * @param itemName the name we are searching for
     * @return the item within the cargo
     */
    public int getCargo(String itemName) {
        if (cargo.containsKey(itemName)) {
            return cargo.get(itemName);
        }
        return 0;
    }

    /**
     * Adds the given items to the cargo
     * @param itemName the name of the item being added
     * @param quantity the quantity of the item being added
     */
    public void addCargo(String itemName, int quantity) {

        if (currentCargo + quantity > this.shipType.getCargoSize()) {
            throw new RuntimeException("Not enough room for adding cargo");
        }

        currentCargo += quantity;
        if (this.cargo.containsKey(itemName)) {
            this.cargo.put(itemName, this.cargo.get(itemName) + quantity);
        } else {
            this.cargo.put(itemName, quantity);
        }
    }

    /**
     * Removes the given items from the cargo
     * @param itemName the name of the item being removed
     * @param quantity the quantity of the item being removed
     */
    public void removeCargo(String itemName, int quantity) {

        if (!this.cargo.containsKey(itemName)) {
            throw new RuntimeException("No such cargo itemName to remove");
        } else {
            int curQuantity = this.cargo.get(itemName);
            if (quantity > curQuantity) {
                throw new RuntimeException("Not enough cargo of this type to remove!");
            }

            currentCargo -= quantity;
            if (quantity == curQuantity) {
                this.cargo.remove(itemName);
            } else {
                this.cargo.put(itemName, curQuantity - quantity);
            }
        }
    }

    public void clearCargo() {
        this.setCargo(new HashMap<String, Integer>());
        this.currentCargo = 0;
    }

    /**
     * Gets the selling price of the item
     * @return the selling price of the item
     */
    public int getSellPrice() {

        return (int) this.shipType.getCost() * currentHealth / this.shipType.getMaxHealth();

    }

    /**
     * Gets shipType.
     *
     * @return Value of shipType.
     */
    public ShipType getShipType() {
        return shipType;
    }

    /**
     * Gets cargo.
     *
     * @return Value of cargo.
     */
    public Map<String, Integer> getCargo() {
        return cargo;
    }

    /**
     * Sets new currentHealth.
     *
     * @param currentHealth New value of currentHealth.
     */
    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    /**
     * Sets new currentFuel.
     *
     * @param currentFuel New value of currentFuel.
     */
    public void setCurrentFuel(int currentFuel) {
        this.currentFuel = currentFuel;
    }

    /**
     * Gets currentHealth.
     *
     * @return Value of currentHealth.
     */
    public int getCurrentHealth() {
        return currentHealth;
    }

    /**
     * Gets currentCargo.
     *
     * @return Value of currentCargo.
     */
    public int getCurrentCargo() {
        return currentCargo;
    }

    /**
     * Sets new currentCargo.
     *
     * @param currentCargo New value of currentCargo.
     */
    public void setCurrentCargo(int currentCargo) {
        this.currentCargo = currentCargo;
    }

    /**
     * Sets new cargo.
     *
     * @param cargo New value of cargo.
     */
    public void setCargo(Map<String, Integer> cargo) {
        this.cargo = cargo;
    }

    /**
     * Gets currentFuel.
     *
     * @return Value of currentFuel.
     */
    public int getCurrentFuel() {
        return currentFuel;
    }

    /**
     * Sets new shipType.
     *
     * @param shipType New value of shipType.
     */
    public void setShipType(ShipType shipType) {
        this.shipType = shipType;
    }
}
