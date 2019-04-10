package edu.gatech.cs2340.spacetrader.model;

import java.util.Random;

public class RandomEvent {
    private int eventNumber;
    private String message;
    private int creditsGained;

    public RandomEvent(int eventNumber){
        String[] possibleEvents = {"Pirates attacked the ship!",
        "You found gold!", "You hit an asteroid field!", "You collected a bounty!"};

        this.eventNumber = eventNumber;
        this.creditsGained = 0;

        if(eventNumber < possibleEvents.length && eventNumber >= 0){
            GameData gameData = GameData.getInstance();
            StringBuilder sb = new StringBuilder(possibleEvents[eventNumber]);
            Random rand = new Random();
            this.creditsGained = rand.nextInt(gameData.getPlayer().getCredits()/3) + gameData.getPlayer().getCredits()/15;

            if(eventNumber % 2 == 0){
                sb.append(" You lost ").append(this.creditsGained).append(" Credits");
                this.creditsGained *= -1;
            } else {
                sb.append(" You gained ").append(this.creditsGained).append(" Credits");
            }

            this.message = sb.toString();

        } else {
            this.message = "No event happened.";
        }
    }

    public String getMessage(){
        return this.message;
    }

    public boolean execute(){
        boolean occurred = false;
        if(creditsGained != 0){
            occurred = true;
            int credits = GameData.getInstance().getPlayer().getCredits();
            GameData.getInstance().getPlayer().setCredits(credits + creditsGained);
        }
        return occurred;
    }
}
