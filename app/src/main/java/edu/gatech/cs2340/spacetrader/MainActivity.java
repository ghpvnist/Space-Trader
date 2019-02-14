package edu.gatech.cs2340.spacetrader;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
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
        Intent intent = new Intent(this, CreateAccount.class);
        startActivity(intent);
        finish();
    }



}
