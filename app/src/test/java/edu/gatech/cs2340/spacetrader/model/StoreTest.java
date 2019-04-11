package edu.gatech.cs2340.spacetrader.model;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class StoreTest {

    private static Store store;
    private static TradeOffer[] tradeOffers;

    @BeforeClass
    public static void setUp() {
        tradeOffers = new TradeOffer[3];
        tradeOffers[0] = new TradeOffer("Apple", "apple", 10, 3);
        tradeOffers[1] = new TradeOffer("Food Rations", "food_rations", 15, 3);
        tradeOffers[2] = new TradeOffer("Wood Log", "log", 28, 3);

        TradeOffer[] newOffers = new TradeOffer[3];
        newOffers[0] = new TradeOffer("Apple", "apple", 10, 3);
        newOffers[1] = new TradeOffer("Food Rations", "food_rations", 15, 3);
        newOffers[2] = new TradeOffer("Wood Log", "log", 28, 3);

        store = new Store("Test", newOffers);
    }

    @Test
    public void updateStore() {

        //Asserts the precondition that tradeOffers exists
        assertTrue(store.getTradeOffers() != null);

        //Calls the method
        store.updateStore();

        //Checks for the post condition
        boolean storeChanged = false;
        TradeOffer[] newOffers = store.getTradeOffers();
        for(int i = 0; i<newOffers.length; i++){

            //Asserts frame conditions
            assertTrue(tradeOffers[i].getItemName().equals(newOffers[i].getItemName()));
            assertTrue(tradeOffers[i].getItemId().equals(newOffers[i].getItemId()));

            //Check if the store has restocked
            if(newOffers[i].getItemQuantity() != tradeOffers[i].getItemQuantity()){
                storeChanged = true;
            }

        }

        //Asserts the post condition that the store has been restocked
        assertTrue(storeChanged);

        //Asserts the final frame condition
        assertTrue(newOffers.length == tradeOffers.length);

    }
}