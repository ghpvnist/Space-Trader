package edu.gatech.cs2340.spacetrader.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import edu.gatech.cs2340.spacetrader.R;
import edu.gatech.cs2340.spacetrader.model.DifficultyLevel;
import edu.gatech.cs2340.spacetrader.viewmodel.CreateAccountViewModel;

public class CreateAccount extends AppCompatActivity {
    private CreateAccountViewModel viewModel;
    private TextView remainingSkillPointsTextView;
    private TextView engineerSkillPointsTextView;
    private TextView traderSkillPointsTextView;
    private TextView fighterSkillPointsTextView;
    private TextView pilotSkillPointsTextView;
    private EditText usernameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_create_account);

        viewModel = new CreateAccountViewModel();

        remainingSkillPointsTextView = findViewById(R.id.skills_textview);
        engineerSkillPointsTextView = findViewById(R.id.engineer_counter);
        traderSkillPointsTextView = findViewById(R.id.trader_counter);
        fighterSkillPointsTextView = findViewById(R.id.fighter_counter);
        pilotSkillPointsTextView = findViewById(R.id.pilot_counter);

        Spinner difficultySpinner = findViewById(R.id.difficulty_spinner);
        difficultySpinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, DifficultyLevel.values()));

        usernameEditText = findViewById(R.id.player_name_edittext);

        Button engineerPlusButton = findViewById(R.id.engineer_plus_button);
        engineerPlusButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                viewModel.changeEngineerSkillPoints(1);
                updateRemainingSkillPointsView();
                updateEngineerSkillPointsView();
            }
        });

        Button fighterPlusButton = findViewById(R.id.fighter_plus_button);
        fighterPlusButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                viewModel.changeFighterSkillPoints(1);
                updateRemainingSkillPointsView();
                updateFighterSkillPointsView();
            }
        });

        Button pilotPlusButton = findViewById(R.id.pilot_plus_button);
        pilotPlusButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                viewModel.changePilotSkillPoints(1);
                updateRemainingSkillPointsView();
                updatePilotSkillPointsView();
            }
        });

        Button traderPlusButton = findViewById(R.id.trader_plus_button);
        traderPlusButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                viewModel.changeTraderSkillPoints(1);
                updateRemainingSkillPointsView();
                updateTraderSkillPointsView();
            }
        });

        Button engineerMinusButton = findViewById(R.id.engineer_minus_button);
        engineerMinusButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                viewModel.changeEngineerSkillPoints(-1);
                updateRemainingSkillPointsView();
                updateEngineerSkillPointsView();
            }
        });

        Button fighterMinusButton = findViewById(R.id.fighter_minus_button);
        fighterMinusButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                viewModel.changeFighterSkillPoints(-1);
                updateRemainingSkillPointsView();
                updateFighterSkillPointsView();
            }
        });

        Button pilotMinusButton = findViewById(R.id.pilot_minus_button);
        pilotMinusButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                viewModel.changePilotSkillPoints(-1);
                updateRemainingSkillPointsView();
                updatePilotSkillPointsView();
            }
        });

        Button traderMinusButton = findViewById(R.id.trader_minus_button);
        traderMinusButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                viewModel.changeTraderSkillPoints(-1);
                updateRemainingSkillPointsView();
                updateTraderSkillPointsView();
            }
        });

        updateRemainingSkillPointsView();
        updateEngineerSkillPointsView();
        updateFighterSkillPointsView();
        updatePilotSkillPointsView();
        updateTraderSkillPointsView();
    }

    public void updateRemainingSkillPointsView() {
        remainingSkillPointsTextView.setText(getApplicationContext().getString(
                R.string.remaining_skill_points, viewModel.getRemainingSkillPoints()));
    }

    public void updateEngineerSkillPointsView() {
        engineerSkillPointsTextView.setText(String.valueOf(viewModel.getEngineerSkillPoints()));
    }

    public void updateFighterSkillPointsView() {
        fighterSkillPointsTextView.setText(String.valueOf(viewModel.getFighterSkillPoints()));
    }

    public void updatePilotSkillPointsView() {
        pilotSkillPointsTextView.setText(String.valueOf(viewModel.getPilotSkillPoints()));
    }

    public void updateTraderSkillPointsView() {
        traderSkillPointsTextView.setText(String.valueOf(viewModel.getTraderSkillPoints()));
    }

    public void onClickStartButton(View v) {
        String playerName = usernameEditText.getText().toString().trim();
        if (playerName.length() < 1) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Please enter a valid name.",
                    Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            return;
        }
        if (!viewModel.allSkillPointsAllocated()) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Please allocate all skill points.",
                    Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            return;
        }
        viewModel.initializePlayer(playerName, DifficultyLevel.NORMAL);
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
        finish();
    }


    @Override
    public void onBackPressed() {
        if (usernameEditText.getText().toString().length() > 0 || viewModel.getRemainingSkillPoints() < 16) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Confirm Exit?");
            builder.setMessage("Your progress will not be saved.");
            builder.setCancelable(false);
            builder.setPositiveButton("CONFIRM", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(CreateAccount.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            });

            builder.setNegativeButton("CANCEL", null);
            builder.show();
        } else {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }

    }
}
