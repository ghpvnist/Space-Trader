package edu.gatech.cs2340.spacetrader.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public enum TechLevel implements Serializable {
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

    private static final Map<Integer, TechLevel> lookup = new HashMap<Integer, TechLevel>();

    static {
        for (TechLevel d : TechLevel.values()) {
            lookup.put(d.getTechRank(), d);
        }
    }

    public String getTechLevel() {
        return techLevel;
    }

    public int getTechRank() {
        return techRank;
    }

    public static TechLevel get(int rank) {
        return lookup.get(rank);
    }
}
