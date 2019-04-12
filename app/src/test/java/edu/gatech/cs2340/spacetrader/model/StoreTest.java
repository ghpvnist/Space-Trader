package edu.gatech.cs2340.spacetrader.model;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit tests for the Store class
 */
public class StoreTest {

    private static final int ITEM_PRICE = 15;
    private static final int ITEM_PRICE1 = 28;
    private static final int ITEM_PRICE2 = 10;
    private static final int ITEM_PRICE3 = 28;
    private static Store store;
    private static TradeOffer[] tradeOffers;

    /**
     * Adds the default object to be tested on
     */
    @BeforeClass
    public static void setUp() {

        tradeOffers = new TradeOffer[3];
        tradeOffers[0] = new TradeOffer("Apple", "apple", ITEM_PRICE2, 3);
        tradeOffers[1] = new TradeOffer("Food Rations", "food_rations", ITEM_PRICE, 3);
        tradeOffers[2] = new TradeOffer("Wood Log", "log", ITEM_PRICE1, 3);

        TradeOffer[] newOffers = new TradeOffer[3];
        newOffers[0] = new TradeOffer("Apple", "apple", 10, 3);
        newOffers[1] = new TradeOffer("Food Rations", "food_rations", ITEM_PRICE, 3);
        newOffers[2] = new TradeOffer("Wood Log", "log", ITEM_PRICE3, 3);

        store = new Store("Test", newOffers);
    }

    /**
     * Tests the updateStore() method
     */
    @Test
    public void updateStore() {

        //Asserts the precondition that tradeOffers exists
        assertNotNull(store.getTradeOffers());

        //Calls the method
        store.updateStore();

        //Checks for the post condition
        boolean storeChanged = false;
        TradeOffer[] newOffers = store.getTradeOffers();
        for(int i = 0; i<newOffers.length; i++){

            //Asserts frame conditions
            assertEquals(tradeOffers[i].getItemName(), newOffers[i].getItemName());
            assertEquals(tradeOffers[i].getItemId(), newOffers[i].getItemId());

            //Check if the store has restocked
            if(newOffers[i].getItemQuantity() != tradeOffers[i].getItemQuantity()){
                storeChanged = true;
            }

        }

        //Asserts the post condition that the store has been restocked
        assertTrue(storeChanged);

        //Asserts the final frame condition
        assertEquals(newOffers.length, tradeOffers.length);

    }
}