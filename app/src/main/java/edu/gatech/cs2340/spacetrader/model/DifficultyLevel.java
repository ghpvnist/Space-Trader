package edu.gatech.cs2340.spacetrader.model;

/**
 * Enumerates possible difficulty levels for the game
 */
public enum DifficultyLevel {
    BEGINNER("BEGINNER"),
    EASY("EASY"),
    NORMAL("NORMAL"),
    HARD("HARD"),
    IMPOSSIBLE("IMPOSSIBLE");

    private String difficulty;

    private DifficultyLevel(String difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public String toString() {
        return difficulty;
    }

}
