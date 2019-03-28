package edu.gatech.cs2340.spacetrader.model;

public class Player {
    private String playerName;
    private int engineerSkillPoints;
    private int fighterSkillPoints;
    private int pilotSkillPoints;
    private int traderSkillPoints;
    private int remainingSkillPoints;
    private int credits;
    private Ship ship;
    private Planet currentPlanet;

    private static Player INSTANCE = null;

    private Player(String playerName, int engineerSkillPoints, int fighterSkillPoints,
                   int pilotSkillPoints, int traderSkillPoints, int freeSkillPoints,
                   int credits, Ship ship){
        this.playerName = playerName;
        this.engineerSkillPoints = engineerSkillPoints;
        this.fighterSkillPoints = fighterSkillPoints;
        this.pilotSkillPoints = pilotSkillPoints;
        this.traderSkillPoints = traderSkillPoints;
        this.remainingSkillPoints = freeSkillPoints;
        this.credits = credits;
        this.ship = ship;
    }

    public static Player getInstance() {
        if (INSTANCE == null) throw new RuntimeException("Player not yet instantiated!");
        return INSTANCE;
    }

    public static Player instantiatePlayer(String playerName, int engineerSkillPoints,
                                           int fighterSkillPoints, int pilotSkillPoints,
                                           int traderSkillPoints, int freeSkillPoints,
                                           int credits, Ship ship) {
        if (INSTANCE != null) throw new RuntimeException("Player already instantiated!");
        INSTANCE = new Player(playerName, engineerSkillPoints, fighterSkillPoints,
                pilotSkillPoints, traderSkillPoints, freeSkillPoints, credits, ship);
        return INSTANCE;
    }

    public static Player instantiatePlayer() {
        return instantiatePlayer("Han", 0, 0, 0, 0, 16, 1000, new Ship());
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getEngineerSkillPoints() {
        return engineerSkillPoints;
    }

    public int getFighterSkillPoints() {
        return fighterSkillPoints;
    }

    public int getPilotSkillPoints() {
        return pilotSkillPoints;
    }

    public int getTraderSkillPoints() {
        return traderSkillPoints;
    }

    public void addEngineerSkillPoint() {
        if (this.remainingSkillPoints == 0) {
            throw new RuntimeException("No remaining skill points!");
        }
        engineerSkillPoints++;
        remainingSkillPoints--;
    }

    public void addFighterSkillPoint() {
        if (this.remainingSkillPoints == 0) {
            throw new RuntimeException("No remaining skill points!");
        }
        fighterSkillPoints++;
        remainingSkillPoints--;
    }

    public void addPilotSkillPoint() {
        if (this.remainingSkillPoints == 0) {
            throw new RuntimeException("No remaining skill points!");
        }
        pilotSkillPoints++;
        remainingSkillPoints--;
    }

    public void addTraderSkillPoint() {
        if (this.remainingSkillPoints == 0) {
            throw new RuntimeException("No remaining skill points!");
        }
        traderSkillPoints++;
        remainingSkillPoints--;
    }

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

    public int getRemainingSkillPoints() {
        return remainingSkillPoints;
    }

    public void addSkillPoints(int additionalPoints) {
        remainingSkillPoints += additionalPoints;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public Planet getCurrentPlanet() {
        return currentPlanet;
    }

    public void setCurrentPlanet(Planet currentPlanet) {
        this.currentPlanet = currentPlanet;
    }

    public void addCredits(int credits) {
        setCredits(getCredits() + credits);
    }
}
