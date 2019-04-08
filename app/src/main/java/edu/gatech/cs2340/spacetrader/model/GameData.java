package edu.gatech.cs2340.spacetrader.model;

import java.io.Serializable;

public class GameData implements Serializable {
    private Player player;
    private Universe universe;

    private static GameData INSTANCE = null;

    private GameData(Player player, Universe universe) {
        this.player = player;
        this.universe = universe;
    }

    public static GameData getInstance() {
        if (INSTANCE == null) throw new RuntimeException("GameData not yet instantiated!");
        return INSTANCE;
    }

    public static GameData instantiateGameData(Player player, Universe universe) {
        if (INSTANCE != null) throw new RuntimeException("GameData already instantiated!");
        INSTANCE = new GameData(player, universe);
        return INSTANCE;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Universe getUniverse() {
        return universe;
    }

    public void setUniverse(Universe universe) {
        this.universe = universe;
    }
}
