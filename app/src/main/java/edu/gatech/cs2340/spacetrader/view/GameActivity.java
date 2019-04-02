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

import com.google.gson.Gson;

import edu.gatech.cs2340.spacetrader.R;
import edu.gatech.cs2340.spacetrader.model.Player;
import edu.gatech.cs2340.spacetrader.model.Universe;
import edu.gatech.cs2340.spacetrader.viewmodel.GameActivityViewModel;

public class GameActivity extends AppCompatActivity {

    private GameActivityViewModel viewModel;
    private Universe universe;
    private Button viewUniverseButton;
    private Button shopButton;
    private Button shipButton;
    private TextView currentPlanetText;
    private Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        this.viewModel = new GameActivityViewModel();
        this.universe = viewModel.getUniverse();

        this.player = Player.getInstance();

        if (this.player.getCurrentPlanet() == null) {
            this.player.setCurrentPlanet(this.universe.getSolarSystem(0).getPlanets()[0]);

            AlertDialog alertDialog = new AlertDialog.Builder(GameActivity.this).create();
            alertDialog.setTitle("Welcome " + this.player.getPlayerName() + "!");
            alertDialog.setMessage("Credits: " + this.player.getCredits()
                    + "\nShip: " + this.player.getShip().getShipType()
                    + "\nEngineer: " + this.player.getEngineerSkillPoints()
                    + "\nFighter: " + this.player.getFighterSkillPoints()
                    + "\nPilot: " + this.player.getPilotSkillPoints()
                    + "\nTrader: " + this.player.getTraderSkillPoints());
            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
            Log.v("GAME", "CREATED!");
        }

        viewUniverseButton = findViewById(R.id.viewUniverseButton);
        viewUniverseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GameActivity.this.openUniverseView();
            }
        });

        shopButton = findViewById(R.id.shopButton);

        shipButton = findViewById(R.id.shipButton);

        currentPlanetText = findViewById(R.id.currentPlanetText);
        currentPlanetText.setText("You are at the " + this.player.getCurrentPlanet().getName() + " System");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("Here", "Resume " + this.player.getCurrentPlanet().getName());
        currentPlanetText.setText("You are at the " + this.player.getCurrentPlanet().getName() + " System");
    }

    public void openUniverseView() {
        Intent intent = new Intent(this, UniverseViewActivity.class);
        Bundle extras = new Bundle();
        extras.putSerializable("universe", universe);
        intent.putExtras(extras);
        startActivityForResult(intent, 1);
    }

    public void onCargoButtonPressed(View v) {
        Intent intent = new Intent(this, ViewCargoActivity.class);
        startActivity(intent);
    }

    public void onStoreButtonPressed(View v) {
        Intent intent = new Intent(this, StoreViewActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Quit Game?");
        builder.setMessage("Your progress will not be saved.");
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
}
