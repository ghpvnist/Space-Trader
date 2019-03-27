package edu.gatech.cs2340.spacetrader.model;

import java.io.Serializable;

public class Planet implements Serializable {

    private String name;
    private TechLevel planetTechLevel;
    private Resource planetResource;
    private Store store;
    //private Shipyard shipyard;

    public Planet() {
        this.name = "";
    }

    public Planet(String name, Resource resource, TechLevel techLevel) {
        this.name = name;
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
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TechLevel getPlanetTechLevel() {
        return planetTechLevel;
    }

    public Resource getPlanetResource() {
        return planetResource;
    }

    public boolean hasStore(){
        return true;
    }

    public boolean hasShipyard(){
        return true;
    }

}
