package edu.gatech.cs2340.spacetrader.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import java.io.IOException;

import edu.gatech.cs2340.spacetrader.R;
import edu.gatech.cs2340.spacetrader.model.GameData;
import edu.gatech.cs2340.spacetrader.model.Player;
import edu.gatech.cs2340.spacetrader.model.Universe;
import edu.gatech.cs2340.spacetrader.viewmodel.MainActivityViewModel;

/**
 * Activity that launches when the user opens the app, allows loading or creating a new game
 */
public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        this.viewModel = new MainActivityViewModel();

        Player player = new Player();

        try {
            GameData.instantiateGameData(player, new Universe());
        } catch(Exception e) {

        }

    }

    /**
     * Fires when the user decides to start a new game or load an old one
     * @param v the view the user clicks on
     */
    public void onClick(View v) {
        if (v.getId() == R.id.newAccount) {
            createAccount();
        } else if (v.getId() == R.id.loadAccount) {
            loadAccount();
        }

    }

    /**
     * Starts an activity to create a player when the user decides to start a new game
     */
    public void createAccount() {
        Intent intent = new Intent(this, CreateAccount.class);
        startActivity(intent);
        finish();
    }

    /**
     * Handles the loading of the previous game
     */
    public void loadAccount() {
        try {
            this.viewModel.loadGameData(this);
            Intent intent = new Intent(this, GameActivity.class);
            startActivity(intent);
            finish();
        } catch(IOException e) {
            Toast.makeText(getApplicationContext(),"No Data To Load",Toast.LENGTH_SHORT).show();
            Log.i("Data", e.toString());
        } catch(ClassNotFoundException e){
            Log.i("Data", "Class to load does not exist");
        }
    }


}
