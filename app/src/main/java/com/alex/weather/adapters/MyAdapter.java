package com.alex.weather.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alex.weather.R;
import com.alex.weather.modelDB.WeatherModelDB;

import java.util.List;

/**
 * Created by alex on 22.03.18.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<WeatherModelDB> list;
    WeatherModelDB modelDB;

    public MyAdapter(List<WeatherModelDB> list) {
        this.list = list;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewData;
        public TextView textViewTemp;
        public TextView textViewPressure;
        public TextView textViewHumidity;
        public TextView textViewWeather;
        public TextView textViewDescription;
        public TextView textViewClouds;
        public TextView textViewWind;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewData = (TextView) itemView.findViewById(R.id.textViewData);
            textViewTemp = (TextView) itemView.findViewById(R.id.textViewTemp);
            textViewPressure = (TextView) itemView.findViewById(R.id.textViewPressure);
            textViewHumidity = (TextView) itemView.findViewById(R.id.textViewHumidity);
            textViewWeather = (TextView) itemView.findViewById(R.id.textViewWeather);
            textViewDescription = (TextView) itemView.findViewById(R.id.textViewDescription);
            textViewClouds = (TextView) itemView.findViewById(R.id.textViewClouds);
            textViewWind = (TextView) itemView.findViewById(R.id.textViewWind);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        modelDB = list.get(position);
        holder.textViewData.setText("Data: " + modelDB.data);
        holder.textViewTemp.setText("Temperature: " + modelDB.temp + " Celsius");
        holder.textViewPressure.setText("Pressure: " + modelDB.pressure + "hPa");
        holder.textViewHumidity.setText("Humidity: " + modelDB.humidity + "%");
        holder.textViewWeather.setText(modelDB.weather);
        holder.textViewDescription.setText("Description: " + modelDB.weatherDescription);
        holder.textViewClouds.setText("Clouds " + modelDB.clouds + "%");
        holder.textViewWind.setText("Wind: " + modelDB.windSpeed + "meter/sec");

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
