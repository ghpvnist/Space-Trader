package edu.gatech.cs2340.spacetrader.view;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;

import edu.gatech.cs2340.spacetrader.R;
import edu.gatech.cs2340.spacetrader.viewmodel.ViewCargoViewModel;

public class ViewCargoActivity extends AppCompatActivity {

    private ViewCargoViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_cargo);

        viewModel = new ViewCargoViewModel();

        TextView cargoSpaceIndicator = findViewById(R.id.cargo_space_indicator);

        SpannableStringBuilder builder = new SpannableStringBuilder();
        SpannableString availSpace = new SpannableString(String.valueOf(viewModel.getAvailableCargoSpace()));
        if (((double)viewModel.getAvailableCargoSpace())/viewModel.getMaxCargoSpace() < 0.1) {
            availSpace.setSpan(new ForegroundColorSpan(Color.RED), 0, availSpace.length(), 0);
        } else if (((double)viewModel.getAvailableCargoSpace())/viewModel.getMaxCargoSpace() < 0.33) {
            availSpace.setSpan(new ForegroundColorSpan(Color.YELLOW), 0, availSpace.length(), 0);
        }
        builder.append(availSpace);

        SpannableString sep = new SpannableString(" / ");
        builder.append(sep);

        SpannableString maxSpace = new SpannableString(String.valueOf(viewModel.getMaxCargoSpace()));
        builder.append(maxSpace);

        cargoSpaceIndicator.setText(builder, TextView.BufferType.SPANNABLE);

        RecyclerView cargoListView = findViewById(R.id.cargo_list_recycler_view);
        cargoListView.setAdapter(new CargoItemAdapter());
        cargoListView.setLayoutManager(new LinearLayoutManager(this));
        cargoListView.setHasFixedSize(true);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
