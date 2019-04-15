package edu.gatech.cs2340.spacetrader.model;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

import edu.gatech.cs2340.spacetrader.viewmodel.StoreViewModel;

public class StoreViewModelBuyTest {

    @BeforeClass
    public static void setUp() {
        GameData.TEST_setInstance(new Player("Bandhi", 4, 4,
                        4, 4, 0, 1000, new Ship()),
                new Universe());
    }

    @Test
    public void testBuyValid() {
        TradeOffer offer = new TradeOffer("Test Item", "test_item", 10, 500);
        Store store = new Store("Test Store", new TradeOffer[] {offer});
        StoreViewModel viewModel = new StoreViewModel(store, GameData.getInstance());

        GameData.getInstance().getPlayer().setCredits(1000);
        GameData.getInstance().getPlayer().getShip().clearCargo();

        viewModel.buyItem(offer, 10);

        assertEquals(900, GameData.getInstance().getPlayer().getCredits());
        assertEquals(10, GameData.getInstance().getPlayer().getShip().getCargo("Test Item"));

        assertEquals(490, offer.getItemQuantity());
    }

    @Test
    public void testBuyAllExact() {
        TradeOffer offer = new TradeOffer("Test Item", "test_item", 10, 50);
        Store store = new Store("Test Store", new TradeOffer[] {offer});
        StoreViewModel viewModel = new StoreViewModel(store, GameData.getInstance());

        GameData.getInstance().getPlayer().setCredits(500);
        GameData.getInstance().getPlayer().getShip().clearCargo();

        viewModel.buyItem(offer, 50);

        assertEquals(0, GameData.getInstance().getPlayer().getCredits());
        assertEquals(50, GameData.getInstance().getPlayer().getShip().getCargo("Test Item"));

        assertEquals(0, offer.getItemQuantity());
    }

    @Test
    public void testBuyNotEnoughStock() {
        TradeOffer offer = new TradeOffer("Test Item", "test_item", 10, 5);
        Store store = new Store("Test Store", new TradeOffer[] {offer});
        StoreViewModel viewModel = new StoreViewModel(store, GameData.getInstance());

        GameData.getInstance().getPlayer().setCredits(500);
        GameData.getInstance().getPlayer().getShip().clearCargo();

        viewModel.buyItem(offer, 50);

        assertEquals(500, GameData.getInstance().getPlayer().getCredits());
        assertEquals(0, GameData.getInstance().getPlayer().getShip().getCargo("Test Item"));

        assertEquals(5, offer.getItemQuantity());
    }

    @Test
    public void testBuyNotEnoughCredits() {
        TradeOffer offer = new TradeOffer("Test Item", "test_item", 10, 50);
        Store store = new Store("Test Store", new TradeOffer[] {offer});
        StoreViewModel viewModel = new StoreViewModel(store, GameData.getInstance());

        GameData.getInstance().getPlayer().setCredits(50);
        GameData.getInstance().getPlayer().getShip().clearCargo();

        viewModel.buyItem(offer, 10);

        assertEquals(50, GameData.getInstance().getPlayer().getCredits());
        assertEquals(0, GameData.getInstance().getPlayer().getShip().getCargo("Test Item"));

        assertEquals(50, offer.getItemQuantity());
    }

    @Test
    public void testBuyNotEnoughCargo() {
        TradeOffer offer = new TradeOffer("Test Item", "test_item", 10, 500);
        Store store = new Store("Test Store", new TradeOffer[] {offer});
        StoreViewModel viewModel = new StoreViewModel(store, GameData.getInstance());

        GameData.getInstance().getPlayer().setCredits(1000);
        GameData.getInstance().getPlayer().getShip().clearCargo();
        GameData.getInstance().getPlayer().getShip().addCargo("Machine Parts", 70);

        viewModel.buyItem(offer, 50);

        assertEquals(1000, GameData.getInstance().getPlayer().getCredits());
        assertEquals(0, GameData.getInstance().getPlayer().getShip().getCargo("Test Item"));

        assertEquals(500, offer.getItemQuantity());
    }
}
