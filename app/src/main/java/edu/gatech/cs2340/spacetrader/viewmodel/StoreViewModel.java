package edu.gatech.cs2340.spacetrader.viewmodel;

import edu.gatech.cs2340.spacetrader.model.GameData;
import edu.gatech.cs2340.spacetrader.model.Player;
import edu.gatech.cs2340.spacetrader.model.Store;
import edu.gatech.cs2340.spacetrader.model.TradeOffer;

/**
 * ViewModel for the StoreView
 */
public class StoreViewModel {

    private final GameData gameData;
    private final Store store;

    /**
     * Constructor for the class
     * @param store the store that we are accessing
     * @param gameData the gameData of the current game
     */
    public StoreViewModel(Store store, GameData gameData) {
        this.store = store;
        this.gameData = gameData;
    }

    /**
     * Constructor for the class
     * @param store the store that we are accessing
     */
    public StoreViewModel(Store store) {
        this(store, GameData.getInstance());
    }

    /**
     * Constructor for the class
     */
    public StoreViewModel() {
        this(GameData.getInstance().getPlayer().getCurrentPlanet().getStore());
    }

    /**
     * Gets the amount of cargo the player has available
     * @return the amount of cargo the player has available
     */
    public int getAvailableCargo() {
        return this.gameData.getPlayer().getShip().getShipType().getCargoSize() - this.gameData.getPlayer().getShip().getCurrentCargo();
    }

    /**
     * Gets the maximum amount of cargo the player can have
     * @return the maximum amount of cargo the player can have
     */
    public int getMaxCargo() {
        return this.gameData.getPlayer().getShip().getShipType().getCargoSize();
    }

    /**
     * Gets the amount of credits of the player
     * @return the player's credits
     */
    public int getCredits() {
        return this.gameData.getPlayer().getCredits();
    }

    /**
     * Gets the name of the current store
     * @return the name of the current store
     */
    public String getStoreName() {
        return store.getStoreName();
    }

    /**
     * Gets the current store
     * @return the current store
     */
    public Store getStore() {
        return store;
    }

    /**
     * Gets the quantity of the given item in the player's inventory
     * @param itemName the item name we are searching for
     * @return the quantity of the item in the inventory
     */
    public int getOwnedItem(String itemName) {
        if (this.gameData.getPlayer().getShip().getCargo().containsKey(itemName))
            return this.gameData.getPlayer().getShip().getCargo().get(itemName);
        return 0;
    }

    /**
     * Buys the given quantity of the item from the store
     * @param offer the tradeOffer we are buying from
     * @param quantity the quantity bought
     */
    public void buyItem(TradeOffer offer, int quantity) {
        if (offer.getItemQuantity() >= quantity &&
                this.gameData.getPlayer().getShip().getAvailableCargoSpace() >= quantity &&
                this.gameData.getPlayer().getCredits() > (quantity * offer.getItemPrice())) {
            this.gameData.getPlayer().getShip().addCargo(offer.getItemName(), quantity);
            offer.setItemQuantity(offer.getItemQuantity() - quantity);
            this.gameData.getPlayer().addCredits(-quantity * offer.getItemPrice());
        }
    }

    /**
     * Sells the given quantity of the item to the store
     * @param offer the tradeOffer we are selling to
     * @param quantity the quantity sold
     */
    public void sellItem(TradeOffer offer, int quantity) {
        if (this.gameData.getPlayer().getShip().getCargo(offer.getItemName()) >= quantity) {
            this.gameData.getPlayer().getShip().removeCargo(offer.getItemName(), quantity);
            offer.setItemQuantity(offer.getItemQuantity() + quantity);
            this.gameData.getPlayer().addCredits(quantity * offer.getItemPrice());
        }
    }
}
