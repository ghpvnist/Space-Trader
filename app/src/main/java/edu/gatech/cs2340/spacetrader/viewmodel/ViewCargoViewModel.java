package edu.gatech.cs2340.spacetrader.viewmodel;

import edu.gatech.cs2340.spacetrader.model.GameData;
import edu.gatech.cs2340.spacetrader.model.Player;

public class ViewCargoViewModel {

    private GameData gameData;

    public ViewCargoViewModel() {

        this.gameData = GameData.getInstance();
    }

    public int getAvailableCargoSpace() {
        return getMaxCargoSpace() - this.gameData.getPlayer().getShip().getCurrentCargo();
    }

    public int getMaxCargoSpace() {
        return this.gameData.getPlayer().getShip().getShipType().getCargoSize();
    }
}
