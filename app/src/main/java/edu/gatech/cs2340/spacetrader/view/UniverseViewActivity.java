package edu.gatech.cs2340.spacetrader.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import edu.gatech.cs2340.spacetrader.R;
import edu.gatech.cs2340.spacetrader.model.Universe;

public class UniverseViewActivity extends AppCompatActivity {

    private Universe universe;
    private UniverseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_universe_view);

        Intent intent = getIntent();
        universe = (Universe) intent.getSerializableExtra("universe");

        RecyclerView recyclerView = findViewById(R.id.systemList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setOverScrollMode(View.OVER_SCROLL_ALWAYS);

        adapter = new UniverseAdapter();
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();

        adapter.setUniverse(universe);
    }
}
