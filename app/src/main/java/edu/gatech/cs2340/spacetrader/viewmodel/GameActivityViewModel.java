package edu.gatech.cs2340.spacetrader.viewmodel;

import android.content.Context;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import edu.gatech.cs2340.spacetrader.model.GameData;
import edu.gatech.cs2340.spacetrader.model.GameDataFacade;

public class GameActivityViewModel {

    private GameData gameData;
    private GameDataFacade gameDataFacade;

    public GameActivityViewModel() {
        this.gameData = GameData.getInstance();
        this.gameDataFacade = new GameDataFacade();
    }

    public GameData getGameData() {
        return gameData;
    }

    public void setGameData(GameData gameData) {
        this.gameData = gameData;
    }

    public void saveGameData(Context context) throws ExecutionException, InterruptedException {
        this.gameDataFacade.saveGameData(context);
    }

    public void loadGameData(Context context) throws IOException, ClassNotFoundException {
        this.gameDataFacade.loadGameData(context);
    }

}
