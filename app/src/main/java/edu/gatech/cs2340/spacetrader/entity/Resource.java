package edu.gatech.cs2340.spacetrader.entity;

public enum Resource {
    NO_SPECIAL_RESOURCES("No Special Resources"),
    MINERAL_RICH("Mineral Rich"),
    MINERAL_POOR("Mineral Poor"),
    DESERT("Desert"),
    LOTS_OF_WATER("Lost of Water"),
    RICH_SOIL("Rich Soil"),
    POOR_SOIL("Poor Soil"),
    RICH_FAUNA("Rich Fauna"),
    LIFELESS("Lifeless"),
    WEIRD_MUSHROOMS("Weird Mushrooms"),
    LOTS_OF_HERBS("Lots of Herbs"),
    ARTISTIC("Artistic"),
    WAR_LIKE("War-Like");

    private String resourceName;

    Resource(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceName() {
        return resourceName;
    }
}
