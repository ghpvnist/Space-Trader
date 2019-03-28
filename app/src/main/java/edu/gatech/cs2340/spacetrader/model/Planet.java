package edu.gatech.cs2340.spacetrader.model;

import java.io.Serializable;

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

        //TODO uncomment this code after finish coding ItemManager
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

        TradeOffer[] tradeOffers = new TradeOffer[4];
        tradeOffers[0] = new TradeOffer("Wood Log", 50, 8);
        tradeOffers[2] = new TradeOffer("Patrick", 550, 0);
        tradeOffers[1] = new TradeOffer("Machine Parts", 170, 25);
        tradeOffers[3] = new TradeOffer("Banana", 7, 50);

        this.store = new Store("Bandhi's Trinket Shack", tradeOffers);
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
