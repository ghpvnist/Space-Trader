package edu.gatech.cs2340.spacetrader.viewmodel;

import edu.gatech.cs2340.spacetrader.model.DifficultyLevel;
import edu.gatech.cs2340.spacetrader.model.GameData;
import edu.gatech.cs2340.spacetrader.model.Player;
import edu.gatech.cs2340.spacetrader.model.Ship;
import edu.gatech.cs2340.spacetrader.model.Universe;

public class CreateAccountViewModel {

    private DifficultyLevel difficulty;
    private int remainingSkillPoints;
    private int engineerSkillPoints;
    private int fighterSkillPoints;
    private int pilotSkillPoints;
    private int traderSkillPoints;

    public CreateAccountViewModel() {
        this.difficulty = DifficultyLevel.NORMAL;
        this.remainingSkillPoints = 16;
        this.engineerSkillPoints = 0;
        this.fighterSkillPoints = 0;
        this.pilotSkillPoints = 0;
        this.traderSkillPoints = 0;
    }

    public int getRemainingSkillPoints() {
        return remainingSkillPoints;
    }

    public int getEngineerSkillPoints() {
        return engineerSkillPoints;
    }

    public int getFighterSkillPoints() {
        return fighterSkillPoints;
    }

    public int getPilotSkillPoints() {
        return pilotSkillPoints;
    }

    public int getTraderSkillPoints() {
        return traderSkillPoints;
    }

    /**
     * Changes engineer skill points by {points}, if possible.
     * Otherwise, doesn't change the values at all.
     */
    public void changeEngineerSkillPoints(int points) {
        if ((points > 0 && remainingSkillPoints - points >= 0) ||
                (points < 0 && engineerSkillPoints + points >= 0)) {
            remainingSkillPoints -= points;
            engineerSkillPoints += points;
        }
    }

    /**
     * Changes fighter skill points by {points}, if possible.
     * Otherwise, doesn't change the values at all.
     */
    public void changeFighterSkillPoints(int points) {
        if ((points > 0 && remainingSkillPoints - points >= 0) ||
                (points < 0 && fighterSkillPoints + points >= 0)) {
            remainingSkillPoints -= points;
            fighterSkillPoints += points;
        }
    }

    /**
     * Changes pilot skill points by {points}, if possible.
     * Otherwise, doesn't change the values at all.
     */
    public void changePilotSkillPoints(int points) {
        if ((points > 0 && remainingSkillPoints - points >= 0) ||
                (points < 0 && pilotSkillPoints + points >= 0)) {
            remainingSkillPoints -= points;
            pilotSkillPoints += points;
        }
    }

    /**
     * Changes trader skill points by {points}, if possible.
     * Otherwise, doesn't change the values at all.
     */
    public void changeTraderSkillPoints(int points) {
        if ((points > 0 && remainingSkillPoints - points >= 0) ||
                (points < 0 && traderSkillPoints + points >= 0)) {
            remainingSkillPoints -= points;
            traderSkillPoints += points;
        }
    }

    public boolean allSkillPointsAllocated() {
        return remainingSkillPoints == 0;
    }

    public void initializeGameData(String playerName, DifficultyLevel difficulty) {
        Player player = new Player(playerName, engineerSkillPoints, fighterSkillPoints,
                pilotSkillPoints, traderSkillPoints, 0, 1000, new Ship());
        Universe universe = new Universe();
        GameData.getInstance().setPlayer(player);
        GameData.getInstance().setUniverse(universe);
    }

}
