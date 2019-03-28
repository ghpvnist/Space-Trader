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

import edu.gatech.cs2340.spacetrader.R;
import edu.gatech.cs2340.spacetrader.model.Player;
import edu.gatech.cs2340.spacetrader.model.Universe;

public class UniverseViewActivity extends AppCompatActivity {

    private Universe universe;
    private Player player;
    private UniverseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_universe_view);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        universe = (Universe) extras.getSerializable("universe");
        player = Player.getInstance();

        RecyclerView recyclerView = findViewById(R.id.systemList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setOverScrollMode(View.OVER_SCROLL_ALWAYS);

        adapter = new UniverseAdapter();
        recyclerView.setAdapter(adapter);

        Log.v("APP", "Universe:");
        for (int i = 0; i < universe.getNumSolarSystems(); i++) {
            Log.v("APP", "Solar System #" + (i + 1) + ": " + universe.getSolarSystem(i).toString());
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        adapter.setUniverse(universe);
        adapter.setPlayer(player);
    }
}
