package edu.gatech.cs2340.spacetrader.viewmodel;

import edu.gatech.cs2340.spacetrader.model.GameData;
import edu.gatech.cs2340.spacetrader.model.Player;
import edu.gatech.cs2340.spacetrader.model.Universe;

public class GameActivityViewModel {

    private GameData gameData;

    public GameActivityViewModel() {

        this.gameData = GameData.getInstance();
    }

    public GameData getGameData() {
        return gameData;
    }

    public void setGameData(GameData gameData) {
        this.gameData = gameData;
    }
}
