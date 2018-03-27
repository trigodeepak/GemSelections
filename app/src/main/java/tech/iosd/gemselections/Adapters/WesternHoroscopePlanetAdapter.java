package tech.iosd.gemselections.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import tech.iosd.gemselections.R;
import tech.iosd.gemselections.Retrofit.ResponseModels.Planet;

/**
 * Created by anubhavmalik on 27/03/18.
 */

public class WesternHoroscopePlanetAdapter extends RecyclerView.Adapter<WesternHoroscopePlanetAdapter.MyViewHolder> {
    private Context mContext;
    private ArrayList<Planet> obList;

    public WesternHoroscopePlanetAdapter(Context mContext, ArrayList<Planet> obList) {
        this.mContext = mContext;
        this.obList = obList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.western_horoscope_planet_item, parent, false));
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {


        if ((String.valueOf(obList.get(position).getSpeed())) == null)
            holder.planetSpeedTextView.setText("");
        else holder.planetSpeedTextView.setText(obList.get(position).getSpeed() + "");

        if (obList.get(position).getName() == null) holder.planetNameTextView.setText("");
        else {
            Log.d("TAGGER", "ADAPTER " + obList.get(position).getName());
            holder.planetNameTextView.setText((obList.get(position).getName()));
        }

        if (String.valueOf(obList.get(position).getFullDegree()) == null)
            holder.fullDegreeTextView.setText("");
        else holder.fullDegreeTextView.setText((obList.get(position).getFullDegree()) + "");

        if (String.valueOf(obList.get(position).getNormDegree()) == null)
            holder.normDegreeTextView.setText("");
        else holder.normDegreeTextView.setText((obList.get(position).getNormDegree()) + "");

        if (obList.get(position).getIsRetro() == null)
            holder.retroTextView.setText("");
        else holder.retroTextView.setText(obList.get(position).getIsRetro());

        if (String.valueOf(obList.get(position).getHouse()) == null)
            holder.houseTextView.setText("");
        else holder.houseTextView.setText((obList.get(position).getHouse()) + "");

        if (obList.get(position).getSign() == null)
            holder.signTextView.setText("");
        else holder.signTextView.setText((obList.get(position).getSign()));

    }

    @Override
    public int getItemCount() {
        return obList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView planetNameTextView, fullDegreeTextView, normDegreeTextView, planetSpeedTextView, retroTextView, signTextView, houseTextView;

        MyViewHolder(final View itemView) {
            super(itemView);

            houseTextView = itemView.findViewById(R.id.western_horoscope_item_planet_house);
            planetNameTextView = itemView.findViewById(R.id.western_horoscope_item_planet_name);
            planetSpeedTextView = itemView.findViewById(R.id.western_horoscope_item_planet_speed);
            normDegreeTextView = itemView.findViewById(R.id.western_horoscope_item_planet_norm_degree);
            fullDegreeTextView = itemView.findViewById(R.id.western_horoscope_item_planet_full_degree);
            retroTextView = itemView.findViewById(R.id.western_horoscope_item_planet_retro);
            signTextView = itemView.findViewById(R.id.western_horoscope_item_planet_sign);

        }
    }
}
