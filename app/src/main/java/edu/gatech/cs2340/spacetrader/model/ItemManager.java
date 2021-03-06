package edu.gatech.cs2340.spacetrader.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Class that contains all of the possible items in the universe
 */
public class ItemManager {

    private static ItemManager instance = null;
    private static Random rng;

    private Map<String, ItemType> items;
    private ItemType[] itemList;

    private static int MAX_BASE_PRICE = 100;

    private ItemManager() {
        Random rng = new Random();

        itemList = new ItemType[8];
        itemList[0] = new ItemType("Apple", "apple", rng.nextInt(MAX_BASE_PRICE));
        itemList[1] = new ItemType("Food Rations", "food_rations", rng.nextInt(MAX_BASE_PRICE));
        itemList[2] = new ItemType("Wood Log", "log", rng.nextInt(MAX_BASE_PRICE));
        itemList[3] = new ItemType("Iron Bar", "iron_bar", rng.nextInt(MAX_BASE_PRICE));
        itemList[4] = new ItemType("Gold Bar", "gold_bar", rng.nextInt(MAX_BASE_PRICE));
        itemList[5] = new ItemType("Sakuradite Bar", "sakuradite_bar", rng.nextInt(MAX_BASE_PRICE));
        itemList[6] = new ItemType("Weapons", "weapons", rng.nextInt(MAX_BASE_PRICE));
        itemList[7] = new ItemType("Machine Parts", "machine_parts", rng.nextInt(MAX_BASE_PRICE));

        items = new HashMap<>();
        for (ItemType it : itemList) {
            items.put(it.getName(), it);
        }
    }

    /**
     * Returns the map that contains all the possible items
     * @return items the map that contains the possible items
     */
    public Map<String, ItemType> getItems() {
        return items;
    }

    /**
     * Returns the array representation of the list of possible items
     * @return itemList the list of possible items
     */
    public ItemType[] getItemList() {
        return itemList;
    }

    /**
     * Returns the itemType from its name field
     * @param name the name field of the itemType
     * @return item the itemType with the corresponding name field
     */
    public ItemType getItem(String name) {
        return items.get(name);
    }

    /**
     * Returns the INSTANCE of the singleton class
     * @return INSTANCE the instance of the singleton class
     */
    public static ItemManager getItemManager() {
        if (instance == null) {
            instance = new ItemManager();
        }
        return instance;
    }

    /**
     * Returns a Random object to add RNG into prices for the game
     * @return rng the random object generated
     */
    public static Random getRNG() {
        if (rng == null) rng = new Random();
        return rng;
    }
}
