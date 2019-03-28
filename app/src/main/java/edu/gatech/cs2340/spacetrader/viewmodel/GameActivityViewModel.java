package edu.gatech.cs2340.spacetrader.viewmodel;

import edu.gatech.cs2340.spacetrader.model.Universe;

public class GameActivityViewModel {

    private Universe universe;

    public GameActivityViewModel() {
        this.universe = new Universe();
    }

    public Universe getUniverse() {
        return universe;
    }

    public void setUniverse(Universe universe) {
        this.universe = universe;
    }
}
