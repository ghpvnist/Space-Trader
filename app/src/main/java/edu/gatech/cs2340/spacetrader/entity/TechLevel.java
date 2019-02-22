package edu.gatech.cs2340.spacetrader.entity;

public enum TechLevel {
    PRE_AGRICULTURE("Pre-Agriculture", 0),
    AGRICULTURE("Agriculture", 1),
    MEDIEVAL("Medieval", 2),
    RENAISSANCE("Renaissance", 3),
    EARLY_INDUSTRIAL("Early-Industrial", 4),
    INDUSTRIAL("Industrial", 5),
    POST_INDUSTRIAL("Post-Industrial", 6),
    HI_TECH("Hi-Tech", 7);

    private String techLevel;
    private int techRank;

    TechLevel(String techLevel, int techRank) {
        this.techLevel = techLevel;
        this.techRank = techRank;
    }

    public String getTechLevel() {
        return techLevel;
    }

    public int getTechRank() {
        return techRank;
    }
}
