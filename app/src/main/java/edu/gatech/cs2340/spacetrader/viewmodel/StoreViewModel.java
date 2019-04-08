package edu.gatech.cs2340.spacetrader.viewmodel;

import edu.gatech.cs2340.spacetrader.model.GameData;
import edu.gatech.cs2340.spacetrader.model.Player;
import edu.gatech.cs2340.spacetrader.model.Store;
import edu.gatech.cs2340.spacetrader.model.TradeOffer;

public class StoreViewModel {

    private final GameData gameData;
    private final Store store;

    public StoreViewModel(Store store, GameData gameData) {
        this.store = store;
        this.gameData = gameData;
    }

    public StoreViewModel(Store store) {
        this(store, GameData.getInstance());
    }

    public StoreViewModel() {
        this(GameData.getInstance().getPlayer().getCurrentPlanet().getStore());
    }

    public int getAvailableCargo() {
        return this.gameData.getPlayer().getShip().getShipType().getCargoSize() - this.gameData.getPlayer().getShip().getCurrentCargo();
    }

    public int getMaxCargo() {
        return this.gameData.getPlayer().getShip().getShipType().getCargoSize();
    }

    public int getCredits() {
        return this.gameData.getPlayer().getCredits();
    }

    public String getStoreName() {
        return store.getStoreName();
    }

    public Store getStore() {
        return store;
    }

    public int getOwnedItem(String itemName) {
        if (this.gameData.getPlayer().getShip().getCargo().containsKey(itemName))
            return this.gameData.getPlayer().getShip().getCargo().get(itemName);
        return 0;
    }

    // BUYS FROM THE STORE
    public void buyItem(TradeOffer offer, int quantity) {
        if (offer.getItemQuantity() >= quantity &&
                this.gameData.getPlayer().getShip().getAvailableCargoSpace() >= quantity &&
                this.gameData.getPlayer().getCredits() > (quantity * offer.getItemPrice())) {
            this.gameData.getPlayer().getShip().addCargo(offer.getItemName(), quantity);
            offer.setItemQuantity(offer.getItemQuantity() - quantity);
            this.gameData.getPlayer().addCredits(-quantity * offer.getItemPrice());
        }
    }

    // SELLS TO THE STORE
    public void sellItem(TradeOffer offer, int quantity) {
        if (this.gameData.getPlayer().getShip().getCargo(offer.getItemName()) >= quantity) {
            this.gameData.getPlayer().getShip().removeCargo(offer.getItemName(), quantity);
            offer.setItemQuantity(offer.getItemQuantity() + quantity);
            this.gameData.getPlayer().addCredits(quantity * offer.getItemPrice());
        }
    }
}
