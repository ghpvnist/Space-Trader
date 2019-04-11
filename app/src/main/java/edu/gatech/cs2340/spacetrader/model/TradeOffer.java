package edu.gatech.cs2340.spacetrader.model;

import java.io.Serializable;

/**
 * Class that represents offers of items that can be sold or bought
 */
public class TradeOffer implements Serializable {

    private final String itemId;
    private String itemName;
    private int itemPrice;
    private int itemQuantity;
    private final int defaultQuantity;

    /**
     * Constructor for the class
     * @param itemName the name of the item offered
     * @param itemId the id of the item offered
     * @param itemPrice the price of the item offered
     * @param itemQuantity the quantity of the item offered
     */
    public TradeOffer(String itemName, String itemId, int itemPrice, int itemQuantity) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.itemPrice = itemPrice;
        this.itemQuantity = itemQuantity;
        this.defaultQuantity = itemQuantity;
    }

    /**
     * Sets new itemName.
     *
     * @param itemName New value of itemName.
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * Gets itemQuantity.
     *
     * @return Value of itemQuantity.
     */
    public int getItemQuantity() {
        return itemQuantity;
    }

    /**
     * Gets itemId.
     *
     * @return Value of itemId.
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * Gets defaultQuantity.
     *
     * @return Value of defaultQuantity.
     */
    public int getDefaultQuantity() {
        return defaultQuantity;
    }

    /**
     * Sets new itemQuantity.
     *
     * @param itemQuantity New value of itemQuantity.
     */
    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    /**
     * Gets itemPrice.
     *
     * @return Value of itemPrice.
     */
    public int getItemPrice() {
        return itemPrice;
    }

    /**
     * Sets new itemPrice.
     *
     * @param itemPrice New value of itemPrice.
     */
    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    /**
     * Gets itemName.
     *
     * @return Value of itemName.
     */
    public String getItemName() {
        return itemName;
    }
}
