package edu.gatech.cs2340.spacetrader.model;

public class Player {
    private String username;
    private int engineer_point;
    private int fighter_point;
    private int pilot_point;
    private int trader_point;
    private int skill_point;
    private int credit;
    private Ship ship;

    public Player() {
        this.username = "Default";
        this.engineer_point = 0;
        this.fighter_point = 0;
        this.pilot_point = 0;
        this.trader_point = 0;
        this.skill_point = 16;
        this.credit = 1000;
        this.ship = new Ship();
    }

    public Player(String username, int engineer_point, int fighter_point, int pilot_point, int trader_point, int skill_point){
        this.username = username;
        this.engineer_point = engineer_point;
        this.fighter_point = fighter_point;
        this.pilot_point = pilot_point;
        this.trader_point = trader_point;
        this.skill_point = skill_point;
        this.credit = 1000;
        this.ship = new Ship();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getEngineer_point() {
        return engineer_point;
    }

    public void setEngineer_point(int engineer_point) {
        this.engineer_point = engineer_point;
    }

    public int getFighter_point() {
        return fighter_point;
    }

    public void setFighter_point(int fighter_point) {
        this.fighter_point = fighter_point;
    }

    public int getPilot_point() {
        return pilot_point;
    }

    public void setPilot_point(int pilot_point) {
        this.pilot_point = pilot_point;
    }

    public int getTrader_point() {
        return trader_point;
    }

    public void setTrader_point(int trader_point) {
        this.trader_point = trader_point;
    }

    public int getSkill_point() {
        return skill_point;
    }

    public void setSkill_point(int skill_point) {
        this.skill_point = skill_point;
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
}
