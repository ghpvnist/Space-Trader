package edu.gatech.cs2340.spacetrader.model;

import java.util.Map;

public class ItemManager {

    private static ItemManager instance = null;

    private Map<String, ItemType> items;
    private ItemType[] itemList;

    private ItemManager() {

        //TODO: read in JSON

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
}
