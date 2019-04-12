package edu.gatech.cs2340.spacetrader.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Enumerates possible resource levels
 */
public enum Resource {
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

    private final String resourceName;
    private final int resourceLevel;

    Resource(String resourceName, int resourceLevel) {
        this.resourceName = resourceName;
        this.resourceLevel = resourceLevel;
    }

    private static final Map<Integer, Resource> lookup = new HashMap<>();

    static {
        for (Resource d : Resource.values()) {
            lookup.put(d.getResourceLevel(), d);
        }
    }

    /**
     * Getter for the name of the resource level
     * @return the name of the resource level
     */
    public String getResourceName() {
        return resourceName;
    }

    /**
     * Getter for the value of the level
     * @return the value corresponding to the level
     */
    private int getResourceLevel() {
        return resourceLevel;
    }

    /**
     * Gets the rank corresponding to the resource level
     * @param rank the rank we are searching for
     * @return the Enum value for the corresponding rank
     */
    public static Resource get(int rank) {
        return lookup.get(rank);
    }
}
