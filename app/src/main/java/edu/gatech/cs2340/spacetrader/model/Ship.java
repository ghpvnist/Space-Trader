package edu.gatech.cs2340.spacetrader.model;

import edu.gatech.cs2340.spacetrader.entity.ShipType;

public class Ship {
    private ShipType shipType;
    private boolean strongHull;
    private int cargoCapacity;
    private int weaponSlots;
    private int gadgets;
    private int parsecs;
    private int shieldSlot;

    public Ship() {
        this.shipType = shipType.GNAT;
    }

}
