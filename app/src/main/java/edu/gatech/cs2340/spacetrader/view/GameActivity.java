package edu.gatech.cs2340.spacetrader.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import edu.gatech.cs2340.spacetrader.R;
import edu.gatech.cs2340.spacetrader.model.GameData;
import edu.gatech.cs2340.spacetrader.model.RandomEvent;
import edu.gatech.cs2340.spacetrader.viewmodel.GameActivityViewModel;

/**
 * Activity that launches whenever the game is started, is the main activity for the game
 */
public class GameActivity extends AppCompatActivity {

    private GameActivityViewModel viewModel;
    private TextView currentPlanetText;
    private GameData gameData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        this.viewModel = new GameActivityViewModel();
        this.gameData = GameData.getInstance();

        if (this.gameData.getPlayer().getCurrentPlanet() == null) {
            this.gameData.getPlayer().setCurrentPlanet(this.gameData.getUniverse().getSolarSystem(0).getPlanets()[0]);

            AlertDialog alertDialog = new AlertDialog.Builder(GameActivity.this).create();
            alertDialog.setTitle("Welcome " + this.gameData.getPlayer().getPlayerName() + "!");
            alertDialog.setMessage("Credits: " + this.gameData.getPlayer().getCredits()
                    + "\nShip: " + this.gameData.getPlayer().getShip().getShipType()
                    + "\nEngineer: " + this.gameData.getPlayer().getEngineerSkillPoints()
                    + "\nFighter: " + this.gameData.getPlayer().getFighterSkillPoints()
                    + "\nPilot: " + this.gameData.getPlayer().getPilotSkillPoints()
                    + "\nTrader: " + this.gameData.getPlayer().getTraderSkillPoints());
            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
            Log.v("GAME", "CREATED!");
        }

        Button viewUniverseButton = findViewById(R.id.viewUniverseButton);
        viewUniverseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GameActivity.this.openUniverseView();
            }
        });

        currentPlanetText = findViewById(R.id.currentPlanetText);
        currentPlanetText.setText("You are at the " + this.gameData.getPlayer().getCurrentPlanet().getName() + " System");

        Intent intent = getIntent();
        int eventNumber = intent.getIntExtra("eventNumber", Integer.MAX_VALUE);
        this.executeRandomEvent(eventNumber);
    }

    /**
     * Executes a RandomEvent and displays an alert if an event occurs
     * @param eventNumber the number of the randomly generated event
     */
    private void executeRandomEvent(int eventNumber) {
        RandomEvent event = new RandomEvent(eventNumber);
        if(event.execute()) {
            AlertDialog alertDialog = new AlertDialog.Builder(GameActivity.this).create();
            alertDialog.setTitle("An Event Occurred!");
            alertDialog.setMessage(event.getMessage());
            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("Here", "Resume " + this.gameData.getPlayer().getCurrentPlanet().getName());
        currentPlanetText.setText("You are at the " + this.gameData.getPlayer().getCurrentPlanet().getName() + " System");
    }

    /**
     * Launches the activity to display the universe view when the proper button is clicked
     */
    private void openUniverseView() {
        Intent intent = new Intent(this, UniverseViewActivity.class);
        startActivityForResult(intent, 1);
    }

    /**
     * Launches the activity to display the cargo when the proper button is clicked
     * @param v the view of activity
     */
    public void onCargoButtonPressed(View v) {
        Intent intent = new Intent(this, ViewCargoActivity.class);
        startActivity(intent);
    }

    /**
     * Launches the activity to display the store when the proper button is clicked
     * @param v the view of activity
     */
    public void onStoreButtonPressed(View v) {
        Intent intent = new Intent(this, StoreViewActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Quit Game?");
        builder.setMessage("Your progress will be saved.");
        builder.setCancelable(false);
        builder.setPositiveButton("QUIT", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(GameActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        builder.setNegativeButton("CANCEL", null);

        builder.show();
    }

    @Override
    public void onStop() {
        try{
            this.viewModel.saveGameData(this);
        } catch(Exception e){
            throw new RuntimeException("Game Data not saved");
        }
        super.onStop();
    }
}
