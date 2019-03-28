package edu.gatech.cs2340.spacetrader.model;

import java.io.Serializable;
import java.util.Random;

public class Store implements Serializable {

    private String storeName;
    private TradeOffer[] tradeOffers;

    public Store(String storeName, TradeOffer[] tradeOffers) {
        this.storeName = storeName;
        this.tradeOffers = tradeOffers;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public TradeOffer[] getTradeOffers() {
        return tradeOffers;
    }

    public void setTradeOffers(TradeOffer[] tradeOffers) {
        this.tradeOffers = tradeOffers;
    }

    //buying from the store
    public int sellOffer(int offerIndex, int quantity){
        if(offerIndex > tradeOffers.length){
            throw new RuntimeException("TradeOffer index does not exist");
        }

        if(tradeOffers[offerIndex].getItemQuantity() < quantity){
            throw new RuntimeException("TradeOffer does not have enough quantity to sell");
        }

        int currentQuantity = tradeOffers[offerIndex].getItemQuantity();
        tradeOffers[offerIndex].setItemQuantity(currentQuantity - quantity);

        return quantity * tradeOffers[offerIndex].getItemPrice();

    }

    //selling to the store
    public int buyOffer(int offerIndex, int quantity){
        if(offerIndex > tradeOffers.length){
            throw new RuntimeException("TradeOffer index does not exist");
        }

        int currentQuantity = tradeOffers[offerIndex].getItemQuantity();
        tradeOffers[offerIndex].setItemQuantity(currentQuantity + quantity);

        return quantity * tradeOffers[offerIndex].getItemPrice();

    }

    public int buyFuel(int quantity){
        return 10 * quantity;
    }

    public void updateStore(){
        Random rand = new Random();

        for(TradeOffer tradeOffer: tradeOffers){

            //expected value of about 1
            double x = 4 * rand.nextDouble() - 2;
            double multiplier = 2.27 * Math.pow(Math.E, -1 * Math.pow(x, 2));

            if(tradeOffer.getItemQuantity() > tradeOffer.getDefaultQuantity()){
                tradeOffer.setItemQuantity((int) (tradeOffer.getItemQuantity() * multiplier));
            } else {
                tradeOffer.setItemQuantity((int) (tradeOffer.getDefaultQuantity() * multiplier));
            }

        }

    }

}
