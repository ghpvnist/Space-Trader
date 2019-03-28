package edu.gatech.cs2340.spacetrader.model;

import android.util.Log;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Ship implements Serializable {
    private ShipType shipType;
    private Map<String, Integer> cargo;
    private int currentFuel;
    private int currentHealth;
    private int currentCargo;

    public Ship() {
        this.shipType = shipType.GNAT;
        this.currentFuel = shipType.GNAT.getMaxFuel();
        this.currentHealth = shipType.GNAT.getMaxHealth();
        this.cargo = new HashMap<String, Integer>();
        this.currentCargo = 0;

        this.addCargo("Wood Log", 15);
        this.addCargo("Patrick", 1);
        this.addCargo("Apple", 8);
        this.addCargo("Machine Parts", 3);
        Log.d("SHIP", "Ship constructor called!");
        Log.d("SHIP", "Current cargo amount is " + this.getCurrentCargo());
    }

    public ShipType getShipType() {
        return shipType;
    }

    public void setShipType(ShipType shipType) {
        this.shipType = shipType;
    }

    public Map<String, Integer> getCargo() {
        return cargo;
    }

    public void setCargo(Map<String, Integer> cargo) {
        this.cargo = cargo;
    }

    public int getCurrentFuel() {
        return currentFuel;
    }

    public void setCurrentFuel(int currentFuel) {
        this.currentFuel = currentFuel;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getCurrentCargo() {
        return currentCargo;
    }

    public int getAvailableCargoSpace() {
        return shipType.getCargoSize() - getCurrentCargo();
    }

    public int getCargo(String itemName) {
        if (cargo.containsKey(itemName)) {
            return cargo.get(itemName);
        }
        return 0;
    }

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

    public int getSellPrice() {

        return (int) this.shipType.getCost() * currentHealth / this.shipType.getMaxHealth();

    }

}
