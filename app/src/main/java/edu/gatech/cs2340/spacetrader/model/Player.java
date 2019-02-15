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
        this.username = username;
        this.pilot_point = 0;
        this.engineer_point = 0;
        this.fighter_point = 0;
        this.trader_point = 0;
        this.skill_point = 16;
        this.credit = 1000;
        this.ship = new Ship();
    }

}
