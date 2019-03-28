package edu.gatech.cs2340.spacetrader.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import edu.gatech.cs2340.spacetrader.R;
import edu.gatech.cs2340.spacetrader.model.Store;
import edu.gatech.cs2340.spacetrader.model.TradeOffer;
import edu.gatech.cs2340.spacetrader.viewmodel.StoreViewModel;

class StoreOfferAdapter extends RecyclerView.Adapter<StoreOfferAdapter.StoreOfferViewHolder> {
    private final StoreViewActivity view;
    private final StoreViewModel viewModel;
    private final Store store;

    public StoreOfferAdapter(Store store, StoreViewModel viewModel, StoreViewActivity view) {
        super();
        this.store = store;
        this.viewModel = viewModel;
        this.view = view;
    }

    public StoreOfferAdapter(StoreViewModel viewModel, StoreViewActivity view) {
        this(viewModel.getStore(), viewModel, view);
    }

    @NonNull
    @Override
    public StoreOfferViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.store_item_layout, viewGroup, false);

        return new StoreOfferViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final StoreOfferAdapter.StoreOfferViewHolder storeOfferHolder, int i) {
        final TradeOffer offer = store.getTradeOffers()[i];

        updateOfferHolder(storeOfferHolder, offer);

        storeOfferHolder.buyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                viewModel.buyItem(offer, 1);
                view.updateCargoIndicator();
                view.updateCredits();
                updateOfferHolder(storeOfferHolder, offer);
            }
        });

        storeOfferHolder.sellButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                viewModel.sellItem(offer, 1);
                view.updateCargoIndicator();
                view.updateCredits();
                updateOfferHolder(storeOfferHolder, offer);
            }
        });
    }

    private void updateOfferHolder(StoreOfferViewHolder storeOfferHolder, TradeOffer offer) {
        storeOfferHolder.itemImage.setImageResource(R.drawable.log_resource_320);
        storeOfferHolder.itemName.setText(offer.getItemName());
        storeOfferHolder.itemPrice.setText("$" + String.valueOf(offer.getItemPrice()));
        storeOfferHolder.itemStock.setText("x" + String.valueOf(offer.getItemQuantity()));
        storeOfferHolder.itemOwned.setText(String.format("Owned: %d", viewModel.getOwnedItem(offer.getItemName())));
    }

    @Override
    public int getItemCount() {
        return store.getTradeOffers().length;
    }

    class StoreOfferViewHolder extends RecyclerView.ViewHolder {
        private final ImageView itemImage;
        private final TextView itemName;
        private final TextView itemPrice;
        private final TextView itemStock;
        private final TextView itemOwned;
        private final Button buyButton;
        private final Button sellButton;

        public StoreOfferViewHolder(View itemView) {
            super(itemView);
            this.itemImage = itemView.findViewById(R.id.store_item_image);
            this.itemName = itemView.findViewById(R.id.store_item_name);
            this.itemPrice = itemView.findViewById(R.id.store_item_price);
            this.itemStock = itemView.findViewById(R.id.store_item_stock);
            this.itemOwned = itemView.findViewById(R.id.store_item_owned);

            this.buyButton = itemView.findViewById(R.id.store_buy_button);
            this.sellButton = itemView.findViewById(R.id.store_sell_button);
        }

    }
}
