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
import edu.gatech.cs2340.spacetrader.viewmodel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        this.viewModel = new MainActivityViewModel();
    }

    public void onClick(View v) {
        if (v.getId() == R.id.newAccount) {
            createAccount();
        } else if (v.getId() == R.id.loadAccount) {
            loadAccount();
        }

    }

    public void createAccount() {
        Intent intent = new Intent(this, CreateAccount.class);
        startActivity(intent);
        finish();
    }

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
