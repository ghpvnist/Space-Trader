package edu.gatech.cs2340.spacetrader.viewmodel;

import edu.gatech.cs2340.spacetrader.model.DifficultyLevel;
import edu.gatech.cs2340.spacetrader.model.Player;

public class CreateAccountViewModel {

    private DifficultyLevel difficulty;
    private Player player;

    public CreateAccountViewModel() {
        this.difficulty = DifficultyLevel.NORMAL;
        this.player = Player.instantiatePlayer();
    }

    public DifficultyLevel getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(DifficultyLevel difficulty) {
        this.difficulty = difficulty;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
