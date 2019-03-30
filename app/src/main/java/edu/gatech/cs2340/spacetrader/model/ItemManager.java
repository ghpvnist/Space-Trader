package edu.gatech.cs2340.spacetrader.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ItemManager {

    private static ItemManager instance = null;
    private static Random rng;

    private Map<String, ItemType> items;
    private ItemType[] itemList;

    private ItemManager() {
        itemList = new ItemType[8];
        itemList[0] = new ItemType("Apple", "apple", 10);
        itemList[1] = new ItemType("Food Rations", "food_rations", 21);
        itemList[2] = new ItemType("Wood Log", "log", 28);
        itemList[3] = new ItemType("Iron Bar", "iron_bar", 35);
        itemList[4] = new ItemType("Gold Bar", "gold_bar", 58);
        itemList[5] = new ItemType("Sakuradite Bar", "sakuradite_bar", 183);
        itemList[6] = new ItemType("Weapons", "weapons", 88);
        itemList[7] = new ItemType("Machine Parts", "machine_parts", 39);

        items = new HashMap<>();
        for (ItemType it : itemList) {
            items.put(it.getName(), it);
        }
    }

    public Map<String, ItemType> getItems() {
        return items;
    }

    public ItemType[] getItemList() {
        return itemList;
    }

    public ItemType getItem(String name) {
        return items.get(name);
    }

    public static ItemManager getItemManager() {
        if (instance == null) {
            instance = new ItemManager();
        }
        return instance;
    }

    public static Random getRNG() {
        if (rng == null) rng = new Random();
        return rng;
    }
}
