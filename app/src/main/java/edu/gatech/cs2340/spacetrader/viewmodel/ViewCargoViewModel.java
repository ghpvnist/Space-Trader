package edu.gatech.cs2340.spacetrader.viewmodel;

import edu.gatech.cs2340.spacetrader.model.GameData;

/**
 * ViewModel for the CargoViewActivity class
 */
public class ViewCargoViewModel {

    private final GameData gameData;

    /**
     * Constructor for the class
     */
    public ViewCargoViewModel() {

        this.gameData = GameData.getInstance();
    }

    /**
     * Gets the available cargo space in the player's ship
     * @return the available cargo space
     */
    public int getAvailableCargoSpace() {
        return getMaxCargoSpace() - this.gameData.getPlayer().getShip().getCurrentCargo();
    }

    /**
     * Gets the maximum cargo space in the player's ship
     * @return the maximum cargo space in the player's ship
     */
    public int getMaxCargoSpace() {
        return this.gameData.getPlayer().getShip().getShipType().getCargoSize();
    }
}
