package edu.gatech.cs2340.spacetrader.viewmodel;

import edu.gatech.cs2340.spacetrader.model.Player;
import edu.gatech.cs2340.spacetrader.model.Store;
import edu.gatech.cs2340.spacetrader.model.TradeOffer;

public class StoreViewModel {

    private final Player player;
    private final Store store;

    public StoreViewModel(Store store, Player player) {
        this.store = store;
        this.player = player;
    }

    public StoreViewModel(Store store) {
        this(store, Player.getInstance());
    }

    public StoreViewModel() {
        this(Player.getInstance().getCurrentPlanet().getStore());
    }

    public int getAvailableCargo() {
        return player.getShip().getShipType().getCargoSize() - player.getShip().getCurrentCargo();
    }

    public int getMaxCargo() {
        return player.getShip().getShipType().getCargoSize();
    }

    public int getCredits() {
        return player.getCredits();
    }

    public String getStoreName() {
        return store.getStoreName();
    }

    public Store getStore() {
        return store;
    }

    public int getOwnedItem(String itemName) {
        if (player.getShip().getCargo().containsKey(itemName))
            return player.getShip().getCargo().get(itemName);
        return 0;
    }

    // BUYS FROM THE STORE
    public void buyItem(TradeOffer offer, int quantity) {
        if (offer.getItemQuantity() >= quantity &&
                player.getShip().getAvailableCargoSpace() >= quantity &&
                player.getCredits() > (quantity * offer.getItemPrice())) {
            player.getShip().addCargo(offer.getItemName(), quantity);
            offer.setItemQuantity(offer.getItemQuantity() - quantity);
            player.addCredits(-quantity * offer.getItemPrice());
        }
    }

    // SELLS TO THE STORE
    public void sellItem(TradeOffer offer, int quantity) {
        if (player.getShip().getCargo(offer.getItemName()) >= quantity) {
            player.getShip().removeCargo(offer.getItemName(), quantity);
            offer.setItemQuantity(offer.getItemQuantity() + quantity);
            player.addCredits(quantity * offer.getItemPrice());
        }
    }
}
