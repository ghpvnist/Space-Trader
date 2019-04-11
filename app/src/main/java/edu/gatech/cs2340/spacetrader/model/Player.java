package edu.gatech.cs2340.spacetrader.model;

import java.io.Serializable;

/**
 * Class that represents the user's character
 */
public class Player implements Serializable {
    private String playerName;
    private int engineerSkillPoints;
    private int fighterSkillPoints;
    private int pilotSkillPoints;
    private int traderSkillPoints;
    private int remainingSkillPoints;
    private int credits;
    private Ship ship;
    private Planet currentPlanet;

    /**
     * Constructor for the class
     */
    public Player() {

    }

    /**
     * Constructor for the class
     * @param playerName the player's name
     * @param engineerSkillPoints the player's engineering skill points
     * @param fighterSkillPoints the player's fighter skill points
     * @param pilotSkillPoints the player's pilot skill points
     * @param traderSkillPoints the player's trader skill points
     * @param freeSkillPoints the player's free skill points
     * @param credits the player's amount of credits
     * @param ship the player's ship
     */
    public Player(String playerName, int engineerSkillPoints, int fighterSkillPoints,
                   int pilotSkillPoints, int traderSkillPoints, int freeSkillPoints,
                   int credits, Ship ship) {
        this.playerName = playerName;
        this.engineerSkillPoints = engineerSkillPoints;
        this.fighterSkillPoints = fighterSkillPoints;
        this.pilotSkillPoints = pilotSkillPoints;
        this.traderSkillPoints = traderSkillPoints;
        this.remainingSkillPoints = freeSkillPoints;
        this.credits = credits;
        this.ship = ship;
    }

    /**
     * Getter for the playerName field
     * @return the playerName field
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * Setter for the playerName field
     * @param playerName the name to set to
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    /**
     * Getter for the engineerSkillPoints field
     * @return the engineerSkillPoints field
     */
    public int getEngineerSkillPoints() {
        return engineerSkillPoints;
    }

    /**
     * Getter for the fighterSkillPoints field
     * @return the fighterSkillPoints field
     */
    public int getFighterSkillPoints() {
        return fighterSkillPoints;
    }

    /**
     * Getter for the pilotSkillPoints field
     * @return the pilotSkillPoints field
     */
    public int getPilotSkillPoints() {
        return pilotSkillPoints;
    }

    /**
     * Getter for the traderSkillPoints field
     * @return the traderSkillPoints field
     */
    public int getTraderSkillPoints() {
        return traderSkillPoints;
    }

    /**
     * Adds skill points to the engineerSkillPoints field
     */
    public void addEngineerSkillPoint() {
        if (this.remainingSkillPoints == 0) {
            throw new RuntimeException("No remaining skill points!");
        }
        engineerSkillPoints++;
        remainingSkillPoints--;
    }

    /**
     * Adds skill points to the fighterSkillPoints field
     */
    public void addFighterSkillPoint() {
        if (this.remainingSkillPoints == 0) {
            throw new RuntimeException("No remaining skill points!");
        }
        fighterSkillPoints++;
        remainingSkillPoints--;
    }

    /**
     * Adds skill points to the pilotSkillPoints field
     */
    public void addPilotSkillPoint() {
        if (this.remainingSkillPoints == 0) {
            throw new RuntimeException("No remaining skill points!");
        }
        pilotSkillPoints++;
        remainingSkillPoints--;
    }

    /**
     * Adds skill points to the traderSkillPoints field
     */
    public void addTraderSkillPoint() {
        if (this.remainingSkillPoints == 0) {
            throw new RuntimeException("No remaining skill points!");
        }
        traderSkillPoints++;
        remainingSkillPoints--;
    }

    /**
     * Resets all skill point fields for the player
     */
    public void resetSkillPoints() {
        remainingSkillPoints += engineerSkillPoints;
        remainingSkillPoints += fighterSkillPoints;
        remainingSkillPoints += pilotSkillPoints;
        remainingSkillPoints += traderSkillPoints;
        engineerSkillPoints = 0;
        fighterSkillPoints = 0;
        pilotSkillPoints = 0;
        traderSkillPoints = 0;
    }

    /**
     * Getter for the remainingSkillPoints field
     * @return the remainingSkillPoints field
     */
    public int getRemainingSkillPoints() {
        return remainingSkillPoints;
    }

    /**
     * Gives the player additional skill points to assign
     * @param additionalPoints the number of points to assign
     */
    public void addSkillPoints(int additionalPoints) {
        remainingSkillPoints += additionalPoints;
    }

    /**
     * Getter for the credits field
     * @return the credits field
     */
    public int getCredits() {
        return credits;
    }

    /**
     * Setter for the credits field
     * @param credits the amount of credits to set to
     */
    public void setCredits(int credits) {
        this.credits = credits;
    }

    /**
     * Getter for the ship field
     * @return the ship field
     */
    public Ship getShip() {
        return ship;
    }

    /**
     * Setter for the ship field
     * @param ship the ship to set to
     */
    public void setShip(Ship ship) {
        this.ship = ship;
    }

    /**
     * Getter for the currentPlanet the player is at
     * @return the currentPlanet field
     */
    public Planet getCurrentPlanet() {
        return currentPlanet;
    }

    /**
     * Setter for the currentPlanet the player is at
     * @param currentPlanet the planet to set the field to
     */
    public void setCurrentPlanet(Planet currentPlanet) {
        this.currentPlanet = currentPlanet;
    }

    /**
     * Adds the given amount of credits to the player's inventory
     * @param credits the amount of credits to add
     */
    public void addCredits(int credits) {
        setCredits(getCredits() + credits);
    }

    /**
     * Sets all of the player's skill points at once
     * @param engineerSkillPoints the engineerSkillPoints of the player
     * @param fighterSkillPoints the fighterSkillPoints of the player
     * @param pilotSkillPoints the pilotSkillPoints of the player
     * @param traderSkillPoints the traderSkillPoints of the player
     * @param freeSkillPoints the freeSkillPoints of the player
     */
    public void setSkillPoints(int engineerSkillPoints, int fighterSkillPoints,
                   int pilotSkillPoints, int traderSkillPoints, int freeSkillPoints) {

        this.engineerSkillPoints = engineerSkillPoints;
        this.fighterSkillPoints = fighterSkillPoints;
        this.pilotSkillPoints = pilotSkillPoints;
        this.traderSkillPoints = traderSkillPoints;
        this.remainingSkillPoints = freeSkillPoints;

    }
}
