package edu.gatech.cs2340.spacetrader.model;

import java.io.Serializable;
import java.util.Random;

/**
 * Class that represents the store
 */
public class Store implements Serializable {

    private String storeName;
    private TradeOffer[] tradeOffers;

    /**
     * Constructor for the class
     * @param storeName the name of the store
     * @param tradeOffers the possible trades made at the store
     */
    public Store(String storeName, TradeOffer[] tradeOffers) {
        this.storeName = storeName;
        this.tradeOffers = tradeOffers.clone();
    }

    /**
     * Buys the item from the store
     * @param offerIndex the index of the item being bought
     * @param quantity the amount of the item being bought
     * @return the total price of the transaction
     */
    public int sellOffer(int offerIndex, int quantity) {
        if (offerIndex > tradeOffers.length) {
            throw new RuntimeException("TradeOffer index does not exist");
        }

        if (tradeOffers[offerIndex].getItemQuantity() < quantity) {
            throw new RuntimeException("TradeOffer does not have enough quantity to sell");
        }

        int currentQuantity = tradeOffers[offerIndex].getItemQuantity();
        tradeOffers[offerIndex].setItemQuantity(currentQuantity - quantity);

        return quantity * tradeOffers[offerIndex].getItemPrice();

    }

    /**
     * Sells the item from the store
     * @param offerIndex the index of the item being sold
     * @param quantity the amount of the item being sold
     * @return the total price of the transaction
     */
    public int buyOffer(int offerIndex, int quantity) {
        if (offerIndex > tradeOffers.length) {
            throw new RuntimeException("TradeOffer index does not exist");
        }

        int currentQuantity = tradeOffers[offerIndex].getItemQuantity();
        tradeOffers[offerIndex].setItemQuantity(currentQuantity + quantity);

        return quantity * tradeOffers[offerIndex].getItemPrice();

    }

    /**
     * Buys fuel from the store
     * @param quantity the amount of fuel bought
     * @return the price of the fuel
     */
    public int buyFuel(int quantity) {
        return 10 * quantity;
    }

    private static final double STORE_UPDATE_MULTIPLIER = 2.27;

    /**
     * Restocks the store after the player has left
     */
    public void updateStore() {
        Random rand = new Random();

        for (TradeOffer tradeOffer : tradeOffers) {

            //expected value of about 1
            double x = (4 * rand.nextDouble()) - 2;
            double multiplier = STORE_UPDATE_MULTIPLIER * Math.pow(Math.E, -1 * Math.pow(x, 2));

            if (tradeOffer.getItemQuantity() > tradeOffer.getDefaultQuantity()) {
                tradeOffer.setItemQuantity((int) (tradeOffer.getItemQuantity() * multiplier));
            } else {
                tradeOffer.setItemQuantity((int) (tradeOffer.getDefaultQuantity() * multiplier));
            }

        }

    }

    /**
     * Gets storeName.
     *
     * @return Value of storeName.
     */
    public String getStoreName() {
        return storeName;
    }

    /**
     * Sets new tradeOffers.
     *
     * @param tradeOffers New value of tradeOffers.
     */
    public void setTradeOffers(TradeOffer[] tradeOffers) {
        this.tradeOffers = tradeOffers.clone();
    }

    /**
     * Sets new storeName.
     *
     * @param storeName New value of storeName.
     */
    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    /**
     * Gets tradeOffers.
     *
     * @return Value of tradeOffers.
     */
    public TradeOffer[] getTradeOffers() {
        return tradeOffers.clone();
    }
}
