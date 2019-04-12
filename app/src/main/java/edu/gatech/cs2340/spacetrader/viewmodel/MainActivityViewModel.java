package edu.gatech.cs2340.spacetrader.viewmodel;

import android.content.Context;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import edu.gatech.cs2340.spacetrader.model.GameDataFacade;

/**
 * ViewModel for the MainActivity Class
 */
public class MainActivityViewModel {

    private final GameDataFacade gameDataFacade;

    /**
     * Constructor for the class
     */
    public MainActivityViewModel() {
        this.gameDataFacade = new GameDataFacade();
    }

    /**
     * Handles saving the gameData using the facade
     * @param context the context of the current activity
     * @throws ExecutionException throws if we cannot save the gameData
     * @throws InterruptedException throws if the async task of saving the data is interrupted
     */
    public void saveGameData(Context context) throws ExecutionException, InterruptedException {
        this.gameDataFacade.saveGameData(context);
    }

    /**
     * Handles the loading of the gameData using the facade
     * @param context the context of the current activity
     * @throws IOException throws if there is an error with the input stream
     * @throws ClassNotFoundException throws if we cannot read the file to the gameData object
     */
    public void loadGameData(Context context) throws IOException, ClassNotFoundException {
        this.gameDataFacade.loadGameData(context);
    }
}