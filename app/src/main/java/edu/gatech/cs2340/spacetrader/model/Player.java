package edu.gatech.cs2340.spacetrader.model;

public class Player {
    private String username;
    private int engineerPoint;
    private int fighterPoint;
    private int pilotPoint;
    private int traderPoint;
    private int skillPoint;
    private int credit;
    private Ship ship;
    private Planet currentPlanet;

    public Player() {
        this.username = "Default";
        this.engineerPoint = 0;
        this.fighterPoint = 0;
        this.pilotPoint = 0;
        this.traderPoint = 0;
        this.skillPoint = 16;
        this.credit = 1000;
        this.ship = new Ship();
    }

    public Player(String username, int engineerPoint, int fighterPoint, int pilotPoint, int traderPoint, int skillPoint){
        this.username = username;
        this.engineerPoint = engineerPoint;
        this.fighterPoint = fighterPoint;
        this.pilotPoint = pilotPoint;
        this.traderPoint = traderPoint;
        this.skillPoint = skillPoint;
        this.credit = 1000;
        this.ship = new Ship();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getEngineerPoint() {
        return engineerPoint;
    }

    public void setEngineerPoint(int engineerPoint) {
        this.engineerPoint = engineerPoint;
    }

    public int getFighterPoint() {
        return fighterPoint;
    }

    public void setFighterPoint(int fighterPoint) {
        this.fighterPoint = fighterPoint;
    }

    public int getPilotPoint() {
        return pilotPoint;
    }

    public void setPilotPoint(int pilotPoint) {
        this.pilotPoint = pilotPoint;
    }

    public int getTraderPoint() {
        return traderPoint;
    }

    public void setTraderPoint(int traderPoint) {
        this.traderPoint = traderPoint;
    }

    public int getSkillPoint() {
        return skillPoint;
    }

    public void setSkillPoint(int skillPoint) {
        this.skillPoint = skillPoint;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
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
}
