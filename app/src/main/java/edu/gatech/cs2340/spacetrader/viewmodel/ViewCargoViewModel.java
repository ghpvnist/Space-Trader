package edu.gatech.cs2340.spacetrader.viewmodel;

import edu.gatech.cs2340.spacetrader.model.Player;

public class ViewCargoViewModel {

    private Player player;

    public ViewCargoViewModel() {
        player = Player.getInstance();
    }

    public int getAvailableCargoSpace() {
        return getMaxCargoSpace() - player.getShip().getCurrentCargo();
    }

    public int getMaxCargoSpace() {
        return player.getShip().getShipType().getCargoSize();
    }
}
