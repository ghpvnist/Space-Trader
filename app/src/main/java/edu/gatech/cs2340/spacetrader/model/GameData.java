package edu.gatech.cs2340.spacetrader.model;

import java.io.Serializable;

/**
 * Singleton class that contains all of the data for the game being played
 */
public class GameData {
    private Player player;
    private Universe universe;

    private static GameData INSTANCE = null;

    private GameData(Player player, Universe universe) {
        this.player = player;
        this.universe = universe;
    }

    public static void TEST_setInstance(Player player, Universe universe) {
        INSTANCE = new GameData(player, universe);
    }

    /**
     * Returns the singleton object for the class
     * @return INSTANCE the instance of the singleton class
     */
    public static GameData getInstance() {
        if (INSTANCE == null) throw new RuntimeException("GameData not yet instantiated!");
        return INSTANCE;
    }

    /**
     * Calls the private constructor to instantiate the singleton class
     * @param player the player that is playing the game
     * @param universe the current state of the universe in the game
     * @return the INSTANCE of the the newly instantiated singleton
     */
    public static GameData instantiateGameData(Player player, Universe universe) {
        if (INSTANCE != null) throw new RuntimeException("GameData already instantiated!");
        INSTANCE = new GameData(player, universe);
        return INSTANCE;
    }

    /**
     * Getter for the player field
     * @return the player field
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * The setter for the player field
     * @param player the player field
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * Getter for the universe field
     * @return the universe field
     */
    public Universe getUniverse() {
        return universe;
    }

    /**
     * The setter for the universe field
     * @param universe the universe field
     */
    public void setUniverse(Universe universe) {
        this.universe = universe;
    }
}
