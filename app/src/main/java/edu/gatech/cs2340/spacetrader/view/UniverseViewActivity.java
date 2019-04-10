package edu.gatech.cs2340.spacetrader.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import edu.gatech.cs2340.spacetrader.R;
import edu.gatech.cs2340.spacetrader.model.GameData;
import edu.gatech.cs2340.spacetrader.model.Player;
import edu.gatech.cs2340.spacetrader.model.Universe;

public class UniverseViewActivity extends AppCompatActivity {

    private GameData gameData;
    private UniverseAdapter adapter;
    private TextView fuelText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_universe_view);

        gameData = GameData.getInstance();

        RecyclerView recyclerView = findViewById(R.id.systemList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setOverScrollMode(View.OVER_SCROLL_ALWAYS);

        adapter = new UniverseAdapter();
        recyclerView.setAdapter(adapter);

        Log.v("APP", "Universe:");
        for (int i = 0; i < gameData.getUniverse().getNumSolarSystems(); i++) {
            Log.v("APP", "Solar System #" + (i + 1) + ": " + gameData.getUniverse().getSolarSystem(i).toString());
        }

        fuelText = findViewById(R.id.fuelText);
        fuelText.setText("Available Fuel: " + gameData.getPlayer().getShip().getCurrentFuel());

    }

    @Override
    public void onResume() {
        super.onResume();

        adapter.setUniverse(gameData.getUniverse());
        adapter.setPlayer(gameData.getPlayer());
        fuelText.setText("Available Fuel: " + gameData.getPlayer().getShip().getCurrentFuel());
    }
}
