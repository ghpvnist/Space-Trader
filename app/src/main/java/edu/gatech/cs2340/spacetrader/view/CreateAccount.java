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

import com.google.gson.Gson;

import edu.gatech.cs2340.spacetrader.R;
import edu.gatech.cs2340.spacetrader.entity.DifficultyLevel;
import edu.gatech.cs2340.spacetrader.model.Player;
import edu.gatech.cs2340.spacetrader.viewmodel.CreateAccountViewModel;

public class CreateAccount extends AppCompatActivity {
    private CreateAccountViewModel viewModel;
    private Button engineerPlusButton;
    private Button traderPlusButton;
    private Button fighterPlusButton;
    private Button pilotPlusButton;
    private Button engineerMinusButton;
    private Button traderMinusButton;
    private Button fighterMinusButton;
    private Button pilotMinusButton;
    private TextView skillTextView;
    private TextView engineerPointsTextView;
    private TextView traderPointsTextView;
    private TextView fighterPointsTextView;
    private TextView pilotPointsTextView;
    private Spinner difficultySpinner;
    private Button startButton;
    private EditText usernameEditText;
    private int skillPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_create_account);

        skillTextView = findViewById(R.id.skills_textview);
        engineerPointsTextView = findViewById(R.id.engineer_counter);
        traderPointsTextView = findViewById(R.id.trader_counter);
        fighterPointsTextView = findViewById(R.id.fighter_counter);
        pilotPointsTextView = findViewById(R.id.pilot_counter);
        difficultySpinner = findViewById(R.id.difficulty_spinner);
        difficultySpinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, DifficultyLevel.values()));
        startButton = findViewById(R.id.start_button);
        usernameEditText = findViewById(R.id.player_name_edittext);
        skillPoints = 16;
        viewModel = new CreateAccountViewModel();

        skillTextView.setText(skillTextView.getText().toString() + skillPoints);

        engineerPlusButton = findViewById(R.id.engineer_plus_button);
        engineerPlusButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int totalSkillPoints = Integer.valueOf(engineerPointsTextView.getText().toString())
                        + Integer.valueOf(fighterPointsTextView.getText().toString())
                        + Integer.valueOf(pilotPointsTextView.getText().toString())
                        + Integer.valueOf(traderPointsTextView.getText().toString());
                if (totalSkillPoints < 16) {
                    skillPoints--;
                    skillTextView.setText(skillTextView.getText().toString().substring(0, 14) + skillPoints);
                    int setEngineer = Integer.parseInt(engineerPointsTextView.getText().toString());
                    setEngineer++;
                    engineerPointsTextView.setText(String.valueOf(setEngineer));
                }
            }
        });
        fighterPlusButton = findViewById(R.id.fighter_plus_button);
        fighterPlusButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int totalSkillPoints = Integer.valueOf(engineerPointsTextView.getText().toString())
                        + Integer.valueOf(fighterPointsTextView.getText().toString())
                        + Integer.valueOf(pilotPointsTextView.getText().toString())
                        + Integer.valueOf(traderPointsTextView.getText().toString());
                if (totalSkillPoints < 16) {
                    skillPoints--;
                    skillTextView.setText(skillTextView.getText().toString().substring(0, 14) + skillPoints);
                    int setFighter = Integer.parseInt(fighterPointsTextView.getText().toString());
                    setFighter++;
                    fighterPointsTextView.setText(String.valueOf(setFighter));
                }
            }
        });
        pilotPlusButton = findViewById(R.id.pilot_plus_button);
        pilotPlusButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int totalSkillPoints = Integer.valueOf(engineerPointsTextView.getText().toString())
                        + Integer.valueOf(fighterPointsTextView.getText().toString())
                        + Integer.valueOf(pilotPointsTextView.getText().toString())
                        + Integer.valueOf(traderPointsTextView.getText().toString());
                if (totalSkillPoints < 16) {
                    skillPoints--;
                    skillTextView.setText(skillTextView.getText().toString().substring(0, 14) + skillPoints);
                    int setPilot = Integer.parseInt(pilotPointsTextView.getText().toString());
                    setPilot++;
                    pilotPointsTextView.setText(String.valueOf(setPilot));
                }
            }
        });
        traderPlusButton = findViewById(R.id.trader_plus_button);
        traderPlusButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int totalSkillPoints = Integer.valueOf(engineerPointsTextView.getText().toString())
                        + Integer.valueOf(fighterPointsTextView.getText().toString())
                        + Integer.valueOf(pilotPointsTextView.getText().toString())
                        + Integer.valueOf(traderPointsTextView.getText().toString());
                if (totalSkillPoints < 16) {
                    skillPoints--;
                    skillTextView.setText(skillTextView.getText().toString().substring(0, 14) + skillPoints);
                    int setTrader = Integer.parseInt(traderPointsTextView.getText().toString());
                    setTrader++;
                    traderPointsTextView.setText(String.valueOf(setTrader));
                }
            }
        });
        engineerMinusButton = findViewById(R.id.engineer_minus_button);
        engineerMinusButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int totalSkillPoints = Integer.valueOf(engineerPointsTextView.getText().toString())
                        + Integer.valueOf(fighterPointsTextView.getText().toString())
                        + Integer.valueOf(pilotPointsTextView.getText().toString())
                        + Integer.valueOf(traderPointsTextView.getText().toString());
                if (totalSkillPoints > 0 && Integer.valueOf(engineerPointsTextView.getText().toString()) != 0) {
                    skillPoints++;
                    skillTextView.setText(skillTextView.getText().toString().substring(0, 14) + skillPoints);
                    int setEngineer = Integer.parseInt(engineerPointsTextView.getText().toString());
                    setEngineer--;
                    engineerPointsTextView.setText(String.valueOf(setEngineer));
                }
            }
        });
        fighterMinusButton = findViewById(R.id.fighter_minus_button);
        fighterMinusButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int totalSkillPoints = Integer.valueOf(engineerPointsTextView.getText().toString())
                        + Integer.valueOf(fighterPointsTextView.getText().toString())
                        + Integer.valueOf(pilotPointsTextView.getText().toString())
                        + Integer.valueOf(traderPointsTextView.getText().toString());
                if (totalSkillPoints > 0 && Integer.valueOf(fighterPointsTextView.getText().toString()) != 0) {
                    skillPoints++;
                    skillTextView.setText(skillTextView.getText().toString().substring(0, 14) + skillPoints);
                    int setFighter = Integer.parseInt(fighterPointsTextView.getText().toString());
                    setFighter--;
                    fighterPointsTextView.setText(String.valueOf(setFighter));
                }
            }
        });
        pilotMinusButton = findViewById(R.id.pilot_minus_button);
        pilotMinusButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int totalSkillPoints = Integer.valueOf(engineerPointsTextView.getText().toString())
                        + Integer.valueOf(fighterPointsTextView.getText().toString())
                        + Integer.valueOf(pilotPointsTextView.getText().toString())
                        + Integer.valueOf(traderPointsTextView.getText().toString());
                if (totalSkillPoints > 0 && Integer.valueOf(pilotPointsTextView.getText().toString()) != 0) {
                    skillPoints++;
                    skillTextView.setText(skillTextView.getText().toString().substring(0, 14) + skillPoints);
                    int setPilot = Integer.parseInt(pilotPointsTextView.getText().toString());
                    setPilot--;
                    pilotPointsTextView.setText(String.valueOf(setPilot));
                }
            }
        });
        traderMinusButton = findViewById(R.id.trader_minus_button);
        traderMinusButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int totalSkillPoints = Integer.valueOf(engineerPointsTextView.getText().toString())
                        + Integer.valueOf(fighterPointsTextView.getText().toString())
                        + Integer.valueOf(pilotPointsTextView.getText().toString())
                        + Integer.valueOf(traderPointsTextView.getText().toString());
                if (totalSkillPoints > 0 && Integer.valueOf(traderPointsTextView.getText().toString()) != 0) {
                    skillPoints++;
                    skillTextView.setText(skillTextView.getText().toString().substring(0, 14) + skillPoints);
                    int setTrader = Integer.parseInt(traderPointsTextView.getText().toString());
                    setTrader--;
                    traderPointsTextView.setText(String.valueOf(setTrader));
                }
            }
        });


    }

    public void onStart(View v) {
        if (validInput()) {
            String username = usernameEditText.getText().toString();
            int engineer = Integer.parseInt(engineerPointsTextView.getText().toString());
            int fighter = Integer.parseInt(fighterPointsTextView.getText().toString());
            int pilot = Integer.parseInt(pilotPointsTextView.getText().toString());
            int trader = Integer.parseInt(traderPointsTextView.getText().toString());
            Player player = new Player(username, engineer, fighter, pilot, trader, skillPoints);
            viewModel.setPlayer(player);

            Gson gson = new Gson();
            Intent intent = new Intent(this, GameActivity.class);
            intent.putExtra("PlayerData", gson.toJson(player));
            startActivity(intent);
            finish();
        }
    }

    private boolean validInput() {
        String name = usernameEditText.getText().toString().trim();
        if (skillPoints == 0  && name != null) {
            return true;
        } else if (name.length() < 1) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Please enter a valid username.",
                    Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            return false;
        } else if (skillPoints != 0) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Please allocate all skill points.",
                    Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            return false;
        }
        return false;
    }


    @Override
    public void onBackPressed() {
        if (usernameEditText.getText().toString().length() > 0 || skillPoints != 16) {
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
