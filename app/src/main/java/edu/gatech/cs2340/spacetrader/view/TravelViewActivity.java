package edu.gatech.cs2340.spacetrader.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import edu.gatech.cs2340.spacetrader.R;
import edu.gatech.cs2340.spacetrader.model.GameData;
import edu.gatech.cs2340.spacetrader.model.SolarSystem;

/**
 * Activity that launches when the user wants to travel to a planet
 */
public class TravelViewActivity extends AppCompatActivity {

    private GameData gameData;
    private SolarSystem system;
    private int cost;

    private static final double HEIGHT_MULTIPLIER = 0.4;
    private static final double WIDTH_MULTIPLIER = 0.4;
    private static final int MILES_TO_COST_FACTOR = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_view);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        int planetIcon = extras.getInt("planetImage");
        system = (SolarSystem) extras.getSerializable("system");
        this.gameData = GameData.getInstance();

        //Make this a pop-up window
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * WIDTH_MULTIPLIER), (int) (height * HEIGHT_MULTIPLIER));

        TextView travelText = findViewById(R.id.travelText);
        travelText.setText("Traveling to " + system.getName());

        TextView distance = findViewById(R.id.distance);
        int curX = this.gameData.getPlayer().getCurrentPlanet().getX();
        int curY = this.gameData.getPlayer().getCurrentPlanet().getY();
        int nextX = system.getX();
        int nextY = system.getY();
        int miles = (int) Math.pow((Math.pow((double) (nextY - curY), 2) + (Math.pow((double) (nextX - curX), 2))), 1.0 / 2);
        distance.setText("Distance: " + Integer.toString(miles));

        cost = miles /MILES_TO_COST_FACTOR;
        TextView fuelCost = findViewById(R.id.fuelCost);
        fuelCost.setText("Fuel Cost: " + Integer.toString(cost));

        ImageView planetImage = findViewById(R.id.planetImage);
        planetImage.setImageResource(planetIcon);

        Button cancelButton = findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button goButton = findViewById(R.id.goButton);
        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    TravelViewActivity.this.travel();
                } catch(Exception ignored) {

                }
            }
        });
    }

    /**
     * Travels to the planet and returns to the main application page (GameActivity)
     */
    private void travel() {
        int currentFuel = this.gameData.getPlayer().getShip().getCurrentFuel();
        if(currentFuel >= cost) {
            this.gameData.getPlayer().getShip().setCurrentFuel(currentFuel - (cost));
            this.gameData.getPlayer().setCurrentPlanet(system.getPlanets()[0]);
            Toast.makeText(getApplicationContext(),"Traveled to the " + system.getName(),Toast.LENGTH_SHORT).show();
            finish();
            Intent intent = new Intent(this, GameActivity.class);
            intent.putExtra("eventNumber", this.generateRandomEvent());
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(),"Not enough fuel",Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Generates the event number for a possible random event
     * @return the event number
     */
    private int generateRandomEvent() {
        Random rand = new Random();
        return rand.nextInt(4);
    }
    @Override
    public void onBackPressed() {
        finish();
    }
}
