package edu.gatech.cs2340.spacetrader.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import edu.gatech.cs2340.spacetrader.R;
import edu.gatech.cs2340.spacetrader.viewmodel.StoreViewModel;

/**
 * Activity that displays the items sold and bought at the store
 */
public class StoreViewActivity extends AppCompatActivity {

    private StoreViewModel viewModel;
    private TextView cargoIndicatorView;
    private TextView creditsIndicatorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_view);

        this.viewModel = new StoreViewModel();

        this.cargoIndicatorView = findViewById(R.id.cargo_indicator);
        this.creditsIndicatorView = findViewById(R.id.credits_indicator);

        TextView storeName = findViewById(R.id.store_name);
        storeName.setText(this.viewModel.getStoreName());

        RecyclerView offerListView = findViewById(R.id.store_offers_view);
        offerListView.setAdapter(new StoreOfferAdapter(viewModel, this));
        offerListView.setLayoutManager(new LinearLayoutManager(this));
        offerListView.setHasFixedSize(true);
        offerListView.setOverScrollMode(View.OVER_SCROLL_NEVER);

        updateCargoIndicator();
        updateCredits();
    }

    /**
     * Updates the player's cargo after items are sold or bought
     */
    public void updateCargoIndicator() {
        this.cargoIndicatorView.setText(ViewFormatUtil.formatCargoCapacity(
                this.viewModel.getAvailableCargo(), this.viewModel.getMaxCargo(), true),
                TextView.BufferType.SPANNABLE);
    }

    /**
     * Updates the player's amount of credits after items are sold or bought
     */
    public void updateCredits() {
        this.creditsIndicatorView.setText("$" + String.valueOf(this.viewModel.getCredits()));
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
