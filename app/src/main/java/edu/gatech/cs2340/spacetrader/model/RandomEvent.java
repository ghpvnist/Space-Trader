package edu.gatech.cs2340.spacetrader.model;

import java.util.Random;

/**
 * Class that represents random events that can happen
 */
public class RandomEvent {
    private final String message;
    private int creditsGained;

    private static final double RANDOM_CREDITS_LOWER = 0.05;
    private static final double RANDOM_CREDITS_UPPER = 0.30;

    /**
     * Constructor for the class
     * @param eventNumber the id for the randomly generated event
     */
    public RandomEvent(int eventNumber){
        String[] possibleEvents = {"Pirates attacked the ship!",
        "You found gold!", "You hit an asteroid field!", "You collected a bounty!"};

        this.creditsGained = 0;

        if((eventNumber < possibleEvents.length) && (eventNumber >= 0)){
            GameData gameData = GameData.getInstance();
            StringBuilder sb = new StringBuilder(possibleEvents[eventNumber]);
            Random rand = new Random();
            this.creditsGained = (int) ((RANDOM_CREDITS_LOWER + ((RANDOM_CREDITS_UPPER - RANDOM_CREDITS_LOWER) * rand.nextFloat()))
                    * gameData.getPlayer().getCredits());

            if((eventNumber % 2) == 0){
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

    /**
     * Getter for the message field
     * @return the message field
     */
    public String getMessage(){
        return this.message;
    }

    /**
     * Executes the random event by editing the player's credits
     * @return whether or not a random event happened
     */
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
