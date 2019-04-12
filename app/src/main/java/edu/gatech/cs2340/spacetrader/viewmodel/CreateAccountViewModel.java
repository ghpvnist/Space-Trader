package edu.gatech.cs2340.spacetrader.viewmodel;

import edu.gatech.cs2340.spacetrader.model.DifficultyLevel;
import edu.gatech.cs2340.spacetrader.model.GameData;
import edu.gatech.cs2340.spacetrader.model.Player;
import edu.gatech.cs2340.spacetrader.model.Ship;
import edu.gatech.cs2340.spacetrader.model.Universe;

/**
 * The ViewModel for CreateAccount
 */
public class CreateAccountViewModel {

    private DifficultyLevel difficulty;
    private int remainingSkillPoints;
    private int engineerSkillPoints;
    private int fighterSkillPoints;
    private int pilotSkillPoints;
    private int traderSkillPoints;

    public static final int INITIAL_SKILL_POINTS = 16;

    /**
     * Default constructor
     */
    public CreateAccountViewModel() {
        this.difficulty = DifficultyLevel.NORMAL;
        this.remainingSkillPoints = INITIAL_SKILL_POINTS;
        this.engineerSkillPoints = 0;
        this.fighterSkillPoints = 0;
        this.pilotSkillPoints = 0;
        this.traderSkillPoints = 0;
    }

    /**
     * Getter to get remaining skill points
     * @return remaining skill points
     */
    public int getRemainingSkillPoints() {
        return remainingSkillPoints;
    }

    /**
     * Getter to get engineer skill points
     * @return engineer skill points
     */
    public int getEngineerSkillPoints() {
        return engineerSkillPoints;
    }

    /**
     * Getter to get fighter skill points
     * @return fighter skill points
     */
    public int getFighterSkillPoints() {
        return fighterSkillPoints;
    }

    /**
     * Getter to get pilot skill points
     * @return pilot skill points
     */
    public int getPilotSkillPoints() {
        return pilotSkillPoints;
    }

    /**
     * Getter to get trader skill points
     * @return trader skill points
     */
    public int getTraderSkillPoints() {
        return traderSkillPoints;
    }

    /**
     * Changes engineer skill points by {points}, if possible.
     * Otherwise, doesn't change the values at all.
     * @param points the number of engineer skill points to add.
     */
    public void changeEngineerSkillPoints(int points) {
        if (((points > 0) && ((remainingSkillPoints - points) >= 0)) ||
                ((points < 0) && ((engineerSkillPoints + points) >= 0))) {
            remainingSkillPoints -= points;
            engineerSkillPoints += points;
        }
    }

    /**
     * Changes fighter skill points by {points}, if possible.
     * Otherwise, doesn't change the values at all.
     * @param points the number of fighter skill points to add.
     */
    public void changeFighterSkillPoints(int points) {
        if (((points > 0) && ((remainingSkillPoints - points) >= 0)) ||
                ((points < 0) && ((fighterSkillPoints + points) >= 0))) {
            remainingSkillPoints -= points;
            fighterSkillPoints += points;
        }
    }

    /**
     * Changes pilot skill points by {points}, if possible.
     * Otherwise, doesn't change the values at all.
     * @param points the number of pilot skill points to add.
     */
    public void changePilotSkillPoints(int points) {
        if (((points > 0) && ((remainingSkillPoints - points) >= 0)) ||
                ((points < 0) && ((pilotSkillPoints + points) >= 0))) {
            remainingSkillPoints -= points;
            pilotSkillPoints += points;
        }
    }

    /**
     * Changes trader skill points by {points}, if possible.
     * Otherwise, doesn't change the values at all.
     * @param points the number of trader skill points to add.
     */
    public void changeTraderSkillPoints(int points) {
        if (((points > 0) && ((remainingSkillPoints - points) >= 0)) ||
                ((points < 0) && ((traderSkillPoints + points) >= 0))) {
            remainingSkillPoints -= points;
            traderSkillPoints += points;
        }
    }

    /**
     * Checks for remaining skill points
     * @return boolean check for no remaining skill points
     */
    public boolean allSkillPointsAllocated() {
        return remainingSkillPoints == 0;
    }

    /**
     * Initializes the game state
     * @param playerName the name of player
     * @param difficulty the difficulty of the game
     */
    public void initializeGameData(String playerName, DifficultyLevel difficulty) {
        Player player = new Player(playerName, engineerSkillPoints, fighterSkillPoints,
                pilotSkillPoints, traderSkillPoints, 0, 1000, new Ship());
        Universe universe = new Universe();
        GameData.getInstance().setPlayer(player);
        GameData.getInstance().setUniverse(universe);
    }

}
