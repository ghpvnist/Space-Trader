package edu.gatech.cs2340.spacetrader.model;

import java.io.Serializable;

/**
 * Enumerates possible types of ship
 */
public enum ShipType implements Serializable {
    FLEA(100, 100, 100, 100, 100, 100),
    GNAT(100, 100, 100, 100, 100, 100),
    FIREFLY(100, 100, 100, 100, 100, 100),
    MOSQUITO(100, 100, 100, 100, 100, 100),
    BUMBLEBEE(100, 100, 100, 100, 100, 100),
    BEETLE(100, 100, 100, 100, 100, 100),
    HORNET(100, 100, 100, 100, 100, 100),
    GRASSHOPPER(100, 100, 100, 100, 100, 100),
    TERMITE(100, 100, 100, 100, 100, 100),
    WASP(100, 100, 100, 100, 100, 100);

    private final int attackPower;
    private final int cargoSize;
    private final int speed;
    private final int maxHealth;
    private final int maxFuel;
    private final int cost;

    private ShipType(int attackPower, int cargoSize, int speed, int maxHealth, int maxFuel, int cost) {
        this.attackPower = attackPower;
        this.cargoSize = cargoSize;
        this.speed = speed;
        this.maxHealth = maxHealth;
        this.maxFuel = maxFuel;
        this.cost = cost;
    }


    /**
     * Gets cost.
     *
     * @return Value of cost.
     */
    public int getCost() {
        return cost;
    }

    /**
     * Gets maxFuel.
     *
     * @return Value of maxFuel.
     */
    public int getMaxFuel() {
        return maxFuel;
    }

    /**
     * Gets speed.
     *
     * @return Value of speed.
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Gets attackPower.
     *
     * @return Value of attackPower.
     */
    public int getAttackPower() {
        return attackPower;
    }

    /**
     * Gets maxHealth.
     *
     * @return Value of maxHealth.
     */
    public int getMaxHealth() {
        return maxHealth;
    }

    /**
     * Gets cargoSize.
     *
     * @return Value of cargoSize.
     */
    public int getCargoSize() {
        return cargoSize;
    }
}