package edu.gatech.cs2340.spacetrader.model;

import android.app.ActivityManager;

import java.util.HashMap;
import java.util.Map;

import edu.gatech.cs2340.spacetrader.entity.ShipType;

public class Ship {
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

    public void addCargo(String itemName, int quantity){

        if(currentCargo + quantity > this.shipType.getCargoSize()){
            throw new RuntimeException("Not enough room for adding cargo");
        }

        if(this.cargo.containsKey(itemName)){
            this.cargo.put(itemName, this.cargo.get(itemName) + quantity);
        } else {
            this.cargo.put(itemName, quantity);
        }

    }

    public void removeCargo(String itemName, int quantity){

        if(!this.cargo.containsKey(itemName)) {
            throw new RuntimeException("No such cargo itemName to remove");
        } else {
            int curQuantity = this.cargo.get(itemName);
            if (quantity > curQuantity) {
                throw new RuntimeException("Not enough cargo of this type to remove!");
            }
            if (quantity == curQuantity) {
                this.cargo.remove(itemName);
            } else {
                this.cargo.put(itemName, curQuantity - quantity);
            }
        }
    }

    public int getSellPrice(){

        return (int) this.shipType.getCost() * currentHealth / this.shipType.getMaxHealth();

    }

}
