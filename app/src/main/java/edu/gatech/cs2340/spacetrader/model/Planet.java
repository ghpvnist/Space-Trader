package edu.gatech.cs2340.spacetrader.model;

import android.content.ClipData;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Planet implements Serializable {

    private String name;
    private TechLevel planetTechLevel;
    private Resource planetResource;
    private Store store;
    private int x;
    private int y;
    //private Shipyard shipyard;

    public Planet() {
        this.name = "";
    }

    public Planet(String name, int x, int y, Resource resource, TechLevel techLevel) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.planetResource = resource;
        this.planetTechLevel = techLevel;


        /*ItemType[] items = ItemManager.getItemManager().getItemList();
        ArrayList<TradeOffer> offers = new ArrayList<TradeOffer>();
        Random rand = new Random();

        for(ItemType item: items){
            if(item.getAdjustedQuantity(this) > 0){
                double priceMultiplier = .4 * rand.nextDouble() + .8;
                double quantityMultiplier = .4 * rand.nextDouble() + .8;

                //Tune quantities as necessary
                offers.add(new TradeOffer(item.getName(),
                        (int)(priceMultiplier * item.getAdjustedPrice(this)),
                        (int)(quantityMultiplier * item.getAdjustedQuantity(this))));
            }
        }

        TradeOffer[] tradeOffers = (TradeOffer[]) offers.toArray();

        this.store = new Store(name + " Store", tradeOffers);*/

        ItemManager im = ItemManager.getItemManager();
        List<ItemType> validItems = Arrays.asList(im.getItemList());
        Collections.shuffle(validItems);

        TradeOffer[] tradeOffers = new TradeOffer[3 + ItemManager.getRNG().nextInt(3)];
        for (int i = 0; i < tradeOffers.length; i++) {
            tradeOffers[i] = new TradeOffer(validItems.get(i).getName(), validItems.get(i).getItemId(),
                    (int)(getRandomAdjust() * validItems.get(i).getAdjustedPrice(this) + 0.5),
                    (int)(getRandomAdjust() * getRandomAdjust() * 12 - 2));
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

    private double getRandomAdjust() {
        return 0.8 + (0.4 * ItemManager.getRNG().nextDouble());
    }

    public Store getStore() {
        return store;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public TechLevel getPlanetTechLevel() {
        return planetTechLevel;
    }

    public Resource getPlanetResource() {
        return planetResource;
    }

    public boolean hasStore() {
        return true;
    }

    public boolean hasShipyard() {
        return true;
    }

}
