package edu.gatech.cs2340.spacetrader.viewmodel;

import android.content.Context;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import edu.gatech.cs2340.spacetrader.model.GameData;
import edu.gatech.cs2340.spacetrader.model.GameDataFacade;

/**
 * ViewModel for the GameActivity view, handles loading of data
 */
public class GameActivityViewModel {

    private GameData gameData;
    private GameDataFacade gameDataFacade;

    /**
     * Constructor for the class, gets the singleton gameData object
     */
    public GameActivityViewModel() {
        this.gameData = GameData.getInstance();
        this.gameDataFacade = new GameDataFacade();
    }

    /**
     * Getter for the gameData field
     * @return gameData the gameData field for the object
     */
    public GameData getGameData() {
        return gameData;
    }

    /**
     * Setter for the gameData field
     * @param gameData the gameData field for the object
     */
    public void setGameData(GameData gameData) {
        this.gameData = gameData;
    }

    /**
     * Handles the saving of the gameData using the facade design pattern
     * @param context the context of the current activity
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public void saveGameData(Context context) throws ExecutionException, InterruptedException {
        this.gameDataFacade.saveGameData(context);
    }

    /**
     * Loads the gameData using the facade design pattern
     * @param context the context of the current activity
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void loadGameData(Context context) throws IOException, ClassNotFoundException {
        this.gameDataFacade.loadGameData(context);
    }

}
