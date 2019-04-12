package edu.gatech.cs2340.spacetrader.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import edu.gatech.cs2340.spacetrader.R;
import edu.gatech.cs2340.spacetrader.model.GameData;

/**
 * Displays multiple items in the cargo view, uses android Adapter
 */
public class CargoItemAdapter extends RecyclerView.Adapter<CargoItemAdapter.CargoItemViewHolder> {

    private final Map<String, Integer> cargo;
    private final List<String> sortedCargoKeys;

    /**
     * Constructor for the class
     */
    public CargoItemAdapter() {
        super();
        GameData gameData = GameData.getInstance();
        cargo = gameData.getPlayer().getShip().getCargo();
        sortedCargoKeys = new ArrayList<>(cargo.keySet());
        Log.d("APP", "We have " + sortedCargoKeys.size() + " items!");
        Collections.sort(sortedCargoKeys);
    }

    @NonNull
    @Override
    public CargoItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cargo_item_layout, viewGroup, false);

        return new CargoItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CargoItemViewHolder cargoItemHolder, int i) {
        cargoItemHolder.cargoImage.setImageResource(R.drawable.log_resource_320);
        cargoItemHolder.cargoItemName.setText(sortedCargoKeys.get(i));
        cargoItemHolder.cargoItemQuantity.setText(String.valueOf(cargo.get(sortedCargoKeys.get(i))));
    }

    @Override
    public int getItemCount() {
        return sortedCargoKeys.size();
    }

    class CargoItemViewHolder extends RecyclerView.ViewHolder {
        private final ImageView cargoImage;
        private final TextView cargoItemName;
        private final TextView cargoItemQuantity;

        CargoItemViewHolder(View itemView) {
            super(itemView);
            this.cargoImage = itemView.findViewById(R.id.cargo_img);
            this.cargoItemName = itemView.findViewById(R.id.cargo_item_name);
            this.cargoItemQuantity = itemView.findViewById(R.id.cargo_item_quantity);
        }

    }
}
