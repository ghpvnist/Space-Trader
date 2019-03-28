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

        SpannableStringBuilder ssb = ViewFormatUtil.formatCargoCapacity(viewModel.getAvailableCargoSpace(), viewModel.getMaxCargoSpace(), true);
        cargoSpaceIndicator.setText(ssb, TextView.BufferType.SPANNABLE);

        RecyclerView cargoListView = findViewById(R.id.cargo_list_recycler_view);
        cargoListView.setAdapter(new CargoItemAdapter());
        cargoListView.setLayoutManager(new LinearLayoutManager(this));
        cargoListView.setHasFixedSize(true);
        cargoListView.setOverScrollMode(View.OVER_SCROLL_NEVER);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
