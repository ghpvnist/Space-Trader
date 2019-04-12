package edu.gatech.cs2340.spacetrader.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Class that represents the planets that can be traveled to
 */
public class Planet implements Serializable {

    private String name;
    private TechLevel planetTechLevel;
    private Resource planetResource;
    private Store store;
    private int x;
    private int y;
    //private Shipyard shipyard;

    private static final int MAX_STORE_ITEM_QUANTITY = 14;

    /**
     * Constructor for the class
     * @param name the name of the planet
     * @param x the x location of the planet
     * @param y the y location of the planet
     * @param resource the resource level of the planet
     * @param techLevel the tech level of the planet
     */
    public Planet(String name, int x, int y, Resource resource, TechLevel techLevel) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.planetResource = resource;
        this.planetTechLevel = techLevel;

        ItemManager im = ItemManager.getItemManager();
        List<ItemType> validItems = Arrays.asList(im.getItemList());
        Collections.shuffle(validItems);

        TradeOffer[] tradeOffers = new TradeOffer[3 + ItemManager.getRNG().nextInt(3)];
        for (int i = 0; i < tradeOffers.length; i++) {
            tradeOffers[i] = new TradeOffer(validItems.get(i).getName(), validItems.get(i).getItemId(),
                    (int)(getRandomAdjust() * validItems.get(i).getAdjustedPrice(this)),
                    (int) ((getRandomAdjust() * getRandomAdjust() * MAX_STORE_ITEM_QUANTITY) - 2));
        }

        this.store = new Store(generateRandomStoreName(), tradeOffers);
    }

    private static String generateRandomStoreName() {
        String[] firstPart = new String[] {"Bandhi's", "Kevin's", "Xatu's", "Slim's", "Wange's"};
        String[] secondPart = new String[] {"Cheap", "High Quality", "Knockoff", "Authentic", "Discount"};
        String[] thirdPart = new String[] {"Trinkets", "Items", "Goods", "Wares", "Memes", "Deets", "Shop"};
        return firstPart[ItemManager.getRNG().nextInt(firstPart.length)] + " "
                + secondPart[ItemManager.getRNG().nextInt(secondPart.length)] + " "
                + thirdPart[ItemManager.getRNG().nextInt(thirdPart.length)];
    }

    private static final double RANDOM_ADJUST_LOWER = 0.8;
    private static final double RANDOM_ADJUST_RANGE = 0.4;

    private double getRandomAdjust() {
        return RANDOM_ADJUST_LOWER + (RANDOM_ADJUST_RANGE * ItemManager.getRNG().nextDouble());
    }

    /**
     * Getter for the store field
     * @return the store field
     */
    public Store getStore() {
        return store;
    }

    /**
     * Getter for the name field
     * @return the name field
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the name field
     * @param name the name to set the field to
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the x field
     * @return the x field
     */
    public int getX() {
        return x;
    }

    /**
     * Getter for the y field
     * @return the y field
     */
    public int getY() {
        return y;
    }

    /**
     * Getter for the techLevel field
     * @return the techLevel field
     */
    public TechLevel getPlanetTechLevel() {
        return planetTechLevel;
    }

    /**
     * Getter for the resourceLevel field
     * @return the resourceLevel field
     */
    public Resource getPlanetResource() {
        return planetResource;
    }

}
