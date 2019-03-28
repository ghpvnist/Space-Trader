package edu.gatech.cs2340.spacetrader.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import edu.gatech.cs2340.spacetrader.R;
import edu.gatech.cs2340.spacetrader.model.Player;
import edu.gatech.cs2340.spacetrader.model.SolarSystem;
import edu.gatech.cs2340.spacetrader.model.Universe;

public class UniverseAdapter extends RecyclerView.Adapter<UniverseAdapter.UniverseViewHolder> {

    private Universe universe;
    private Player player;

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

        int planetIcon = getPlanetIcon(system);
        holder.planetImage.setImageResource(planetIcon);
        holder.planetImage.setTag(planetIcon);

        holder.systemName.setText(system.getName());
        holder.systemName.setTag(system);

        holder.systemLocation.setText("(" + system.getX() + ", " + system.getY() + ")");
        holder.solarSystemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UniverseAdapter.this.openTravelView(v);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (universe == null) return 0;
        return universe.getNumSolarSystems();
    }

    public void setUniverse(Universe universe) {
        this.universe = universe;
    }

    public void setPlayer(Player player) { this.player = player; }

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

    public void openTravelView(View v) {
        Intent intent = new Intent(v.getContext(), TravelViewActivity.class);
        Bundle extras = new Bundle();
        extras.putSerializable("system", (SolarSystem) v.findViewById(R.id.systemName).getTag());
        extras.putInt("planetImage", (int) v.findViewById(R.id.planetImage).getTag());
        intent.putExtras(extras);
        v.getContext().startActivity(intent);
    }

    class UniverseViewHolder extends RecyclerView.ViewHolder {
        private ImageView planetImage;
        private TextView systemName;
        private TextView systemLocation;
        private RelativeLayout solarSystemLayout;

        public UniverseViewHolder(@NonNull View itemView) {
            super(itemView);

            this.planetImage = itemView.findViewById(R.id.planetImage);
            this.systemName = itemView.findViewById(R.id.systemName);
            this.systemLocation = itemView.findViewById(R.id.systemLocation);
            this.solarSystemLayout = itemView.findViewById(R.id.solarSystemLayout);

        }
    }
}
