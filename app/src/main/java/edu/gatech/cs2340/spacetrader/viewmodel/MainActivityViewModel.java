package edu.gatech.cs2340.spacetrader.viewmodel;

import android.content.Context;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import edu.gatech.cs2340.spacetrader.model.GameDataFacade;

public class MainActivityViewModel {

    private GameDataFacade gameDataFacade;

    public MainActivityViewModel() {
        this.gameDataFacade = new GameDataFacade();
    }

    public void saveGameData(Context context) throws ExecutionException, InterruptedException {
        this.gameDataFacade.saveGameData(context);
    }

    public void loadGameData(Context context) throws IOException, ClassNotFoundException {
        this.gameDataFacade.loadGameData(context);
    }
}