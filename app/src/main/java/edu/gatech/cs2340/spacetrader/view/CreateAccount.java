package edu.gatech.cs2340.spacetrader.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import edu.gatech.cs2340.spacetrader.R;
import edu.gatech.cs2340.spacetrader.model.Player;
import edu.gatech.cs2340.spacetrader.view.MainActivity;
import edu.gatech.cs2340.spacetrader.viewmodel.CreateAccountViewModel;

public class CreateAccount extends AppCompatActivity {

    private CreateAccountViewModel viewModel;
    private Button engineerPlus;
    private Button traderPlus;
    private Button fighterPlus;
    private Button pilotPlus;
    private Button engineerMinus;
    private Button traderMinus;
    private Button fighterMinus;
    private Button pilotMinus;
    private TextView engineerPoints;
    private TextView traderPoints;
    private TextView fighterPoints;
    private TextView pilotPoints;
    private Spinner difficultySpin;
    private Button start;
    private EditText name;
    private int pointsAvail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        engineerPlus = findViewById(R.id.engineer_plus_button);
        traderPlus = findViewById(R.id.trader_plus_button);
        fighterPlus = findViewById(R.id.fighter_plus_button);
        pilotPlus = findViewById(R.id.pilot_plus_button);
        engineerMinus = findViewById(R.id.engineer_minus_button);
        traderMinus = findViewById(R.id.trader_minus_button);
        fighterMinus = findViewById(R.id.fighter_minus_button);
        pilotMinus = findViewById(R.id.pilot_minus_button);
        engineerPoints = findViewById(R.id.engineer_counter);
        traderPoints = findViewById(R.id.trader_counter);
        fighterPoints = findViewById(R.id.fighter_counter);
        pilotPoints = findViewById(R.id.pilot_counter);
        difficultySpin = findViewById(R.id.difficulty_spinner);
        start = findViewById(R.id.start_button);
        name = findViewById(R.id.player_name_edittext);
        pointsAvail = 0;
        viewModel = new CreateAccountViewModel();
    }

    public void onPlus(View v) {
        switch(v.getId()) {
            case R.id.engineer_plus_button:
                if(pointsAvail == 16){
                    //throw, send toast
                } else {
                    int set = Integer.parseInt(engineerPoints.getText().toString());
                    set++;
                    pointsAvail++;
                    engineerPoints.setText(set);
                }

                break;
        }
    }

    public void onMinus(View v) {

    }

    public void onStart(View v) {
        viewModel.setPlayer(new Player());
        //viewModel.getPlayer().set
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
