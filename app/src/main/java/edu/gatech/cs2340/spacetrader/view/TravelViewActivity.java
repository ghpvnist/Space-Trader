package edu.gatech.cs2340.spacetrader.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import edu.gatech.cs2340.spacetrader.R;
import edu.gatech.cs2340.spacetrader.model.Player;
import edu.gatech.cs2340.spacetrader.model.SolarSystem;
import edu.gatech.cs2340.spacetrader.model.Universe;

public class TravelViewActivity extends AppCompatActivity {

    private Player player;
    private TextView travelText;
    private TextView distance;
    private TextView fuelCost;
    private ImageView planetImage;
    private Button cancelButton;
    private Button goButton;
    private SolarSystem system;
    private int miles;
    private int cost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_view);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        int planetIcon = (int) extras.getInt("planetImage");
        player = Player.getInstance();
        system = (SolarSystem) extras.getSerializable("system");

        //Make this a pop-up window
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * 0.8), (int) (height * 0.4));

        travelText = findViewById(R.id.travelText);
        travelText.setText("Traveling to " + system.getName());

        distance = findViewById(R.id.distance);
        int curX = player.getCurrentPlanet().getX();
        int curY = player.getCurrentPlanet().getY();
        int nextX = system.getX();
        int nextY = system.getY();
        miles = (int) Math.pow((Math.pow((double) (nextY - curY), 2) + (Math.pow((double) (nextX - curX), 2))), 0.5);
        distance.setText("Distance: " + Integer.toString(miles));

        cost = miles/20;
        fuelCost = findViewById(R.id.fuelCost);
        fuelCost.setText("Fuel Cost: " + Integer.toString(cost));

        planetImage = findViewById(R.id.planetImage);
        planetImage.setImageResource(planetIcon);

        cancelButton = findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        goButton = findViewById(R.id.goButton);
        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TravelViewActivity.this.travel();
            }
        });
    }

    public void travel() {
        int currentFuel = player.getShip().getCurrentFuel();
        if(currentFuel >= cost) {
            player.getShip().setCurrentFuel(currentFuel - (cost));
            player.setCurrentPlanet(system.getPlanets()[0]);
            Toast.makeText(getApplicationContext(),"Traveled to the " + system.getName(),Toast.LENGTH_SHORT).show();
            finish();
            Intent intent = new Intent(this, GameActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(),"Not enough fuel",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
