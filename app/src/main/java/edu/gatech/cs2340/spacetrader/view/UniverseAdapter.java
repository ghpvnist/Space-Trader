package edu.gatech.cs2340.spacetrader.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import edu.gatech.cs2340.spacetrader.R;
import edu.gatech.cs2340.spacetrader.model.SolarSystem;
import edu.gatech.cs2340.spacetrader.model.Universe;

public class UniverseAdapter extends RecyclerView.Adapter<UniverseAdapter.UniverseViewHolder> {

    private Universe universe;

    @NonNull
    @Override
    public UniverseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.solar_system_layout, parent, false);

        return new UniverseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UniverseViewHolder holder, int pos) {
        SolarSystem system = universe.getSolarSystem(pos);

        holder.planetImage.setImageResource(getPlanetIcon(system));
        holder.systemName.setText(system.getName());
        holder.systemLocation.setText("(" + system.getX() + ", " + system.getY() + ")");
    }

    @Override
    public int getItemCount() {
        if (universe == null) return 0;
        return universe.getNumSolarSystems();
    }

    public void setUniverse(Universe universe) {
        this.universe = universe;
    }

    private int getPlanetIcon(SolarSystem system) {
        int idx = (10000 + system.getX() + system.getY()) % 6;
        switch(idx) {
            case 0: return R.drawable.planet1;
            case 1: return R.drawable.planet2;
            case 2: return R.drawable.planet3;
            case 3: return R.drawable.planet4;
            case 4: return R.drawable.planet5;
            case 5: return R.drawable.planet6;
            default: return R.drawable.planet1;
        }
    }

    class UniverseViewHolder extends RecyclerView.ViewHolder {
        private ImageView planetImage;
        private TextView systemName;
        private TextView systemLocation;

        public UniverseViewHolder(@NonNull View itemView) {
            super(itemView);

            this.planetImage = itemView.findViewById(R.id.planetImage);
            this.systemName = itemView.findViewById(R.id.systemName);
            this.systemLocation = itemView.findViewById(R.id.systemLocation);
        }
    }
}
