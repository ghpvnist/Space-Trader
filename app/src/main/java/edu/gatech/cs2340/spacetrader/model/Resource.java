package edu.gatech.cs2340.spacetrader.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public enum Resource implements Serializable {
    NO_SPECIAL_RESOURCES("No Special Resources", 0),
    MINERAL_RICH("Mineral Rich", 1),
    MINERAL_POOR("Mineral Poor", 2),
    DESERT("Desert", 3),
    LOTS_OF_WATER("Lost of Water", 4),
    RICH_SOIL("Rich Soil", 5),
    POOR_SOIL("Poor Soil", 6),
    RICH_FAUNA("Rich Fauna", 7),
    LIFELESS("Lifeless", 8),
    WEIRD_MUSHROOMS("Weird Mushrooms", 9),
    LOTS_OF_HERBS("Lots of Herbs", 10),
    ARTISTIC("Artistic", 11),
    WAR_LIKE("War-Like", 12);

    private String resourceName;
    private int resourceLevel;

    Resource(String resourceName, int resourceLevel) {
        this.resourceName = resourceName;
        this.resourceLevel = resourceLevel;
    }

    private static final Map<Integer, Resource> lookup = new HashMap<Integer, Resource>();

    static {
        for (Resource d : Resource.values()) {
            lookup.put(d.getResourceLevel(), d);
        }
    }

    public String getResourceName() {
        return resourceName;
    }

    public int getResourceLevel() { return resourceLevel; }

    public static Resource get(int rank) {
        return lookup.get(rank);
    }
}
